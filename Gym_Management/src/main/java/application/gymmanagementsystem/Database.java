package application.gymmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

      public static Connection connectDb() {
            try {
                  Class.forName("com.mysql.cj.jdbc.Driver");

                  Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/gym_management", "USERNAME", "PASSWORD");
                  return connect;
            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error connecting to the database.");
                  return null;
            }
      }

}
