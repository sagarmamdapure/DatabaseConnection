package com.personal.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class JDBCConnection {
  public static void main(String[] args) {
    String url = "jdbc:mysql://127.0.0.1:3306/employees_database";
    try {
      Connection connection = DriverManager.getConnection(url, "root", "root123");
      Statement statement = connection.createStatement();

      ResultSet resultSet = statement.executeQuery("select * from employees_tbl");
      while (resultSet.next()) {
        System.out.println(resultSet.getString("name"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
