package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class BasePage {
    //Объявление веб-драйвера
    protected WebDriver driver;
    protected Logger logger;
    public BasePage(WebDriver driver) {

        this.driver = driver;
        logger = LogManager.getLogger(BasePage.class);
    }

    //Конструктор базового класса
    public void initDriver (WebDriver driver) {this.driver = driver;}

    //Открытие страницы
    public void openURL(String url) {
        driver.get(url);
    }

    //Получить заголовок страницы
    public String getTitle() {
        return driver.getTitle();
    }

    //Присутствие элемента в DOM
    public boolean elementIsPresent(By selector) {
        return !driver.findElements(selector).isEmpty();
    }

    //Видимость элемента
    public boolean elementIsDisplayed(By selector) {
        return driver.findElement(selector).isDisplayed();
    }
}
