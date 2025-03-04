package com.ait.homeWork.homeWork.Hw15;

import com.homework.Hw15.fw.ApplicationManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected  ApplicationManager app;

    @BeforeMethod
    public void setUp() {
        app = new ApplicationManager();
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        if (app.driver != null) {
            app.stop();
        }
    }

}