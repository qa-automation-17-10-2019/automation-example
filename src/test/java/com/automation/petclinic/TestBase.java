package com.automation.petclinic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by alpa on 12/26/19
 */
public class TestBase {

    private static final String BASE_URL = "http://139.59.149.247:8000/petclinic";

    public WebDriver driver;

    @BeforeClass
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    protected void goToOwnersPage() {
        goToUrl(BASE_URL + "/owners", "Owners");
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
