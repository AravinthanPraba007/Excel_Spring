package com.example.excel.deleteProdHelper.withComp;

import java.util.ArrayList;

import org.springframework.stereotype.Service;


@Service
public class DPWCSection1Builder {


	public ArrayList<ArrayList<String>> section1(String key) {
		ArrayList<ArrayList<String>> section1List = new ArrayList<ArrayList<String>>();
		section1List.add(line1());
		section1List.add(line2());
		section1List.add(line3());
		section1List.add(line4());
		section1List.add(line5(key));
		section1List.add(line6());
		section1List.add(line7());
		section1List.add(line8());
		section1List.add(line9());
		section1List.add(line10());
		section1List.add(line11());
		section1List.add(line12());
		section1List.add(line13());
		section1List.add(line14());
		section1List.add(line15());
		section1List.add(line16());

		return section1List;
	}

	public ArrayList<String> line1() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("TCO02");
		headerList.add("");
		return headerList;
	}

	public ArrayList<String> line2() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("SAPLCOKO1");
		headerList.add("011");
		headerList.add("0");
		headerList.add("X");
		headerList.add("");
		return headerList;

	}

	public ArrayList<String> line3() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("BDC_CURSOR");
		headerList.add("CAUFVD-AUFNR");
		return headerList;

	}

	public ArrayList<String> line4() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("BDC_OKCODE");
		headerList.add("/00");
		return headerList;
	}

	public ArrayList<String> line5(String productionNo) {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("CAUFVD-AUFNR");
		headerList.add(productionNo);
		return headerList;
	}

	public ArrayList<String> line6() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("R62CLORD-FLG_KNOT");
		headerList.add("X");
		return headerList;
	}

	public ArrayList<String> line7() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("R62CLORD-FLG_OVIEW");
		headerList.add("");
		return headerList;
	}
	
	public ArrayList<String> line8() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("SAPLCOKO1");
		headerList.add("011");
		headerList.add("5");
		headerList.add("X");
		headerList.add("");
		return headerList;
	}
	
	public ArrayList<String> line9() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("BDC_SUBSCR");
		headerList.add("=VGUE");
		return headerList;
	}
	
	public ArrayList<String> line10() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("BDC_SUBSCR");
		headerList.add("SAPLCOKO1                               0120SUBSCR_0115");
		return headerList;
	}

	public ArrayList<String> line11() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("BDC_CURSOR");
		headerList.add("CAUFVD-GAMNG");
		return headerList;
	}
	
	public ArrayList<String> line12() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("SAPLCOVG");
		headerList.add("010");
		headerList.add("0");
		headerList.add("X");
		headerList.add("");
		return headerList;
	}
	
	public ArrayList<String> line13() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("BDC_CURSOR");
		headerList.add("AFVGD-VORNR(01)");
		return headerList;
	}
	
	public ArrayList<String> line14() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("BDC_OKCODE");
		headerList.add("=AUFS");
		return headerList;
	}
	
	public ArrayList<String> line15() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("BDC_SUBSCR");
		headerList.add("SAPLCOVG                                0801ORD_HEADER");
		return headerList;
	}
	
	public ArrayList<String> line16() {
		ArrayList<String> headerList = new ArrayList<String>();
		headerList.add("");
		headerList.add("000");
		headerList.add("0");
		headerList.add("BDC_SUBSCR");
		headerList.add("SAPLCOVG                                0050BUTTONS");
		return headerList;
	}
}
