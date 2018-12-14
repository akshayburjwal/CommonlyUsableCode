package com.example.service;

import org.springframework.stereotype.Service;

import com.example.data.Data;

@Service
public class TestService {

	public Data getData(Integer dataId) {
		Data data = new Data();
		data.setId(1);
		data.setName("Akshay");
		return data;
	}
}
