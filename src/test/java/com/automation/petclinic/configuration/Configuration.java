package com.automation.petclinic.configuration;

/**
 * Created by alpa on 1/5/20
 */
public class Configuration {

    private static Configuration instance;
    private String schema = System.getProperty("schema", "http");
    private String host = System.getProperty("host", "139.59.149.247");
    private String port = System.getProperty("port", "8000");
    private String apiPort = System.getProperty("port", "9966");
    private String baseUrl;
    private String browser = System.getProperty("browser", "chrome");


    private Configuration() {
        init();
    }

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

//        -DbaseUrl=http://139.59.149.247:8000/petclinic
    public String baseUrl() {
        return baseUrl;
    }

    public String getApiPort() {
        return apiPort;
    }

    private void init() {
        this.baseUrl = new UrlBuilder()
                .withSchema(schema)
                .withHost(host)
                .withPort(Integer.parseInt(port)).build();
    }

    public String getBrowser() {
        return browser;
    }
}
