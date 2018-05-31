package com.spbstu.lab1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.ArrayList;

public class TestLab1 extends  Test_Init {

    @Test
    public void Lab1() {

        String Url_test = "https://jdi-framework.github.io/tests/index.htm";
        //открыть сайт
        driver.get(Url_test);
        //проверить нужный ли сайт
        Assert.assertEquals(driver.getCurrentUrl(), Url_test);

        String Title = "Index Page";

        //проверить заголовок страницы
        Assert.assertEquals(driver.getTitle(), Title);

        //данные для входа
        String Login = "epam";
        String Pass = "1234";
        String UserName = "PITER CHAILOVSKII";
        //ввод данных для входа и клик
        driver.findElement(By.cssSelector("[href='#']")).click();
        driver.findElement(By.cssSelector("#Login")).sendKeys(Login);
        driver.findElement(By.cssSelector("#Password")).sendKeys(Pass);
        driver.findElement(By.cssSelector("[type = 'submit']")).click();

        //проверка видиомсти и совпадения имя
        Assert.assertTrue(driver.findElement(By.cssSelector("[href = '#']")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.cssSelector("[href='#']")).getText(), UserName);
        //проверить заголовок страницы
        Assert.assertEquals(driver.getTitle(), Title);


        //проверка на количество изображений
        Assert.assertEquals((driver.findElements(By.cssSelector("[class = 'benefit-icon']")).size()), 4);
        //данные для проверки
        ArrayList<String> Image_Texts = new ArrayList<String>();
        Image_Texts.add("To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM projec");
        Image_Texts.add("To be flexible and\n" +
                "customizable");
        Image_Texts.add("To be multiplatform");
        Image_Texts.add("Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");
        //driver.get("https://jdi-framework.github.io/tests/index.htm");
        Assert.assertEquals((driver.findElements(By.cssSelector("[class = 'benefit-txt']")).size()), 4);

        ArrayList<WebElement> TextsUnderIcons;
        TextsUnderIcons = (ArrayList<WebElement>) driver.findElements(By.cssSelector("[class = 'benefit-txt']")); // проверка текста под иконками
        for (int i = 0; i < Image_Texts.size(); i++) {
            Assert.assertEquals(TextsUnderIcons.get(i).getText(), Image_Texts.get(i));
        }

        //проверить текст в центре
        String main_title = "EPAM FRAMEWORK WISHES…";
        String main_txt_center = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD " +
                "TEMPOR INCIDIDUNT UT LABORE ET " +
                "DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI " +
                "UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
                "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."  ;
        Assert.assertEquals((driver.findElement(By.cssSelector(".main-title"))).getText(), main_title);
        Assert.assertEquals((driver.findElement(By.cssSelector(".main-txt"))).getText(), main_txt_center);
    }
}
