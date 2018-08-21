package com.test;

import java.util.ArrayList;
import java.util.List;

import com.nytimes.model.NyTimesResponse;
import com.nytimes.model.Result;

public class CommonUtil {

	public static NyTimesResponse getDefaultMostViewedResp() {
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
