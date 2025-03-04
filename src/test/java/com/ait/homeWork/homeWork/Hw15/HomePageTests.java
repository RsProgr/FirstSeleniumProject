package com.ait.homeWork.homeWork.Hw15;

import com.homework.Hw15.models.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {
    @Test
    public void isHomeComponentPresentTest() {
        Assert.assertTrue(app.getHomePage().isHomeComponentPresent(), "Home component is not present!"); // Улучшено сообщение об ошибке
    }
}