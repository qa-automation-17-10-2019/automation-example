package com.automation.petclinic;

import com.automation.petclinic.configuration.Configuration;
import com.automation.petclinic.page.object.NewOwnerPage;
import com.automation.petclinic.page.object.OwnersPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by alpa on 1/5/20
 */
public class PetClinicNavigation {

    private WebDriver driver;
    private Configuration configuration = Configuration.getInstance();

    public PetClinicNavigation(WebDriver driver) {
        this.driver = driver;
    }

    public NewOwnerPage openNewOwnerPage() {
        driver.get(configuration.baseUrl() + "/owners/add");
        return new NewOwnerPage(driver);
    }

    public OwnersPage openOwnerPage() {
        driver.get(configuration.baseUrl() + "/owners");
        return new OwnersPage(driver);
    }
}
