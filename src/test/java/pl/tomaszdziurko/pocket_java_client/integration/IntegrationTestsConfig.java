package pl.tomaszdziurko.pocket_java_client.integration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class IntegrationTestsConfig {

    private final static IntegrationTestsConfig INSTANCE = new IntegrationTestsConfig();

    private Properties properties;

    public static IntegrationTestsConfig get() {
        return INSTANCE;
    }

    private IntegrationTestsConfig() {
        properties = new Properties();
        InputStream in = IntegrationTestsConfig.class.getResourceAsStream("/integration.properties");
        try {
            properties.load(in);
            in.close();
        } catch (IOException e) {
            throw new RuntimeException("Error during integration.properties initialization, " + e.getMessage());
        }
    }

    public String getConsumerKey() {
        return properties.getProperty("consumer.key");
    }



}
