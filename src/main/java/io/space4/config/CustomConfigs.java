package io.space4.config;



import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


//@Profile("space4")

@Configuration(proxyBeanMethods = false)
public class CustomConfigs {

    @Bean
    public CustomRepo customRepo() {
        return new CustomRepo();
    }

}


