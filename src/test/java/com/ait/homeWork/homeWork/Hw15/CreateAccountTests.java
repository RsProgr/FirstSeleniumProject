package com.ait.homeWork.homeWork.Hw15;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createNewUserPositiveTest() {
        // Click Register
        click(By.cssSelector("[href='/register']"));

        // Enter First name
        type(By.name("FirstName"), "Bochkarev");

        // Enter Last name
        type(By.name("LastName"), "Bochkarev");

        // Enter Email
        type(By.name("Email"), "xor19@list.ru");

        // Enter password
        type(By.name("Password"), "Qwerty12345!");

        // Enter Confirm password
        type(By.name("ConfirmPassword"), "Qwerty12345!");

        // Click Register
        click(By.name("register-button"));

        // Assert register complete
        Assert.assertEquals(isElementPresent(By.xpath("//*[@type='button']")), true, "Registration failed!");
    }
}