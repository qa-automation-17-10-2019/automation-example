package com.automation.petclinic;

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
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

/**
 * Created by alpa on 12/22/19
 */
public class OwnerTests {

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
    public void addOwnerTest() {
        driver.get("http://139.59.149.247:8000");

        WebElement ownersMenuItem = driver.findElement(By.xpath("//a[@class='dropdown-toggle'][text()='Owners']"));
        ownersMenuItem.click();

        WebElement allOwners = driver.findElement(By.xpath("//a[@routerlink='/owners']"));
        allOwners.click();

        WebElement ownersTable = driver.findElement(By.xpath("//*[@class='table-responsive']"));

        assertTrue(ownersTable.isDisplayed());

        List<WebElement> ownersList = ownersTable.findElements(By.xpath(".//tbody/tr"));
        assertFalse(ownersList.isEmpty());

//        List<Owner> ownerList = new ArrayList<>();
//        for (WebElement userRow : ownersList) {
//            ownerList.add(createOwner(userRow));
//        }
//
//        System.out.println(ownerList);
        WebElement userRow = ownersList.get(0);
        Owner owner = createOwner(userRow);
        userRow.findElement(By.xpath("./td/a")).click();

        WebElement ownerInformation = driver.findElement(By.xpath("//*[text()='Owner Information']"));
        assertTrue(ownerInformation.isDisplayed());

        String name = getInfoValue("Name");
        assertEquals(name, owner.getName());

        String address = getInfoValue("Address");
        assertEquals(address, owner.getAddress());

        String city = getInfoValue("City");
        assertEquals(city, owner.getCity());

        String telephone = getInfoValue("Telephone");
        assertEquals(telephone, owner.getTelephone());
    }

    public Owner createOwner(WebElement userRow) {
        Owner owner = new Owner();
        owner.setName(userRow.findElement(By.xpath("./td/a")).getText());
        owner.setAddress(userRow.findElement(By.xpath("./td[2]")).getText());
        owner.setCity(userRow.findElement(By.xpath("./td[3]")).getText());
        owner.setTelephone(userRow.findElement(By.xpath("./td[4]")).getText());
        owner.setPets(userRow.findElement(By.xpath("./td[5]")).getText());

        return owner;
    }

    private String getInfoValue(String info) {
        return driver.findElement(By.xpath("//th[text()='"+info+"']/following-sibling::td")).getText();
    }




}
