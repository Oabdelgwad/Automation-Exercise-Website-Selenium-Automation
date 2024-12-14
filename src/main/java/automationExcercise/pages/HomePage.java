package automationExcercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    ////////////////Locators\\\\\\\\\\\\\\\\\\\
    private By loggedInWithYourNAme = By.xpath("//a[b]");
    private By deleteAccountChoice = By.className("fa-trash-o");

    ////////////////Actions\\\\\\\\\\\\\\\\\\\
    @Step("Navigate to the website")
    public void navigate() {
        driver.navigate().to("https://automationexercise.com/");
    }
    ////////////////Validations\\\\\\\\\\\\\\\\\\\
    public HomePage assertYouAreLoggedInHomePage(String userName)
    {
        Assert.assertEquals(driver.findElement(loggedInWithYourNAme).getText(), "Logged in as " + userName);
        return this;
    }


}
