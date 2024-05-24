package com.group_3.restful_group_3_project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloBookController {
	
	@GetMapping(path = "/hello-book")
	public String helloBook(){
		return "this is my book";
	}

}
