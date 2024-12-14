package automationExcercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuItems {
    WebDriver driver;
    private By deleteAccountChoice = By.className("fa-trash-o");
    private By signupChoiceLocator = By.className("fa-lock");

    public MenuItems(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Navigate To Login page")
    public MenuItems navigateToLoginPage(){
        driver.findElement(signupChoiceLocator).click();
        return this;
    }

    public MenuItems deleteAccount()
    {
        driver.findElement(deleteAccountChoice).click();
        return this;
    }
}
