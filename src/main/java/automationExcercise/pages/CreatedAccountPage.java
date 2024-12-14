package automationExcercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CreatedAccountPage {
    WebDriver driver;

    ////////////////Locators\\\\\\\\\\\\\\\\\\\
    private By continueButton = By.className("btn-primary");
    By loggedInWithYourNAme = By.xpath("//a[b]");

    ////////////////Actions\\\\\\\\\\\\\\\\\\\
    public CreatedAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public CreatedAccountPage backToHomePage()
    {
        driver.findElement(continueButton).click();
        return this;
    }
    ////////////////Validations\\\\\\\\\\\\\\\
    public CreatedAccountPage assertAccountCreated (String accountCreatedMessage){
        Assert.assertEquals(driver.findElement(By.className("text-center")).getText(), accountCreatedMessage);
        return this;
    }

}
