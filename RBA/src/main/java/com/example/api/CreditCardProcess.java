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
		insertIntoDB(person);
        return null;
    }

	private ActionResult insertIntoDB(Person person) {
		String sql = "INSERT INTO PERSONS (NAME, SURNAME, OIB, STATUS) VALUES (?, ?, ?, ?)";
		ActionResult result = new ActionResult();
		result.setStatus(ActionResult.StatusCode.OK);
		result.setMessage("Rows updated!");
		return result;
	}

	public static void main(String[] args) {
		SpringApplication.run(CreditCardProcess.class, args);
	}

}
