package com.personal.jdbc;

import java.sql.*;

/**
 * This class handles database operations
 */
public class JDBCConnection {
  private static String url = "jdbc:mysql://127.0.0.1:3306/employees_database";

  public static void main(String[] args) {
    try {
      Connection connection = getConnection("root", "root123");
      Statement statement = connection.createStatement();

      ResultSet resultSet = statement.executeQuery("select * from employees_tbl");
      while (resultSet.next()) {
        System.out.println(resultSet.getString("name"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * @param userName username of the database
   * @param password password of the database
   * @return database connection object
   */
  private static Connection getConnection(String userName, String password) {
    Connection connection = null;
    try {
      connection = DriverManager.getConnection(url, userName, password);
      return connection;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }
}
