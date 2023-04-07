package com.example.demo;

import com.example.demo.hackerNewsItem.Item;
import com.example.demo.hackerNewsItem.ItemService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private ItemService itemService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	public void init() {
		for (int id = 1; id < 200; id++) {
			float progress = ((float)id/200)*100;
			System.out.println("Progress: " + progress + "%");

			itemService.addItem(id);
		}
	}




}
