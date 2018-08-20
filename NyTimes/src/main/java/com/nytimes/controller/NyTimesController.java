package com.nytimes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nytimes.model.NyTimesResponse;
import com.nytimes.service.NyTimesService;

@RestController
public class NyTimesController {

	@Autowired
	NyTimesService nyTimesService;
	

	@GetMapping("/getResponse")
	@ResponseBody
	public NyTimesResponse getMostViewedResp() {
		NyTimesResponse NyTimesResponse = nyTimesService.getMostViewedResp();
		return NyTimesResponse;
	}
	
	

}
