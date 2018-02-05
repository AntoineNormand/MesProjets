package yncrea.pw03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@ComponentScan("yncrea.pw03.service")
public class AppConfig {

    @Bean
    public java.util.Properties dbProperties(){
        Properties property = new Properties();
        property.setProperty("driverClass","com.mysql.jdbc.Driver");
        property.setProperty("jdbcUrl","jdbc:mysql://localhost:3306/yncrea_pw03");
        property.setProperty("username","root");
        property.setProperty("password","root");
        return property;
    }
}
