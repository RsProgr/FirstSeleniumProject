package com.homework.Hw15.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper{

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent() {
        return isElementPresent(By.xpath("//*[@class='topic-html-content-header']"));
    }
}
