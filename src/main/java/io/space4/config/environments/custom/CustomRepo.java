package io.space4.config.environments.custom;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.core.Ordered;

import java.util.HashMap;
import java.util.Map;

public class CustomRepo implements EnvironmentRepository, Ordered
    {
        @Override
        public Environment findOne(String application, String profile, String label)
        {
            Environment environment = new Environment(application, profile);

            final Map<String, String> properties = loadYourProperties();
            environment.add(new PropertySource("space4custom", properties));
            return environment;
        }

        @Override
        public int getOrder() {
            // Define our order relative to other configuration repositories
            return 2;
        }
        private Map<String, String> loadYourProperties() {
            return new HashMap<String, String>() {{
                put("s4key1", "value-new");
                put("s4key2", "Wooo-hooo - I am a custom environment config-repository !!");
                put("s4key3", "Release, baby !! :D");
            }};
        }
    }

