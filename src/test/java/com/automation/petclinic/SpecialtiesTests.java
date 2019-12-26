package com.automation.petclinic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by alpa on 12/26/19
 */
public class SpecialtiesTests extends TestBase {

    @Test
    public void addSpecialtyTest() throws InterruptedException {
        driver.get("http://139.59.149.247:8000/petclinic/specialties");

        WebElement addButton = driver.findElement(By.xpath("//*[normalize-space(text())='Add']"));
        addButton.click();

//        Thread.sleep(10000);

        WebElement nameField = driver.findElement(By.id("name"));
        assertTrue(nameField.isDisplayed(), "Name field is not displayed!");

        nameField.clear();
        nameField.sendKeys("test");

        WebElement saveButton = driver.findElement(By.xpath("//*[normalize-space(text())='Save']"));
        saveButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.invisibilityOf(saveButton));
        boolean isStalenessOfSaveButton = wait.until(ExpectedConditions.stalenessOf(saveButton));
        assertTrue(isStalenessOfSaveButton, "Name field still displayed!");

//        driver.navigate().refresh();
//        nameField = driver.findElement(By.id("name"));
//        assertFalse(nameField.isDisplayed(), "Name field still displayed!");
        WebElement lastItem = driver.findElement(By.xpath("//*[@id='specialties']/tbody/tr[last()]//*[@name='spec_name']"));
        boolean isAddedToTable = wait.until(ExpectedConditions.attributeToBe(lastItem, "value", "test"));
        assertTrue(isAddedToTable, "Speciality was not added!");
//        assertEquals(lastItem.getAttribute("value"), "test");

        WebElement homeBtn = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[normalize-space(text())='Home']")));

    }
}
