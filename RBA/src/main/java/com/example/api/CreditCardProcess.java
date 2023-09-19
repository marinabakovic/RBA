package com.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ActionResult;
import com.example.dto.Person;

@SpringBootApplication
@RestController
@RequestMapping("/creditCard")
public class CreditCardProcess {

	 @PostMapping("/addPerson")
	 public ActionResult addPersonForCreatingCreditCard(@RequestBody Person person) {
        return null;
    }

	public static void main(String[] args) {
		SpringApplication.run(CreditCardProcess.class, args);
	}

}
