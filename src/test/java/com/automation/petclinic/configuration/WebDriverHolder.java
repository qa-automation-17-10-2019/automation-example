package com.automation.petclinic.configuration;

import org.openqa.selenium.WebDriver;

/**
 * Created by alpa on 1/23/20
 */
public class WebDriverHolder {

    public static WebDriver driver;

    public static WebDriver getInstance() {
        if (driver == null) {
            driver = WebDriverFactory.getDriver();
        }
        return driver;
    }

    public static void destroy() {
        WebDriverHolder.driver = null;
    }
}
