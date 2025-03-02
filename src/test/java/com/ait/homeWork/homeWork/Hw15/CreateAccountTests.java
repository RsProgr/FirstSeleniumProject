package com.ait.homeWork.homeWork.Hw15;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createNewUserPositiveTest() {
        clickOnRegistrationLink();
        fillRegistrationLoginForm(new User()
                .setFirstName("Ivan")
                .setLastName("Bochkarev")
                .setEmail("xor19@list.ru")
                .setPassword("Qwerty12345!")
                .setConfirmPassword("Qwerty12345!"));
        clickOnRegistrationButton();
        Assert.assertTrue(isSignUpButtonPresent(), "Sign Up button is missing"); // Исправлено
    }
}
