package com.example.excel.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.excel.classificationDataHelper.HeaderBuilder;
import com.example.excel.classificationDataHelper.Section1Builder;
import com.example.excel.classificationDataHelper.Section2Builder;
import com.example.excel.classificationDataHelper.Section3Builder;
import com.example.excel.model.MaterialData;

@Service
public class ClassificationDataService {

	@Autowired
	HeaderBuilder buildHeader;
	@Autowired
	Section3Builder buildSection3;
	@Autowired
	Section1Builder buildSection1;
	@Autowired
	Section2Builder buildSection2;

	public ByteArrayInputStream loadFile(MultipartFile file) {

		ArrayList<MaterialData> material_datas = new ArrayList<MaterialData>();

//		 1. Read all data convert them into material object
		try {
			material_datas = parseExcelFile(file.getInputStream());
//				System.out.println(lst_data.toString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

//			 2. Process and Store the result data into output excel   
		try {
			ByteArrayInputStream in = ClassificationDataToExcel(material_datas);
			return in;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

//	     1. Read all data convert them into material object
	public ArrayList<MaterialData> parseExcelFile(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);
			DataFormatter formatter = new DataFormatter();
			Sheet sheet = workbook.getSheet("RAWDATA");
			Iterator<Row> rows = sheet.iterator();

			ArrayList<MaterialData> values = new ArrayList<MaterialData>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				// skip header
				if (rowNumber < 3) {
					rowNumber++;
					continue;
				}
				MaterialData material = new MaterialData();
				Iterator<Cell> cellsInRow = currentRow.iterator();
				int columnNumber = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();
					if (columnNumber == 0)
						material.setMaterialId((long) currentCell.getNumericCellValue());
					else if (columnNumber == 1)
						material.setClassName(formatter.formatCellValue(currentCell));
					else if (columnNumber == 2)
						material.setCharacter(formatter.formatCellValue(currentCell));
					else if (columnNumber == 3)
						material.setValue(formatter.formatCellValue(currentCell));
					columnNumber++;
				}

				if (material.getMaterialId() != 0) {
//					System.out.println(material);
					values.add(material);
				}

			}

			// Close WorkBook
			workbook.close();
			System.out.println("Total Count " + values.size());
			System.out.println("First Element " + values.get(0));
			System.out.println("Last Element " + values.get(values.size() - 1));
			return values;
		} catch (IOException e) {
			throw new RuntimeException("FAIL! -> message = " + e.getMessage());
		}
	}

	/**
	 * 1. Check if currentData is not equal to previousData true -> 1.1.a Check if
	 * the read row is first ->true --> 1.a.i Build the Header ->false --> 1.a.ii
	 * Build the Section 3 (previous data) 1.1.b Build the Section 1 (current data)
	 * 1.1.c Build the Section 2 (current data) false -> 1.2.a Build Section
	 * 2(current data) 2. Set previous data = current data 3. If EOF -> Build
	 * Section 3 (previous data) [last element]
	 */

//		2. Build the sections and Store the result data into output excel 
	public ByteArrayInputStream ClassificationDataToExcel(ArrayList<MaterialData> material_datas) throws IOException {

		MaterialData currentData = new MaterialData();
		MaterialData previousData = new MaterialData();
		boolean firstRow = true;
		int rowIdx = 0;

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet("Result");

			for (int i = 0; i < material_datas.size(); i++) {

				MaterialData materialData = material_datas.get(i);
				currentData = materialData;

				System.out.println(" previous data" + previousData.getMaterialId());
				System.out.println(" current data" + currentData.getMaterialId());

				/**
				 * 1. Check if currentData is not equal to previousData true -> 1.1.a Check if
				 * the read row is first ->true --> 1.a.i Build the Header ->false --> 1.a.ii
				 * Build the Section 3 (previous data)
				 */

				if (!(currentData.getMaterialId()).equals(previousData.getMaterialId())) {
					if (firstRow) {
						firstRow = false;
						System.out.println("Building header");
						ArrayList<String> headerResultRowData = new ArrayList<String>();
						headerResultRowData = buildHeader.header();
						Row row = sheet.createRow(rowIdx++);
						int colIdx = 0;
						for (String rowData : headerResultRowData) {
							row.createCell(colIdx++).setCellValue(rowData);
						}
						headerResultRowData.clear();
					}

					else {
						System.out.println("Building section 3");
						ArrayList<ArrayList<String>> section3Data = new ArrayList<ArrayList<String>>();
						section3Data = buildSection3.section3(previousData);
						for (ArrayList<String> resultRowData : section3Data) {
							Row row = sheet.createRow(rowIdx++);
							int colIdx = 0;
							for (String rowData : resultRowData) {
								row.createCell(colIdx++).setCellValue(rowData);
							}
						}
						section3Data.clear();
					}

					/**
					 * 1.1.b Build the Section 1 (current data) 
					 * 1.1.c Build the Section 2 (current data)
					 */

					System.out.println("Building section 1");
					ArrayList<ArrayList<String>> section1Data = new ArrayList<ArrayList<String>>();
					section1Data = buildSection1.section1(currentData);
					for (ArrayList<String> resultRowData : section1Data) {
						Row row = sheet.createRow(rowIdx++);
						int colIdx = 0;

						for (String rowData : resultRowData) {
							row.createCell(colIdx++).setCellValue(rowData);
						}
					}
					section1Data.clear();

					System.out.println("Building section 2");
					ArrayList<ArrayList<String>> section2Data = new ArrayList<ArrayList<String>>();
					section2Data = buildSection2.section2(currentData);
					for (ArrayList<String> resultRowData : section2Data) {
						Row row = sheet.createRow(rowIdx++);
						int colIdx = 0;
						for (String rowData : resultRowData) {
							row.createCell(colIdx++).setCellValue(rowData);
						}
					}
					section2Data.clear();

				}

				/**
				 * 1. Check if currentData is not equal to previousData false -> 1.2.a Build
				 * Section 2(current data)
				 */

				else {

					System.out.println("Building section 2");
					ArrayList<ArrayList<String>> section2Data = new ArrayList<ArrayList<String>>();
					section2Data = buildSection2.section2(currentData);
					for (ArrayList<String> resultRowData : section2Data) {
						Row row = sheet.createRow(rowIdx++);
						int colIdx = 0;
						for (String rowData : resultRowData) {
							row.createCell(colIdx++).setCellValue(rowData);
						}
					}
					section2Data.clear();
				}

				/**
				 * 2. Set previous data = current data
				 */
				previousData = currentData;

			}

			/**
			 * 3. If EOF -> Build Section 3 (previous data) [last element]
			 */

			System.out.println("Building section 3");
			ArrayList<ArrayList<String>> section3Data = new ArrayList<ArrayList<String>>();
			section3Data = buildSection3.section3(previousData);
			for (ArrayList<String> resultRowData : section3Data) {
				Row row = sheet.createRow(rowIdx++);
				int colIdx = 0;
				for (String rowData : resultRowData) {
					row.createCell(colIdx++).setCellValue(rowData);
				}
			}
			section3Data.clear();

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}

	public void checkArrayEmpty(ArrayList<String> resultRowData) {
		if (resultRowData.size() != 0)
			System.out.println("list as some element size is = " + resultRowData.size());
		else
			return;
	}

}
