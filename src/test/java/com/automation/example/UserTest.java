package com.automation.example;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by alpa on 12/12/19
 */
public class UserTest {

    private User user;

    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass");
        System.out.println("setup env...");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("afterClass");
        System.out.println("stop env...");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod");
        user = new User("Bob", 30);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod");
        user = null;
    }

    @Test
    public void userNameTest() {
        System.out.println("userNameTest");
        assertEquals(user.getName(), "Bob");
    }

    @Test
    public void userAgeTest() {
        System.out.println("userAgeTest");
        assertEquals(user.getAge(), 30);
    }

}
