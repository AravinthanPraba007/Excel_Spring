package com.example.excel.deleteProdHelper.withComp;

import java.util.ArrayList;

import org.springframework.stereotype.Service;


@Service
public class DPWCSection3Builder {


	public ArrayList<ArrayList<String>> section3() {
		ArrayList<ArrayList<String>> section1List = new ArrayList<ArrayList<String>>();
		section1List.add(line1());
		section1List.add(line2());
		section1List.add(line3());
		section1List.add(line4());
		section1List.add(line5());
		section1List.add(line6());
		section1List.add(line7());


		return section1List;
	}

	public ArrayList<String> line1() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("SAPLSPO2");
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
		headerList.add("BDC_OKCODE");
		headerList.add("=OPT1");
		return headerList;

	}

	public ArrayList<String> line3() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("SAPLCOVG");
		headerList.add("010");
		headerList.add("0");
		headerList.add("X");
		headerList.add("");
		return headerList;

	}

	public ArrayList<String> line4() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("BDC_CURSOR");
		headerList.add("AFVGD-VORNR(01)");
		return headerList;
	}

	public ArrayList<String> line5() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("BDC_OKCODE");
		headerList.add("=BU");
		return headerList;
	}

	public ArrayList<String> line6() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("BDC_SUBSCR");
		headerList.add("SAPLCOVG                                0801ORD_HEADER");
		return headerList;
	}

	public ArrayList<String> line7() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("BDC_SUBSCR");
		headerList.add("SAPLCOVG                                0050BUTTONS");
		return headerList;
	}
	

}
