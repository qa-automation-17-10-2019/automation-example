package com.automation.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by alpa on 12/15/19
 */
public class SimpleUiTest {

    private WebDriver driver;

    @BeforeClass
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

//    @AfterClass
//    public void tearDownDriver() {
//        driver.quit();
//    }


    @Test(priority = 1)
    public void openSeleniumUrlTest() {
        String baseUrl = "https://selenium.dev/";
        driver.get(baseUrl);
        String currentUrl = driver.getCurrentUrl();

        assertEquals(currentUrl, baseUrl);

        String pageTitle = "SeleniumHQ Browser Automation";
        assertPageTitle(pageTitle);

        String projectsUrl = "https://selenium.dev/projects/";
        driver.get(projectsUrl);

        String projectsCurrentUrl = driver.getCurrentUrl();
        assertEquals(projectsCurrentUrl, projectsUrl);

        String projectsPageTitle = "Selenium Projects";
        assertPageTitle(projectsPageTitle);

        driver.navigate().back();

        currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, baseUrl);

        assertPageTitle(pageTitle);
    }

    @Test(priority = 2)
    public void openSeleniumDocumentationsUrlTest() {
        driver.get("https://selenium.dev/documentation/en/");
    }


    private void assertPageTitle(String pageTitle) {
        String currentTitle = driver.getTitle();
        assertEquals(currentTitle, pageTitle, "Wrong page title!");
    }

}
