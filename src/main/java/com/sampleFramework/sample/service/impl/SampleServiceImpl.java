package com.sampleFramework.sample.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sampleFramework.sample.service.SampleService;
import com.sampleFramework.sample.service.dao.SampleDAO;

@Service("SampleService")
public class SampleServiceImpl implements SampleService {
	
	@Resource(name = "SampleDAO")
	private SampleDAO sampleDAO;
	
	public String getForDatabaseTest() throws Exception {
		
		return sampleDAO.getForDatabaseTest();
	}
	
}
