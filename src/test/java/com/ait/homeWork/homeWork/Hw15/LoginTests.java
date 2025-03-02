package com.ait.homeWork.homeWork.Hw15;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginPositiveTest() {
        clickOnLoginLink();
        fillRegistrationLoginForm(new User()
                .setEmail("xor19@list.ru")
                .setPassword("Qwerty12345!"));
        clickOnLoginButton();
        Assert.assertTrue(isSignOutButtonPresent(), "Sign Out button is missing, login might have failed!"); // Исправлено имя метода
    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        clickOnLoginLink();
        fillRegistrationLoginForm(new User()
                .setPassword("Qwerty12345!"));
        clickOnLoginButton();
        Assert.assertFalse(isSignOutButtonPresent(), "Login should have failed, but Sign Out button is present!"); // Исправлено имя метода
    }
}