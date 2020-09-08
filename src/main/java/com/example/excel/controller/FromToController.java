package com.example.excel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.excel.service.FromToService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

@RestController
public class FromToController {
	
	@Autowired
	FromToService fromToService;

	@RequestMapping(value="/fromTo", method = RequestMethod.POST)
	public ResponseEntity<InputStreamResource> uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file) {
		HttpHeaders headers = new HttpHeaders();
      headers.add("Content-Disposition", "attachment; filename=customers.xlsx");
		
		return ResponseEntity
              .ok()
              .headers(headers)
              .body(new InputStreamResource(fromToService.loadFile(file)));	
		
	}
}
