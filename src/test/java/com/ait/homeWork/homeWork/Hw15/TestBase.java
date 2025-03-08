package com.ait.homeWork.homeWork.Hw15;

import com.homework.Hw15.fw.ApplicationManager;

import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {

    protected  ApplicationManager app;

    @BeforeMethod
    public void startTest(Method method){
        logger.info("Start test" + method.getName());
    }

    @AfterMethod
    public void stopTest(ITestResult result){
        if(result.isSuccess()){
            logger.info("PASSED. " + result.getMethod().getMethodName());
        } else{
            logger.error(("FAILED: " + result.getMethod().getMethodName()) + "Screenshot: " + app.getUser().takeScreenshot());
        }
        logger.info("Stop test");
        logger.info("*****************************************");
    }
    @BeforeSuite
    public void setUp() {
        app = new ApplicationManager
                (System.getProperty("browser", Browser.CHROME.browserName()));
        app.init();
    }
   Logger logger = LoggerFactory.getLogger(TestBase.class);

    @AfterSuite
    public void tearDown() {
        if (app.driver != null) {
            app.stop();
        }
    }
}