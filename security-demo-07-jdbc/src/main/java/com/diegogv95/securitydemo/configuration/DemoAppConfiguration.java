package com.diegogv95.securitydemo.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
public class DemoAppConfiguration {

    @Autowired
    private Environment env;
    private Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    public DataSource securityDataSource() {
        // Create connection pool
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        // Set the jdbc driver
        try {
            securityDataSource.setDriverClass(env.getProperty("jdbc.driver")); // Get the property from application.properties
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        // Set database connection props

        return securityDataSource;
    }
}
