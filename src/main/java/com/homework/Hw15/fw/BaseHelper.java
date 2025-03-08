package com.homework.Hw15.fw;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class BaseHelper {


    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty(); // Оптимизировано
    }

    public void type(By locator, String text) {
        if (text != null && !text.isEmpty()) { // Проверка на пустую строку
            click(locator);
            WebElement element = driver.findElement(locator);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }
    public String takeScreenshot(){
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshots/screen" + System.currentTimeMillis() + ".png");

        try {
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return screenshot.getAbsolutePath();
    }
}
