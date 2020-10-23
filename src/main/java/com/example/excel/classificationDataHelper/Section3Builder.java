package com.example.excel.classificationDataHelper;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.excel.model.MaterialData;

@Service
public class Section3Builder {
	
	public ArrayList<ArrayList<String>> section3(MaterialData materialData){
		ArrayList<ArrayList<String>> section3List = new ArrayList<ArrayList<String>>();
		section3List.add(line1());
		section3List.add(line2());
		section3List.add(line3());
		section3List.add(line4());
		section3List.add(line5());
		section3List.add(line6());
		section3List.add(line7(materialData.getClassName()));
		return section3List;
		
	}
	
	public  ArrayList<String> line1(){
		ArrayList<String> headerList =new ArrayList<String>();
		headerList.add("SAPLCEI0");
		headerList.add("109");
		headerList.add("X");
		headerList.add("");
		headerList.add("");
		return headerList;
		
	}
	
	public  ArrayList<String> line2(){
		ArrayList<String> headerList =new ArrayList<String>();
		headerList.add("");
		headerList.add("0");
		headerList.add("");
		headerList.add("BDC_CURSOR");
		headerList.add("RCTMS-MNAME(01)");
		return headerList;
		
	}
	
	public  ArrayList<String> line3(){
		ArrayList<String> headerList =new ArrayList<String>();
		headerList.add("");
		headerList.add("0");
		headerList.add("");
		headerList.add("BDC_OKCODE");
		headerList.add("=BACK");
		return headerList;
		
	}
	
	public  ArrayList<String> line4(){
		ArrayList<String> headerList =new ArrayList<String>();
		headerList.add("SAPLMGMM");
		headerList.add("4004");
		headerList.add("X");
		headerList.add("");
		headerList.add("");
		return headerList;
		
	}
	
	public  ArrayList<String> line5(){
		ArrayList<String> headerList =new ArrayList<String>();
		headerList.add("");
		headerList.add("0");
		headerList.add("");
		headerList.add("BDC_OKCODE");
		headerList.add("=BU");
		return headerList;
		
	}
	
	public  ArrayList<String> line6(){
		ArrayList<String> headerList =new ArrayList<String>();
		headerList.add("");
		headerList.add("0");
		headerList.add("");
		headerList.add("BDC_CURSOR");
		headerList.add("MAKT-MAKTX");
		return headerList;
		
	}
	
	public  ArrayList<String> line7(String className){
		ArrayList<String> headerList =new ArrayList<String>();
		headerList.add("");
		headerList.add("0");
		headerList.add("");
		headerList.add("MARA-SATNR");
		headerList.add(className);
		return headerList;
		
	}


}
