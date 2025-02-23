package com.ait.homeWork.homeWork.Hw15;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void loginPositiveTest(){
        //click on log in
        driver.findElement(By.cssSelector("[href='/login']")).click();
        //enter Email
        driver.findElement(By.name("Email")).click();
        driver.findElement(By.name("Email")).clear();
        driver.findElement(By.name("Email")).sendKeys("xor19@list.ru");
        //enter password
        driver.findElement(By.name("Password")).click();
        driver.findElement(By.name("Password")).clear();
        driver.findElement(By.name("Password")).sendKeys("Qwerty12345!");
        //click login
        driver.findElement(By.xpath("//*[@class='button-1 login-button']")).click();
        //Assert sign Out button present
       Assert.assertTrue(isElementPresent(By.xpath("//*[.='Log out']")));

    }
}
