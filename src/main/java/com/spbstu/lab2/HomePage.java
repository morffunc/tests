package com.spbstu.lab2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage {

    public WebDriver driver;
    @FindBy(css = ".profile-photo")
    WebElement ProfileIcon;
    @FindBy(css = "#Login")
    WebElement LoginIn;
    @FindBy(css = "#Password")
    WebElement PasswordIn;
    @FindBy(css = "form .btn-login")
    WebElement EnterIn;
    @FindBy(css = ".logout")
    WebElement LogOutIn;
    @FindBy(css = ".icons-benefit")
    List<WebElement> IconsIn;
    @FindBy(css = ".benefit-txt")
    List<WebElement> TextsIn;
    @FindBy(css = ".main-title")
    WebElement MainTitleIn;
    @FindBy(css = ".main-txt")
    WebElement MainTextIn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    public void open(String Site) {
        driver.navigate().to(Site);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isLoggedIn(String Login, String Password) {
        ProfileIcon.click();
        LoginIn.sendKeys(Login);
        PasswordIn.sendKeys(Password);
        EnterIn.click();
        return LogOutIn.isDisplayed();
    }
    // TODO wrong method naming !
    //changed
    public String getUsername() {
        return ProfileIcon.getText();
    }

    public int getIconsNumber() {
        //System.out.println(IconsIn.size());
        return IconsIn.size();
    }

    public String getPictureText(int i) {
        return TextsIn.get(i).getText();
    }

    // TODO methods with "is" prefix should return boolean values...
    //changed
    public String getMainTitle() {
        return MainTitleIn.getText();
    }

    public String getMainText() {
        return MainTextIn.getText();
    }
}
