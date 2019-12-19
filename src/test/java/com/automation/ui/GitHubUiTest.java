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

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Created by alpa on 12/19/19
 */
public class GitHubUiTest {

    private WebDriver driver;

    @BeforeClass
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void registrationTest() {
        driver.get("https://github.com/login");

        WebElement loginField = driver.findElement(By.id("login_field"));
        loginField.clear();
        loginField.sendKeys("username");

        WebElement passwordFiled = driver.findElement(By.id("password"));
        passwordFiled.clear();
        passwordFiled.sendKeys("qwerty123");

        WebElement signInButton = driver.findElement(By.cssSelector("input[type='submit']"));
        signInButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector(".flash-full.flash-error"));
        assertTrue(errorMessage.isDisplayed(), "Error message not displayed!");
    }
}
