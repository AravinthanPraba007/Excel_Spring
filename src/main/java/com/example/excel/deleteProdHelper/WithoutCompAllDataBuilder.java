package com.example.excel.deleteProdHelper;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.excel.deleteProdHelper.withoutComp.DPWoCSection1Builder;
import com.example.excel.deleteProdHelper.withoutComp.DPWoCSection2Builder;
import com.example.excel.deleteProdHelper.withoutComp.DPWoCSection3Builder;


@Service
public class WithoutCompAllDataBuilder {

	@Autowired
	DPWoCSection1Builder section1Builder;
	
	@Autowired
	DPWoCSection2Builder section2Builder;
	
	@Autowired
	DPWoCSection3Builder section3Builder;
	
	
	public ArrayList<ArrayList<String>> section1(String key) {
		ArrayList<ArrayList<String>> section1List = new ArrayList<ArrayList<String>>();
		
		section1List = section1Builder.section1(key);

		return section1List;
	}
	
	public ArrayList<ArrayList<String>> section2(String operationNo) {
		ArrayList<ArrayList<String>> section2List = new ArrayList<ArrayList<String>>();
		
		section2List = section2Builder.section2(operationNo);

		return section2List;
	}

	
	
	public ArrayList<ArrayList<String>> section3() {
		ArrayList<ArrayList<String>> section3List = new ArrayList<ArrayList<String>>();
		
		section3List = section3Builder.section3();

		return section3List;
	}

	
}
