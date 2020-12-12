package com.example.excel.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.excel.deleteProdHelper.WithoutCompAllDataBuilder;
import com.example.excel.helper.CellInputFormatHelper;

@Service
public class DeleteProdWithoutCompAllService {
	
	@Autowired
	WithoutCompAllDataBuilder dataBuilder;
	
//	@Autowired
//	static
//	CellInputFormatHelper cellFormatorHelper;
	


	   public ByteArrayInputStream loadFile(MultipartFile file) {
		   System.out.println("Entering DeleteProdWithout CompAllService");
		   
		   Map<String, List<String>> prod_lst_data = new HashMap<String, List<String>>();
		   
//		1. Parse the excel to list of data
		try {
			System.out.println("Entering DeleteProdWithout CompAllService parseExcelFile ");
			prod_lst_data = parseExcelFile(file.getInputStream());
			System.out.println("Product list"+prod_lst_data);
//			System.out.println(lst_data.toString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		2. Covert the processed data and feed to the output excel   
		try {
			ByteArrayInputStream in = processDataToExcel(prod_lst_data);
			return in;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

 }
	  
	 //Get the excel and convert them into list
		public static Map<String, List<String>> parseExcelFile(InputStream is) {
		try {
		Workbook workbook = new XSSFWorkbook(is);
 
		Sheet sheet = workbook.getSheet("RAWDATA");
		Iterator<Row> rows = sheet.iterator();
		
		Map<String, List<String>> prodOperationMap = new TreeMap<String, List<String>>();   
		
		int rowNumber = 0;
		while (rows.hasNext()) {
			Row currentRow = rows.next();
			
			// skip header
			if(rowNumber == 0) {
				rowNumber++;
				continue;
			}
			
			Iterator<Cell> cellsInRow = currentRow.iterator();
			int columnNumber = 0;
			String key = new String();
			String value = new String();
			while (cellsInRow.hasNext()) {
				System.out.println("Row = "+rowNumber+" column = "+columnNumber);
				Cell currentCell = cellsInRow.next();
				if (columnNumber == 0) {
					System.out.println(currentCell.getCellType());
					key = CellInputToString(currentCell);
				} 
					
				else if (columnNumber == 1) {
					System.out.println(currentCell.getCellType());
					value = CellInputToString(currentCell);
				}
				
				columnNumber++;
				
			}
			System.out.println("Key= "+key+" value= "+value);
			if(!key.isEmpty() && !value.isEmpty()) {
				if(prodOperationMap.containsKey(key)) {
					List<String> data = prodOperationMap.get(key);
					data.add(value);
					prodOperationMap.put(key, data);
				}
				
				else {
					List<String> data = new ArrayList<String>();
					data.add(value);
					prodOperationMap.put(key, data);
				}
			}
			
			System.out.println(prodOperationMap);
			
			rowNumber++;

			
		}
		
		// Close WorkBook
		workbook.close();
		
		return prodOperationMap;
    } catch (IOException e) {
    	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
    }
	}
		
		public static String CellInputToString(Cell cellData) {
			String numeric_data ="NUMERIC";
			String string_data ="STRING";
			String data = new String();
			String cellDataType = cellData.getCellType().toString();
			System.out.println("ENUM "+cellDataType);
			if(numeric_data.equals(cellDataType)) {
				System.out.println("cell value in numeric type"+cellData.getNumericCellValue());
				data =String.valueOf(cellData.getNumericCellValue());
				if(data.contains(".")){
					System.out.println("Before "+data);
					data = data.substring(0, data.indexOf('.'));
					System.out.println("After "+data);
				}
			}
			else if (string_data.equals(cellDataType)) {
				System.out.println("cell value in string type "+cellData.getStringCellValue());
				data = (cellData.getStringCellValue().trim());
			}
			else {
				System.out.println("not entered any cell type");
			}
			System.out.println("Data = "+data);
			return data;
			
		}
		
		//convert the list data into excel
		
		public ByteArrayInputStream processDataToExcel(Map<String, List<String>> prod_lst_data) throws IOException {
			System.out.println("Entering Process data to excel function");
			int rowIdx = 0;

			try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
				Sheet sheet = workbook.createSheet("Result");

				for (Entry<String, List<String>> prod_data : prod_lst_data.entrySet()) {
//			          System.out.println("Key: "+prod_data.getKey() + " & Value: " + prod_data.getValue());
					String key = prod_data.getKey();
					List<String> value = new ArrayList<String>();
					value = prod_data.getValue();
					
					/**
					 * 1.1 Build the Section 1 ( Single Set header) 
					 * 1.2 Build the Section 2 ( Multiple Set Body)
					 * 1.3 Build the Section 3 ( Single set footer)
					 */
					int productionCount = 0;
					System.out.println("Building set "+productionCount+" section 1 -  Set header");
					ArrayList<ArrayList<String>> section1Data = new ArrayList<ArrayList<String>>();
					section1Data =  dataBuilder.section1(key);
					for (ArrayList<String> resultRowData : section1Data) {
						Row row = sheet.createRow(rowIdx++);
						int colIdx = 0;

						for (String rowData : resultRowData) {
							row.createCell(colIdx++).setCellValue(rowData);
						}
					}
					section1Data.clear();
					
					

					
					int operationCount = 0;
					for(String operationNo : value) {
						System.out.println("Building set "+productionCount+" section 2 -  Set body set "+operationCount);
						ArrayList<ArrayList<String>> section2Data = new ArrayList<ArrayList<String>>();
						section2Data =  dataBuilder.section2(operationNo);
						for (ArrayList<String> resultRowData : section2Data) {
							Row row = sheet.createRow(rowIdx++);
							int colIdx = 0;

							for (String rowData : resultRowData) {
								row.createCell(colIdx++).setCellValue(rowData);
							}
						}
						section2Data.clear();
						operationCount++;
					}
					
					

					System.out.println("Building set "+productionCount+" section 3 -  Set footer");
					ArrayList<ArrayList<String>> section3Data = new ArrayList<ArrayList<String>>();
					section3Data =  dataBuilder.section3();
					for (ArrayList<String> resultRowData : section3Data) {
						Row row = sheet.createRow(rowIdx++);
						int colIdx = 0;

						for (String rowData : resultRowData) {
							row.createCell(colIdx++).setCellValue(rowData);
						}
					}
					section3Data.clear();
					productionCount++;
			        }

				workbook.write(out);
				return new ByteArrayInputStream(out.toByteArray());
			}
	}
	

		

	
}
