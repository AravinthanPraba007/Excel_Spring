package com.example.excel.classificationDataHelper;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.excel.model.MaterialData;

@Service
public class Section1Builder {

	public ArrayList<ArrayList<String>> section1(MaterialData materialData) {
		ArrayList<ArrayList<String>> section1List = new ArrayList<ArrayList<String>>();
		section1List.add(line1());
		section1List.add(line2());
		section1List.add(line3());
		section1List.add(line4(String.valueOf(materialData.getMaterialId())));
		section1List.add(line5());
		section1List.add(line6());
		section1List.add(line7());
		section1List.add(line8());
		section1List.add(line9());
		section1List.add(line10());
		section1List.add(line11());
		section1List.add(line12(materialData.getClassName()));

		return section1List;
	}

	public ArrayList<String> line1() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("SAPLMGMM");
		headerList.add("60");
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
		headerList.add("RMMG1-MATNR");
		return headerList;

	}

	public ArrayList<String> line3() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("0");
		headerList.add("");
		headerList.add("BDC_OKCODE");
		headerList.add("=ENTR");
		return headerList;

	}

	public ArrayList<String> line4(String materialID) {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("0");
		headerList.add("");
		headerList.add("RMMG1-MATNR");
		headerList.add(materialID);
		return headerList;
	}

	public ArrayList<String> line5() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("SAPLMGMM");
		headerList.add("70");
		headerList.add("X");
		headerList.add("");
		headerList.add("");
		return headerList;
	}

	public ArrayList<String> line6() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("0");
		headerList.add("");
		headerList.add("BDC_CURSOR");
		headerList.add("MSICHTAUSW-DYTXT(02)");
		return headerList;
	}

	public ArrayList<String> line7() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("0");
		headerList.add("");
		headerList.add("BDC_OKCODE");
		headerList.add("=ENTR");
		return headerList;
	}

	public ArrayList<String> line8() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("0");
		headerList.add("");
		headerList.add("MSICHTAUSW-KZSEL(02)");
		headerList.add("X");
		return headerList;
	}

	public ArrayList<String> line9() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("SAPLMGMM");
		headerList.add("4004");
		headerList.add("X");
		headerList.add("");
		headerList.add("");
		return headerList;
	}

	public ArrayList<String> line10() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("0");
		headerList.add("");
		headerList.add("BDC_OKCODE");
		headerList.add("=PB21");
		return headerList;
	}

	public ArrayList<String> line11() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("0");
		headerList.add("");
		headerList.add("BDC_CURSOR");
		headerList.add("MARA-SATNR");
		return headerList;
	}
	
	public ArrayList<String> line12(String className) {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("0");
		headerList.add("");
		headerList.add("MARA-SATNR");
		headerList.add(className);
		return headerList;
	}
	
}
