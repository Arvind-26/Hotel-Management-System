package hotelManagement;

import java.sql.*;

public class mysqlconnection {
    Connection con;
    Statement st;

    public mysqlconnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://jdbc:mysql://localhost:3306/hotelmanagement", "root","Rudra@mysql123");
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
