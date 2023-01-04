package io.space4.config.repos;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.space4.config.data.entities.PlainKeyValueStore;
import io.space4.config.service.KvpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.core.Ordered;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "s4custom")
public class CustomRepoConditionalFlag implements EnvironmentRepository, Ordered
{

    @Autowired
    private KvpService kvpService;

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
        return 0;
    }

    private void readFromJson()
    {
        // read JSON and load json
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<PlainKeyValueStore>> typeReference = new TypeReference<List<PlainKeyValueStore>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/plainKVP.json");
        try {
            List<PlainKeyValueStore> myKVPs  = mapper.readValue(inputStream,typeReference);
            kvpService.save(myKVPs);
            System.out.println("KVPs Saved!");
        } catch (IOException e){
            System.out.println("Unable to save KVPs: " + e.getMessage());
        }
    }

    private Map<String, String> loadYourProperties() {

        this.readFromJson();

        Iterable<PlainKeyValueStore> readKVPs = kvpService.list();
        Map<String, String > myKVPs = new HashMap<>();

        for (PlainKeyValueStore kvs : readKVPs)
        {
            myKVPs.put(kvs.getS4name(), kvs.getS4value());
        }

        return myKVPs;
        /*
        return new HashMap<String, String>() {{
            put("s4key1", "development:  custom-flag --> value-new");
            put("s4key2", "development:  custom-flag --> Wooo-hooo - I am a custom environment config-repository !!");
            put("s4key3", "development;  custom-flag --> Spring Rulz :D");
        }};
         */

    }
}
