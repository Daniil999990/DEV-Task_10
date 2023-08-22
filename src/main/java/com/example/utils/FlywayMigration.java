package com.example.utils;

import org.flywaydb.core.Flyway;

public class FlywayMigration {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:mem:testdb", "sa", "")
                .locations("classpath:db/migration")
                .load();

        flyway.migrate();
    }
}
