package com.async.monog.async_mongo;

import com.async.monog.async_mongo.service.BeanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.print.attribute.standard.Severity;

@SpringBootTest
class AsyncMongoApplicationTests {

	@Autowired
	BeanService service;

	@Test
	void contextLoads() {
	}

	@Test
	void run() {
		service.generateMany();
		service.showAll();

	}

	void run2() {
		service.clear();
	}

}
