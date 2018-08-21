package com.nytimes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nytimes.model.NyTimesResponse;
import com.nytimes.model.Result;

@Service
public class NyTimesService {
	
	@Autowired
	RestTemplate restemplate;
	
	@HystrixCommand(fallbackMethod = "getDefaultMostViewedResp")
	public NyTimesResponse getMostViewedResp() {
		NyTimesResponse nyTimesResponse = null;
		try {
			nyTimesResponse = restemplate.getForObject("http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=084608dd4e504f4dbbdcd5caa49e8e1e",
					NyTimesResponse.class);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return nyTimesResponse;
	}
	
	public NyTimesResponse getDefaultMostViewedResp() {
		Result result = new Result();
		result.setId(1L);
		result.setTitle("Dummy");
		List<Result> resultList = new ArrayList<Result>();
		resultList.add(result);
		NyTimesResponse nyTimesResponse = new NyTimesResponse();
		nyTimesResponse.setStatus("Dummy Response");
		nyTimesResponse.setNumResults(1L);
		nyTimesResponse.setResults(resultList);
		return nyTimesResponse;
	}

}
