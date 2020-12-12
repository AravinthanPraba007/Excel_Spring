package com.example.excel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExcelFileController {

	  @GetMapping("/")
	    public String index() {
	        return "multipartfile/home.html";
	    }
	  
	  @GetMapping("/fromTo")
	    public String fromToIndex() {
	        return "multipartfile/fromtoform.html";
	    }
	  
	  @GetMapping("/classificationData")
	    public String classificationData() {
	        return "multipartfile/classificationdataform.html";
	    }
	
	  @GetMapping("/deleteProductionOrder")
	  public String deleteProductionData() {
		  return "multipartfile/deleteproductionorder.html";
	  }
	  
	  @GetMapping("/deleteProductionOrder/withCompAllocation")
	  public String deleteProductionWithCompAll() {
		  return "multipartfile/deleteProdWithComp";
	  }
	  
	  @GetMapping("/deleteProductionOrder/withoutCompAllocation")
	  public String deleteProductionWithoutCompAll() {
		  return "multipartfile/deleteProdWithoutComp";
	  }
}
