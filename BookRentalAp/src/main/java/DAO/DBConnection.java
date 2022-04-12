package DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

    public static Connection dbConnected() {
        Connection conn = null;
        try {
            Properties props = new Properties();
            InputStream file = new FileInputStream("C://Users//gradu//Desktop//BookRentalAp//src//main//resources//DBUtil.properties");
            props.load(file);

            String dbUrl = props.getProperty("url");
            String dbUser = props.getProperty("user");
            String dbPassword = props.getProperty("password");
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            if(conn != null){
//                System.out.println("Database successfully connected ");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
}






















