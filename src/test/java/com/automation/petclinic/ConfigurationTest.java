package com.automation.petclinic;

import com.automation.petclinic.configuration.Configuration;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by alpa on 1/5/20
 */
public class ConfigurationTest {

    @Test
    public void urlTest() {
        String baseUrl = Configuration.getInstance().baseUrl();
        System.out.println("baseUrl: " +  baseUrl);
        assertThat(baseUrl).isNotBlank();

        baseUrl = Configuration.getInstance().baseUrl();
        System.out.println("baseUrl: " +  baseUrl);
        assertThat(baseUrl).isNotBlank();
    }
}
