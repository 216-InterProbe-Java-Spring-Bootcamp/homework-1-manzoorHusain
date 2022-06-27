package com.manzoor.interprobe.homeworkOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HomeworkOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeworkOneApplication.class, args);
		System.out.println("This is working..");
	}

	@GetMapping("/home")
	public  String home(){return "working project homework one! It is working fine.";}

}
