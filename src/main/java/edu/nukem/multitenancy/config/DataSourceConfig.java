package edu.nukem.multitenancy.config;

import edu.nukem.multitenancy.util.DataSourceUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${mysql.driver-class}")
    private String driverClassName;

    @Value("${database.cred.url}")
    private String dbURL;

    @Value("${database.cred.username}")
    private String username;

    @Value("${database.cred.password}")
    private String password;

//    @Bean
//    @Primary
//    public DataSource masterDataSource() {
//        return DataSourceUtil.createPooledDataSource(driverClassName,
//                createDefaultURL(dbURL, DEFAULT_TENANT), username, password);
//    }

    @Bean
    public DataSource masterDataSource() {
        return DataSourceUtil.createPooledDataSource(driverClassName, dbURL, username, password);
    }

    public static String createDefaultURL(final String url, final String dbName) {
        return url + dbName + "?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false" +
                "&useUnicode=yes&characterEncoding=UTF-8";
    }
}
