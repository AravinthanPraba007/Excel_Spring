package com.example.excel.classificationDataHelper;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.excel.model.MaterialData;

@Service
public class Section2Builder {

	public ArrayList<ArrayList<String>> section2(MaterialData materialData) {
		ArrayList<ArrayList<String>> section2List = new ArrayList<ArrayList<String>>();
		section2List.add(line1());
		section2List.add(line2());
		section2List.add(line3());
		section2List.add(line4(materialData.getCharacter()));
		section2List.add(line5(materialData.getValue()));
		return section2List;
	}
	
	public ArrayList<String> line1() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("SAPLCEI0");
		headerList.add("109");
		headerList.add("X");
		headerList.add("");
		headerList.add("");
		return headerList;
	}
	
	public ArrayList<String> line2() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("0");
		headerList.add("");
		headerList.add("BDC_CURSOR");
		headerList.add("RCTMS-MWERT(01)");
		return headerList;
	}
	
	public ArrayList<String> line3() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("0");
		headerList.add("");
		headerList.add("BDC_OKCODE");
		headerList.add("/00");
		return headerList;
	}
	
	public ArrayList<String> line4(String character) {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("0");
		headerList.add("");
		headerList.add("RCTMS-MNAME(01)");
		headerList.add(character);
		return headerList;
	}
	
	public ArrayList<String> line5(String value) {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("0");
		headerList.add("");
		headerList.add("RCTMS-MNAME(01)");
		headerList.add(value);
		return headerList;
	}
	
}
