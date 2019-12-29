package com.automation.petclinic.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alpa on 12/29/19
 */
public abstract class BasePage {

    private static final String BASE_URL = "http://139.59.149.247:8000/petclinic";

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    protected WebDriverWait waitFor() {
        return new WebDriverWait(driver, 4);
    }

    protected void goToUrl(String url, String title) {
        driver.get(BASE_URL + url);
        waitFor().withMessage(title+ " page is not open!")
                .until(ExpectedConditions.textToBe(By.xpath("//h2"), title));
    }

}
