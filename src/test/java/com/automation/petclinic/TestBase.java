package com.automation.petclinic;

import com.automation.petclinic.configuration.Configuration;
import com.automation.petclinic.configuration.WebDriverFactory;
import com.automation.petclinic.page.object.OwnersPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


/**
 * Created by alpa on 12/26/19
 */
public class TestBase {

    private static final String BASE_URL = Configuration.getInstance().baseUrl();

    public WebDriver driver;
//    protected PetClinicNavigation navigation;
//
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver();
//        navigation = new PetClinicNavigation(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    protected OwnersPage goToOwnersPage() {
        goToUrl(BASE_URL + "/owners", "Owners");
        return new OwnersPage(driver);
    }

    protected void goToNewOwnerPage() {
        goToUrl(BASE_URL + "/owners/add", "New Owner");
    }

    protected void goToVetsPage() {
        goToUrl(BASE_URL + "/vets","Veterinarians");
    }

    protected void goToPetTypesPage() {
        goToUrl(BASE_URL + "/pettypes",  "Pet Types");
    }

    protected void goToSpecialtiesPage() {
        goToUrl(BASE_URL + "/specialties",  "Specialties");
    }

    protected WebDriverWait waitFor() {
        return new WebDriverWait(driver, 4);
    }

    private void goToUrl(String url, String title) {
        driver.get(url);
        waitFor().withMessage(title+ " page is not open!")
                .until(ExpectedConditions.textToBe(By.xpath("//h2"), title));
    }

}
