package com.spbstu.lab2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestLab2 {

    private WebDriver driver;

    @Before
   /* public void before() {
        PageProperties config = ConfigFactory.create(PageProperties.class);
        System.setProperty("driver", config.driverPath());
        // TODO this should be specified in pom.xml
        //specified, but without this don't work
        String Site = "https://jdi-framework.github.io/tests/index.htm";
        // TODO same situation
        //System.setProperty(homePageURL, "C:\\Selenium\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        driver.navigate().to(Site);
        PageObject.initHP(this.driver);
    }*/

    @BeforeSuite
    public void beforeSuite() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        PageObject.initHP(this.driver);
    }

    @AfterTest
    public void after() {
        PageObject.homePage.driver.close();
    }

    @Test
    public void Lab2() {

        PageObject.homePage.open();
        PageObject.homePage.getUrl();
        Assert.assertEquals(PageObject.homePage.getUrl(), PAGE_DATA.SITE.str);
        Assert.assertEquals(PageObject.homePage.getTitle(), PAGE_DATA.TITLE.str);
        Assert.assertTrue(PageObject.homePage.isLoggedIn(PAGE_DATA.LOGIN.str, PAGE_DATA.PASSWORD.str));

        Assert.assertEquals(PageObject.homePage.getUsername(), PAGE_DATA.USER_NAME.str);
        Assert.assertEquals(PageObject.homePage.getTitle(), PAGE_DATA.TITLE.str);

        Assert.assertEquals(PageObject.homePage.getIconsNumber(), PAGE_DATA.ACTUAL_ICONS_NUMBERS.i);

        for (int i = 0; i < PAGE_DATA.ACTUAL_ICONS_NUMBERS.i; i++) {
            Assert.assertEquals(PageObject.homePage.getPictureText(i), PAGE_DATA.TEXT.strAr[i]);
        }

        Assert.assertEquals(PageObject.homePage.getMainTitle(), PAGE_DATA.MAIN_HEADER.str);
        Assert.assertEquals(PageObject.homePage.getMainText(), PAGE_DATA.HOME_PAGE.str);
    }
}
