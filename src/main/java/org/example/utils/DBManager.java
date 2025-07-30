package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private  static final String URL =
            "jdbc:mysql://localhost:3306/anime_db?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "00541Raphael!";

    static {
        try{
            //Загрузка драйвера Mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e ){
            throw  new RuntimeException("Ошибка загрузки драйвера JDBC", e);
        }
    }
    // Получение соединения
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASS);
    }

}
