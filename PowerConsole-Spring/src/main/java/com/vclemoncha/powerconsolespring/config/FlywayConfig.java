package com.vclemoncha.powerconsolespring.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {
    @Bean
    public CommandLineRunner flyway(DataSource dataSource) {
        return args -> {
            Flyway flywaySchemas = Flyway.configure()
                    .schemas("main")
                    .dataSource(dataSource)
                    .locations("migration/schema")
                    .table("schema_version")
                    .baselineOnMigrate(true)
                    .load();
            flywaySchemas.migrate();
            Flyway flywayFunction = Flyway.configure()
                    .schemas("sp")
                    .dataSource(dataSource)
                    .locations("migration/function")
                    .table("function_version")
                    .baselineOnMigrate(true)
                    .load();
            flywayFunction.migrate();
        };
    }
}
