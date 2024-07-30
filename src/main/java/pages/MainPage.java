package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private static WebDriverWait wait;

    public MainPage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

        @FindBy(name = "//a[contains(@class, 'navigation__link navigation__link--enter')]")
        public WebElement loginButton;

        public void clickOnLoginButton () {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        }
}
