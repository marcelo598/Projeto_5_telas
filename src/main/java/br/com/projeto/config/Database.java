package br.com.projeto.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/projeto5telas";

    private static final String USER = "postgres";

    private static final String PASSWORD = "marcelo";

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver PostgreSQL não encontrado!", e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}