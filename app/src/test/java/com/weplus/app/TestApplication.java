package com.weplus.app;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);

    }

    // Percorso al database H2 configurato
    private static final String JDBC_URL = "jdbc:h2:file:./data/testdb";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "";

    @Test
    public void testDatabaseInitialization() throws Exception {
        // Connessione al database H2
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            // Esegui una query per verificare l'inizializzazione del database
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS row_count FROM PERSON");

            // Verifica il numero di righe nella tabella PERSON
            if (resultSet.next()) {
                int rowCount = resultSet.getInt("row_count");
                assertEquals(2, rowCount, "Il numero di righe nella tabella PERSON dovrebbe essere 2");
            } else {
                throw new AssertionError("La query non ha restituito risultati.");
            }
        }
    }

    @Test
    public void testDatabaseQuery() throws Exception {
        // Connessione al database H2
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            // Esegui una query per verificare i dati nella tabella
            ResultSet resultSet = statement.executeQuery("SELECT NAME, AGE FROM PERSON WHERE NAME = 'Mario Rossi'");

            // Verifica i risultati
            if (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int age = resultSet.getInt("AGE");
                assertEquals("Mario Rossi", name, "Il nome dovrebbe essere 'Mario Rossi'");
                assertEquals(30, age, "L'età dovrebbe essere 30");
            } else {
                throw new AssertionError("La query non ha trovato risultati per 'Mario Rossi'.");
            }
        }
    }
}
