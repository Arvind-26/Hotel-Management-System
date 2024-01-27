package hotelManagement;

import java.sql.*;

public class mysqlconnection {
    Connection con;
    Statement st;

    public mysqlconnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com:3306/sql6680092", "sql6680092",
                    "LtKERhZgen");
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new mysqlconnection();
    }
}
