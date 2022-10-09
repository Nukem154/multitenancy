package edu.nukem.multitenancy.service;

import org.flywaydb.core.Flyway;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class TenantService {

    private final DataSource dataSource;

    public TenantService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void createTenant(String name) {
        initDatabase(name);
    }

    public void initDatabase(String schema) {
        Flyway flyway = Flyway.configure()
                .locations("db/migration/tenants")
                .dataSource(dataSource)
                .schemas(schema)
                .load();
        flyway.migrate();
    }
}
