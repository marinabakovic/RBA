package com.example.api;

import com.example.dto.ActionResult;
import com.example.dto.Person;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/creditCard")
@ImportResource("classpath:config/liquibase/master.xml")
public class CreditCardProcess {

  @PostMapping("/addPerson")
  public ActionResult addPersonForCreatingCreditCard(
    @RequestBody Person person
  ) {
    insertIntoDB(person);
    return null;
  }

  private ActionResult insertIntoDB(Person person) {
    String sql =
      "INSERT INTO PERSONS (NAME, SURNAME, OIB, STATUS) VALUES (?, ?, ?, ?)";
    try {
      String url = "${spring.datasource.url}";
      String username = "${spring.datasource.username}";
      String password = "${spring.datasource.password}";

      Connection connection = DriverManager.getConnection(url, username, password);

      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, person.getName());
      preparedStatement.setString(2, person.getSurname());
      preparedStatement.setString(3, person.getOib());
      preparedStatement.setString(4, "ACTIVE");

      int rowCount = preparedStatement.executeUpdate();

      if (rowCount > 0) {
        ActionResult result = new ActionResult();
        result.setStatus(ActionResult.StatusCode.OK);
        result.setMessage("Rows updated!");
        return result;
      }
    } catch (final Exception e) {
      ActionResult result = new ActionResult();
      result.setStatus(ActionResult.StatusCode.ERROR);
      result.setMessage("Rows not updated!");
      return result;
    }
    return null;
  }

  public static void main(String[] args) {
    SpringApplication.run(CreditCardProcess.class, args);
  }
}
