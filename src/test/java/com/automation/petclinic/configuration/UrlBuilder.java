package com.automation.petclinic.configuration;

/**
 * Created by alpa on 1/5/20
 */
public class UrlBuilder {

    private String schema;
    private String host;
    private int port;


    public UrlBuilder withSchema(String schema) {
        this.schema = schema;
        return this;
    }

    public UrlBuilder withHost(String host) {
        this.host = host;
        return this;
    }

    public UrlBuilder withPort(int port) {
        this.port = port;
        return this;
    }

    public String build() {
        return String.format("%s://%s:%s/petclinic", schema, host, port);
    }
}
