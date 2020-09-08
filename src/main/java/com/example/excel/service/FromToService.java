package com.example.excel.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.excel.model.FromTo;

@Service
public class FromToService {

	   public ByteArrayInputStream loadFile(MultipartFile file) {
		   List<Integer> lst_data = new ArrayList<Integer>();
		   List<FromTo> fromToList = new ArrayList<FromTo>();
		   
//		1. Parse the excel to list of data
		try {
			lst_data = parseExcelFile(file.getInputStream());
			System.out.println(lst_data.toString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		2. Process the list of data
		fromToList= processFormToData(lst_data);
		System.out.println(fromToList.toString());
//		3. Covert the processed data into excel   
		try {
			ByteArrayInputStream in = fromToListToExcel(fromToList);
			return in;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
   
    }
	  
	 //Get the excel and convert them into list
		public static List<Integer> parseExcelFile(InputStream is) {
		try {
   		Workbook workbook = new XSSFWorkbook(is);
    
   		Sheet sheet = workbook.getSheet("Sheet");
   		Iterator<Row> rows = sheet.iterator();
   		
   		List<Integer> values = new ArrayList<Integer>();
   		
   		int rowNumber = 0;
   		while (rows.hasNext()) {
   			Row currentRow = rows.next();
   			
   			// skip header
   			if(rowNumber == 0) {
   				rowNumber++;
   				continue;
   			}
   			
   			Iterator<Cell> cellsInRow = currentRow.iterator();
   			Cell currentCell = cellsInRow.next();
   			int value= ((int) currentCell.getNumericCellValue());
   			
   			values.add(value);

   			
   		}
   		
   		// Close WorkBook
   		workbook.close();
   		
   		return values;
       } catch (IOException e) {
       	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
       }
	}
		
		
		//convert the list data into excel
		
		public static ByteArrayInputStream fromToListToExcel(List<FromTo> from_to_list) throws IOException {
		String[] COLUMNs = {"From", "To"};
		try(
				Workbook workbook = new XSSFWorkbook();
				ByteArrayOutputStream out = new ByteArrayOutputStream();
		){
//			CreationHelper createHelper = workbook.getCreationHelper();
	 
			Sheet sheet = workbook.createSheet("FromToSheet");
	 
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());
	 
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);
	 
			// Row for Header
			Row headerRow = sheet.createRow(0);
	 
			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}
	 
			// CellStyle for Age
//			CellStyle ageCellStyle = workbook.createCellStyle();
//			ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));
	 
			int rowIdx = 1;
			for (FromTo from_to : from_to_list) {
				Row row = sheet.createRow(rowIdx++);
	 
				row.createCell(0).setCellValue(from_to.getFrom());
				row.createCell(1).setCellValue(from_to.getTo());
			}
	 
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
	
	// Processing the from to data 
		public List<FromTo> processFormToData(List<Integer> lst_data) {
			
			ArrayList<FromTo> from_to_List =new ArrayList<FromTo>();
			
			/**
			 * Test data
			 
			from_to.setFrom(0);
			from_to.setTo(10);
			from_to_opList.add(from_to);
			from_to_opList.add(from_to);
			from_to_opList.add(from_to);
			*/
			
			if(lst_data.size() == 1)
			{
				FromTo from_to = new FromTo();
				from_to.setFrom(lst_data.get(0));
				from_to.setTo(lst_data.get(0));
				System.out.println(from_to.toString());
				from_to_List.add(from_to);
//				System.out.println(from_to_List.toString());
				
			}
			int prev,current,from,to;
			
//			Pick the first number and put in the first set from value 
			prev = lst_data.get(0);
			from= lst_data.get(0);
			
			for(int i = 1; i < lst_data.size()-1 ;i++) {
				current = lst_data.get(i);
				
//				1. current = prev+1
				if(current == prev+1) {
					prev = current;
				}
				
//				2. current != prev+1
				else {
					to = prev;
					FromTo from_to = new FromTo();
					from_to.setFrom(from);
					from_to.setTo(to);
					System.out.println(from_to.toString());
					from_to_List.add(from_to);
//					System.out.println(from_to_List.toString());
					from = current;
					prev = current;
				}
			}
//			Pick the last element and put in the last set to value
			to = prev;
			FromTo from_to = new FromTo();
			from_to.setFrom(from);
			from_to.setTo(to);
			System.out.println(from_to.toString());
			from_to_List.add(from_to);
//			System.out.println(from_to_List.toString());
			return from_to_List;
			
		}
		
		
}
