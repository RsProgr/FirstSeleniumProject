package com.homework.Hw15.models;

import com.homework.Hw15.fw.ApplicationManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        if (app.driver != null) {
            app.stop();
        }
    }

}