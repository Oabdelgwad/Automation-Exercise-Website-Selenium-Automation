package automationExcercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    ////////////////Locators\\\\\\\\\\\\\\\\\\\
    private By signupChoiceLocator = By.className("fa-lock");
    private By signUpNameField= By.cssSelector("[data-qa='signup-name']");
    private By signUpEmailField = By.cssSelector("[data-qa='signup-email']");
    ////////////////Actions\\\\\\\\\\\\\\\\\\\

    public LoginPage signUpAsNewUser(String name , String mail) {
        driver.findElement(signUpNameField).sendKeys(name);
        driver.findElement(signUpEmailField).sendKeys(mail);
        return this;
    }


}
