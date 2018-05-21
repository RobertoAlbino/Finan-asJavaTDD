package com.esucri.financa.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseContext {    
    private static final String SERVER = "jdbc:mysql://localhost:3306/financas";
    private static final String LOGIN = "root";
    private static final String SENHA = "";
    private static Connection context = null;
    
    public static Connection getContext() throws SQLException {
        return context == null ? DriverManager.getConnection(SERVER, LOGIN, SENHA) : context;
    }
}
