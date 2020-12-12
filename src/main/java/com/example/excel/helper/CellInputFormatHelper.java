package com.example.excel.helper;


import org.apache.poi.ss.usermodel.Cell;
import org.springframework.stereotype.Service;

@Service
public class CellInputFormatHelper {
	
	static String numeric_data ="NUMERIC";
	static String string_data ="STRING";
	
	public String CellInputToString(Cell cellData) {
		
		String data = new String();
		String cellDataType = cellData.getCellType().toString();
		System.out.println("ENUM "+cellDataType);
		if(numeric_data.equals(cellDataType)) {
			System.out.println("cell value in numeric type"+cellData.getNumericCellValue());
			data =  String.valueOf(cellData.getNumericCellValue());
			
			
			if(data.contains(".")){
				System.out.println("Before "+data);
				data = data.substring(0, data.indexOf('.')-2);
				System.out.println("After "+data);
			}
		}
		else if (string_data.equals(cellDataType)) {
			System.out.println("cell value in string type"+cellData.getStringCellValue());
			data = (cellData.getStringCellValue().trim());
		}
		else {
			System.out.println("not entered any cell type");
		}
		System.out.println("Data = "+data);
		return data;
		
	}
}
