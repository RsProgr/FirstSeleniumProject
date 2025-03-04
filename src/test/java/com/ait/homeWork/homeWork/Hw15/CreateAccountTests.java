package com.ait.homeWork.homeWork.Hw15;

import com.homework.Hw15.models.TestBase;
import com.homework.Hw15.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createNewUserPositiveTest() {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationLoginForm(new User()
                .setFirstName("Ivan")
                .setLastName("Bochkarev")
                .setEmail("xor19@list.ru")
                .setPassword("Qwerty12345!")
                .setConfirmPassword("Qwerty12345!"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isSignUpButtonPresent(), "Sign Up button is missing"); // Исправлено
    }
}