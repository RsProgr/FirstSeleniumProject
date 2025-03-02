package com.ait.homeWork.homeWork.Hw15;

import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginPositiveTest() {

        clickOnLoginLink();
        fillRegistrationLoginForm("xor19@list.ru", "Qwerty12345!");
        clickOnLoginButton();
        isSignOuButtonPresent();
    }
}