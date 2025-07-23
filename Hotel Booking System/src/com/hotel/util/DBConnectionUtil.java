package com.hotel.util;

import java.sql.*;
import java.util.Properties;
import java.io.InputStream;

public class DBConnectionUtil {
    public static Connection getConnection() throws Exception {
        InputStream input = DBConnectionUtil.class.getClassLoader().getResourceAsStream("com/hotel/util/hotel.properties");
        Properties prop = new Properties();
        prop.load(input);
        return DriverManager.getConnection(
                prop.getProperty("db.url"),
                prop.getProperty("db.user"),
                prop.getProperty("db.password"));
    }
}
