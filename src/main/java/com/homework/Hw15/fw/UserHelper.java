package com.homework.Hw15.fw;

import com.homework.Hw15.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void login() {
        click(By.cssSelector("[href='/login']"));
        type(By.name("Email"), "xor19@list.ru");
        type(By.name("Password"), "Qwerty12345!");
        click(By.xpath("//*[@class='button-1 login-button']"));
    }

    public boolean isSignUpButtonPresent() {
        return isElementPresent(By.xpath("//*[@type='button']"));
    }

    public void fillRegistrationLoginForm(User user) {
        type(By.name("FirstName"), user.getFirstName());
        type(By.name("LastName"), user.getLastName());
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
        type(By.name("ConfirmPassword"), user.getConfirmPassword());
    }

    public void clickOnRegistrationButton() {
        click(By.name("register-button"));
    }

    public void clickOnRegistrationLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public boolean isSignOutButtonPresent() { // Исправлено имя метода
        return isElementPresent(By.cssSelector("[href='/logout']"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("//input[@class='button-1 login-button']"));
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }
}
