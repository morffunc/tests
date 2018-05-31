package com.spbstu.lab2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// TODO what is the strange class name ?
//Changed

public class PageObject {

    public static HomePage homePage;
    public WebDriver driver;

    public static void initHP(WebDriver driver) {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }
}