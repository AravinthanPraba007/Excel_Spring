package com.example.excel.deleteProdHelper.withComp;

import java.util.ArrayList;

import org.springframework.stereotype.Service;


@Service
public class DPWCSection2Builder {


	public ArrayList<ArrayList<String>> section2(String operationNo) {
		ArrayList<ArrayList<String>> section1List = new ArrayList<ArrayList<String>>();
		section1List.add(line1());
		section1List.add(line2());
		section1List.add(line3());
		section1List.add(line4(operationNo));
		section1List.add(line5());
		section1List.add(line6());
		section1List.add(line7());
		section1List.add(line8());
		section1List.add(line9());
		section1List.add(line10());

		return section1List;
	}

	public ArrayList<String> line1() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("SAPLCO05");
		headerList.add("010");
		headerList.add("0");
		headerList.add("X");
		headerList.add("");
		return headerList;
	}

	public ArrayList<String> line2() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("BDC_CURSOR");
		headerList.add("RCOSU-VORNR");
		return headerList;

	}

	public ArrayList<String> line3() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("BDC_OKCODE");
		headerList.add("=MORE");
		return headerList;

	}

	public ArrayList<String> line4(String operationNo) {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("RCOSU-VORNR");
		headerList.add(operationNo);
		return headerList;
	}

	public ArrayList<String> line5() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("SAPLCOVG");
		headerList.add("010");
		headerList.add("0");
		headerList.add("X");
		headerList.add("");
		return headerList;
	}

	public ArrayList<String> line6() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("BDC_CURSOR");
		headerList.add("AFVGD-VORNR(01)");
		return headerList;
	}

	public ArrayList<String> line7() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("BDC_OKCODE");
		headerList.add("=AUFS");
		return headerList;
	}

	public ArrayList<String> line8() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("RC27X-FLG_SEL(01)");
		headerList.add("X");
		return headerList;
	}

	public ArrayList<String> line9() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("BDC_SUBSCR");
		headerList.add("SAPLCOVG                                0801ORD_HEADER");
		return headerList;
	}

	public ArrayList<String> line10() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("BDC_SUBSCR");
		headerList.add("SAPLCOVG                                0050BUTTONS");
		return headerList;
	}


}
