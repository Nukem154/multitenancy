package edu.nukem.multitenancy.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;


public class DataSourceUtil {

    private DataSourceUtil() {
    }

    public static ComboPooledDataSource createPooledDataSource(final String driverClass, final String url,
                                                               final String userName, final String password) {
        final ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            throw new RuntimeException("FAILED_TO_CREATE_DATASOURCE", e);
        }
        dataSource.setJdbcUrl(url);
        dataSource.setUser(userName);
        dataSource.setPassword(password);
        dataSource.setTestConnectionOnCheckin(true);
        dataSource.setTestConnectionOnCheckout(true);
        dataSource.setPreferredTestQuery("SELECT 1");
        return dataSource;
    }
}
