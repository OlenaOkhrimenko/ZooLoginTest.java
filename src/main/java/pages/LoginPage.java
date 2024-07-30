package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver,this);
}

    @FindBy(xpath = "//input[@name='data[email]']")
    public WebElement mail;
    public void enterMail () {
        mail.sendKeys("helen@gmail.com");
    }

    @FindBy(xpath = "//input[@name='data[password]']")
    public WebElement password;
    public void enterPassword(){
        password.sendKeys("Helen2024!");
        }

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitButton;
    public void clickOnSubmitButton (){
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }
//    @FindBy(xpath = "//input[@name='data[password]']")
//    public WebElement password;
//    public void enterPassword (){
//        wait.until(ExpectedConditions.visibilityOfElementLocated((By) password)).sendKeys("Helen2024!");
//        }
//
//    @FindBy(xpath = "//input[@type='submit']")
//    public WebElement submitButton;
//    public void clickOnSubmitButton (){
//        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
//    }
}