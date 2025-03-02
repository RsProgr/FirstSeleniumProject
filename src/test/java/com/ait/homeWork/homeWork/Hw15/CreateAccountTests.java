package com.ait.homeWork.homeWork.Hw15;

import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createNewUserPositiveTest() {

        clickOnRegistrationLink();
        fillRegistrationLoginForm("Ivan", "Bochkarev", "xor19@list.ru", "Qwerty12345!", "Qwerty12345!");
        clickOnRegistrationButton();
        isSignUpButtonPresent();
    }
}