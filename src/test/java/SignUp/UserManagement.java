package SignUp;

import automationExcercise.Utilities.DriverFactory;
import automationExcercise.Utilities.JsonFileManager;
import automationExcercise.Utilities.PropertiesReader;
import automationExcercise.pages.*;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserManagement{
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
        testData=new JsonFileManager("src/test/resources/signUpTestData.json");
    }
    @Description("Verify on new user registeration")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void signUpNewUser(){
        new HomePage(driver).navigate();
        new MenuItems(driver).navigateToLoginPage();
        new LoginPage(driver).signUpAsNewUser(testData.getTestData("userName"),testData.getTestData("email"));
        new SignUpPage(driver).navigate()
                .assertYouAreInSignUpPage()
                .enterAccountInformation(SignUpPage.Gender.male,testData.getTestData("password"),testData.getTestData("dayOfBirth"),testData.getTestDataAsInt("monthOfBirth"),testData.getTestData("yearOfBirth"), SignUpPage.newsAndOffersCheckList.newsAndOffersCheck)
                .fillFirstAndLastName(testData.getTestData("firstName"),testData.getTestData("lastName"))
                .fillCompanyName(testData.getTestData("companyName"))
                .fillAddreses(testData.getTestData("address1"), testData.getTestData("address2"))
                .selectCountry(testData.getTestData("country"))
                .fillStateAndCityAndZipCode(testData.getTestData("state"), testData.getTestData("city"),testData.getTestData("zipCode"))
                .fillMobilePhone(testData.getTestData("mobilePhone"))
                .clickOnCreateAccountButtonAndNavigateCreatedAccountPage();
        new CreatedAccountPage(driver).assertAccountCreated( "ACCOUNT CREATED!")
                .backToHomePage();
        new HomePage(driver).assertYouAreLoggedInHomePage(testData.getTestData("userName"));
        new MenuItems(driver).deleteAccount();
        new DeletedAccountPage(driver).assertAccountDeleted("ACCOUNT DELETED!")
                .backToHomePage();
    }
    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }
}
