package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class AuthOtusTest extends BaseTest{
    String correctLogin="nesito7589@nobitcoin.net", correctPassword = "1234abcd",
            uncorrectLogin1="a@a.ru", uncorrectPassword1="qwerty", uncorrectLogin2="b@b.ru",
            uncorrectPassword2="123456", uncorrectLogin3="admin", uncorrectPassword3="admin";


    @Step("Проверка корректной авторизации")
    @Description("Проверяет авторизацию пользователя с корректной парой логин/пароль")
    @Test
    public void correctAuthOtus () {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        screenshot();
        mainPage.auth();
        screenshot();
        mainPage.fillAuthForm(correctLogin,correctPassword);
        screenshot();
        Assertions.assertTrue(mainPage.checkLogin());
        screenshot();

    }

    @Step("Проверка некорректной авторизации 1")
    @Description("Проверяет авторизацию пользователя с некорректной парой логин/пароль")
    @Test
    public void uncorrectAuthOtus1 () {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        screenshot();
        mainPage.auth();
        screenshot();
        mainPage.fillAuthForm(uncorrectLogin1,uncorrectPassword1);
        screenshot();
        Assertions.assertFalse(mainPage.checkLogin());
        screenshot();

    }

    @Step("Проверка некорректной авторизации 2")
    @Description("Проверяет авторизацию пользователя с некорректной парой логин/пароль")
    @Test
    public void uncorrectAuthOtus2 () {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        screenshot();
        mainPage.auth();
        screenshot();
        mainPage.fillAuthForm(uncorrectLogin2,uncorrectPassword2);
        screenshot();
        Assertions.assertFalse(mainPage.checkLogin());
        screenshot();

    }

    @Step("Проверка некорректной авторизации 1")
    @Description("Проверяет авторизацию пользователя с некорректной парой логин/пароль")
    @Test
    public void uncorrectAuthOtus3 () {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        screenshot();
        mainPage.auth();
        screenshot();
        mainPage.fillAuthForm(uncorrectLogin3,uncorrectPassword3);
        screenshot();
        Assertions.assertFalse(mainPage.checkLogin());
        screenshot();

    }
}
