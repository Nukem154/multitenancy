package edu.nukem.multitenancy.config;

import edu.nukem.multitenancy.config.tenant.TenantIdentifierResolver;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class FlywayConfig {

    private final DataSource dataSource;

    @Bean
    public Flyway flyway() {
        final Flyway flyway = Flyway.configure()
                .locations("db/migration/master")
                .dataSource(dataSource)
                .schemas(TenantIdentifierResolver.DEFAULT_TENANT)
                .load();
        flyway.migrate();
        return flyway;
    }

    @PostConstruct
    public void migrate() {
        final String tenant = "test_tenant";
        final Flyway flyway = Flyway.configure()
                .locations("db/migration/tenants")
                .dataSource(dataSource)
                .schemas(tenant)
                .load();
        flyway.migrate();
    }
//    @Bean
//    public CommandLineRunner commandLineRunner(DataSource dataSource) {
//        return args -> {
//            final String tenant = "test_tenant";
//            final Flyway flyway = Flyway.configure()
//                    .locations("db/migration/tenants")
//                    .dataSource(dataSource)
//                    .schemas(tenant)
//                    .load();
//            flyway.migrate();
//        };
//    }
}
