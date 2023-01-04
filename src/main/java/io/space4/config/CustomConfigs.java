package io.space4.config;



import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


//@Profile("space4")

@Configuration(proxyBeanMethods = false)
public class CustomConfigs {

    @Bean
    @Profile("release")
    public CustomRepo customRepo() {
        return new CustomRepo();
    }

    @Bean
    @Profile("development")
    //@ConditionalOnProperty(name="service.mock", havingValue="true")
    public CustomRepoDev customRepoDev() {
        return new CustomRepoDev();
    }

    @Bean
    @Profile("development")
    @ConditionalOnProperty(name="space4.conditionalFlag", havingValue="true")
    public CustomRepoConditionalFlag customRepoConditionalFlag() {
        return new CustomRepoConditionalFlag();
    }

}


