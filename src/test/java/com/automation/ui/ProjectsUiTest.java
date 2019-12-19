package com.automation.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by alpa on 12/19/19
 */
public class ProjectsUiTest {

    private WebDriver driver;

    @BeforeClass
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void projectTest() {
        String baseUrl = "https://selenium.dev/";
        driver.get(baseUrl);

        WebElement projectLink = driver.findElement(By.cssSelector("#navbar a[href='/projects']"));
        projectLink.click();

        String projectTitle = driver.getTitle();
        assertEquals(projectTitle,  "Selenium Projects");

        WebElement projectsDescription = driver.findElement(By.cssSelector(".body-large"));

        String projectsDescriptionText = projectsDescription.getText();
        assertEquals(projectsDescriptionText,  "Selenium has many projects that combine to form a versatile testing system.");

        List<WebElement> seleniumProducts = driver.findElements(By.cssSelector(".product-container"));
        assertEquals(seleniumProducts.size(), 3);

        List<String> titleList = new ArrayList<>();
        for (WebElement product : seleniumProducts) {
            WebElement productTitle = product.findElement(By.tagName("h2"));
            titleList.add(productTitle.getText());
        }

        String webdriverTitle = "Selenium WebDriver";
        String ideTitle = "Selenium IDE";
        String gridTitle = "Selenium Grid";

        assertTrue(titleList.contains(webdriverTitle));
        assertTrue(titleList.contains(ideTitle));
        assertTrue(titleList.contains(gridTitle));
    }


}
