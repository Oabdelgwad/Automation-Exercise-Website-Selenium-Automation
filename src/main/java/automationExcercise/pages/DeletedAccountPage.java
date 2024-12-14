package automationExcercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DeletedAccountPage {
    WebDriver driver;
     public DeletedAccountPage(WebDriver driver) {
         this.driver = driver;
     }
    ////////////////Locators\\\\\\\\\\\\\\\\\\\
    private By continueButton = By.className("btn-primary");

    ////////////////Actions\\\\\\\\\\\\\\\\\\\
    public DeletedAccountPage backToHomePage()
    {
        driver.findElement(continueButton).click();
        return this;
    }
    ////////////////Validations\\\\\\\\\\\\\\\\\\\
    public DeletedAccountPage assertAccountDeleted (String accountDeletedMessage){
        Assert.assertEquals(driver.findElement(By.className("text-center")).getText(), accountDeletedMessage);
        return this;
    }

}
