package com.example.excel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExcelFileController {

	  @GetMapping("/")
	    public String index() {
	        return "multipartfile/uploadform.html";
	    }
	  
	  @GetMapping("/fromTo")
	    public String fromToIndex() {
	        return "multipartfile/fromtoform.html";
	    }
	
}
