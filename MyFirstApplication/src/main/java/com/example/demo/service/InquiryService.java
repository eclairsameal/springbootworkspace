package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Inquiry;

public interface InquiryService {
	
	void save(Inquiry inquiry);  // 資料庫插入的語法是insert但常用save
	
	List<Inquiry> getAll();

}
