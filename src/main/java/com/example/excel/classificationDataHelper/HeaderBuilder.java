package com.example.excel.classificationDataHelper;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class HeaderBuilder {
	
	public  ArrayList<String> header(){
		ArrayList<String> headerList =new ArrayList<String>();
		headerList.add("");
		headerList.add("0");
		headerList.add("T");
		headerList.add("MM02");
		headerList.add("");
		return headerList;
		
	}

}
