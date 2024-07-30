import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

import java.time.Duration;
@Listeners({AllureTestNg.class})


    public class ZooLoginTest {

        private WebDriver driver;
        private WebDriverWait wait;
        private MainPage mainPage;
        private LoginPage loginPage;

        @BeforeTest
        void setupDriver() {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

            driver = new ChromeDriver();
            driver.get("https://zoolandia.com.ua/");
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            mainPage = new MainPage(driver);
            loginPage = new LoginPage(driver);
        }

        @Test

            public void ZooTest(){
                mainPage.clickOnLoginButton();
                loginPage.enterMail();
                loginPage.enterPassword();
                loginPage.clickOnSubmitButton();
                WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'has-error text-center')]")));
                String actualElementText = message.getText();
                String expectedElementText = "Невірний логін або пароль";
                Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual are not the same");
            }

        @AfterTest
        void closeDriver(){
            driver.quit();
        }
    }