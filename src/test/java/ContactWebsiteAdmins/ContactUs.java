package ContactWebsiteAdmins;

import automationExcercise.Utilities.DriverFactory;
import automationExcercise.Utilities.JsonFileManager;
import automationExcercise.Utilities.PropertiesReader;
import automationExcercise.pages.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactUs {
    static WebDriver driver;
    static JsonFileManager testData;
    @BeforeClass
    public void loadProperies()
    {
        PropertiesReader.loadProperties();
    }
    @BeforeMethod
    public void driverSetupAndWebsiteNavigation(){
        driver = DriverFactory.driverSetUp(System.getProperty("browserName"),true,System.getProperty("headless"));
        testData=new JsonFileManager("src/test/resources/contactUsTestData.json");
    }
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void signUpNewUser(){
        new HomePage(driver).navigate();
        new MenuItems(driver).navigateToContactUsPage();
        new ContactUsPage(driver).submitContactRequest(testData.getTestData("name"),
                testData.getTestData("email"), testData.getTestData("subject"),
                testData.getTestData("message"),
                System.getProperty("contactUsAttachmentPath")+testData.getTestData("attachmentFilePath"));
    }

}
