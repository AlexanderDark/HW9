package tests;

import driver.WebDriverFactory;
import driver.WebDriverType;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    private final Logger logger = LogManager.getLogger();
    protected static WebDriver driver;




    @BeforeEach
    public void mainSetUp () {

        //String name = System.getProperty("browser").trim().toLowerCase();
        String name = Optional.ofNullable(System.getProperty("browser")).orElse("chrome");

        WebDriverType browserName = WebDriverType.findByName(name);
        driver = WebDriverFactory.createDriver(browserName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @AfterEach
    public void closeWebDriver () {
        if (driver != null) {
            driver.quit();
        }
        logger.info("Браузер закрыт");
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
