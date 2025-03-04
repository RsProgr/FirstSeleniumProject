package com.ait.homeWork.homeWork.Hw15;

import com.homework.Hw15.models.TestBase;
import com.homework.Hw15.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegistrationLoginForm(new User()
                .setEmail("xor19@list.ru")
                .setPassword("Qwerty12345!"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent(), "Sign Out button is missing, login might have failed!"); // Исправлено имя метода
    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegistrationLoginForm(new User()
                .setPassword("Qwerty12345!"));
        app.getUser().clickOnLoginButton();
        Assert.assertFalse(app.getUser().isSignOutButtonPresent(), "Login should have failed, but Sign Out button is present!"); // Исправлено имя метода
    }
}