package com.ait.homeWork.homeWork.Hw15;

import org.openqa.selenium.By;
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
        driver.findElement(By.xpath("//*[@type='button']"));
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }
}
