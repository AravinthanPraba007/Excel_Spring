package com.example.excel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.excel.service.ClassificationDataService;

@RestController
public class ClassificationDataContoller {
	
	@Autowired
	ClassificationDataService classificationDataService;
	
	@RequestMapping(value="/classificationData", method = RequestMethod.POST)
	public ResponseEntity<InputStreamResource> uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file) {
		HttpHeaders headers = new HttpHeaders();
      headers.add("Content-Disposition", "attachment; filename=output.xlsx");
		
		return ResponseEntity
              .ok()
              .headers(headers)
              .body(new InputStreamResource(classificationDataService.loadFile(file)));	
		
	}
	
}
