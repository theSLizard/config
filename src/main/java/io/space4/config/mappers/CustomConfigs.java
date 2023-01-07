package io.space4.config.mappers;



import io.space4.config.environments.custom.CustomRepo;
import io.space4.config.environments.custom.CustomRepoConditionalFlag;
import io.space4.config.environments.custom.CustomRepoDev;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration(proxyBeanMethods = false)
public class CustomConfigs {

    @Bean
    @Profile("release")
    public CustomRepo customRepo() {
        return new CustomRepo();
    }

    @Bean
    @Profile("development")
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


