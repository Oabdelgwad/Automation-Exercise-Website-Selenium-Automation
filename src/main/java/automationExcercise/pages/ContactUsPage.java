package automationExcercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    WebDriver driver;
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }
    ////////////////Locators\\\\\\\\\\\\\\\\\\\
    private By nameFieldLocator = By.cssSelector("[data-qa='name']");
    private By emailFieldLocator = By.cssSelector("[data-qa='email']");
    private By subjectFieldLocator = By.cssSelector("[data-qa='subject']");
    private By messageFieldLocator = By.id("message");
    private By fileUploaderLocator = By.cssSelector("[name='upload_file']");
    private By uploadButtonLocator = By.cssSelector("[name='submit']");

    ////////////////Actions\\\\\\\\\\\\\\\\\\\
    public ContactUsPage submitContactRequest(String name, String email, String subject, String message, String filePath) {
        driver.findElement(nameFieldLocator).sendKeys(name);
        driver.findElement(emailFieldLocator).sendKeys(email);
        driver.findElement(subjectFieldLocator).sendKeys(subject);
        driver.findElement(messageFieldLocator).sendKeys(message);
        driver.findElement(fileUploaderLocator).sendKeys(filePath);
        driver.findElement(uploadButtonLocator).click();
        driver.switchTo().alert().accept();
        return this;
    }
}
