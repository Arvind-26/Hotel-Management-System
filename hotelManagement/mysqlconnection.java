package hotelManagement;

import java.sql.*;

public class mysqlconnection {
    Connection con;
    Statement st;

    public mysqlconnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelManagement", "root",
                    "root123");
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

    }
}
