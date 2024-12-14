package automationExcercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public enum Gender{
        male,female;
    }
    public enum newsAndOffersCheckList{
        noCheck,newsCheck,offersCheck,newsAndOffersCheck;
    }
    ////////////////Locators\\\\\\\\\\\\\\\\\\\
    private By maleGenderChoiceRadioButton = By.id("id_gender1");
    private By femaleGenderChoiceRadioButton = By.id("id_gender2");
    private By passwordField = By.id("password");
    private By birthDayChoice = By.id("days");
    private By birthMonthChoice = By.id("months");
    private By birthYearIDChoice = By.id("years");
    private By newsLetterCheckBox = By.id("newsletter");
    private By offersCheckBox = By.id("optin");
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By companyNameField = By.id("company");
    private By addressOneField = By.id("address1");
    private By addressTwoField = By.id("address2");
    private By countryChoice = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipCodeField = By.id("zipcode") ;
    private By phoneField = By.id("mobile_number");
    private By createAccountButton = By.cssSelector("[data-qa='create-account']");
    private By signUpButton = By.cssSelector("[data-qa='signup-button']");
    ////////////////Actions\\\\\\\\\\\\\\\\\\\
    @Step("Enter Account Information")
    public SignUpPage enterAccountInformation(Gender myGender, String password, String dayOfBirth, int monthOfBirth, String yearOfBirth, newsAndOffersCheckList targetCheckBoxes) {
        chooseGender(myGender);
        fillPassword(password);
        selectDayOfBirth(dayOfBirth);
        selectMonthOfBirth(monthOfBirth);
        selectYearOfBirth(yearOfBirth);
        checkNewsLettersAndOffers(targetCheckBoxes);
        return this;
    }
    private SignUpPage chooseGender(Gender yourGender)
    {
        if(yourGender==Gender.male)
        {
            driver.findElement(maleGenderChoiceRadioButton).click();
        }
        else if (yourGender==Gender.female)
        {
            driver.findElement(femaleGenderChoiceRadioButton).click();
        }
        return this;
    }
    private SignUpPage fillPassword(String password)
    {

        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    private SignUpPage selectDayOfBirth(String dayOfBirth)
    {
        Select birthDay = new Select(driver.findElement(birthDayChoice));
        birthDay.selectByVisibleText(dayOfBirth);
        return this;
    }
    private SignUpPage selectMonthOfBirth(int monthOfBirth)
    {
        Select birthMonth = new Select(driver.findElement(birthMonthChoice));
        birthMonth.selectByIndex(monthOfBirth);
        return this;
    }
    private SignUpPage selectYearOfBirth(String yearOfBirth)
    {
        Select birthYear = new Select(driver.findElement(birthYearIDChoice));
        birthYear.selectByValue(yearOfBirth);
        return this;
    }
    private void checkNewsLettersAndOffers(newsAndOffersCheckList checks)
    {
        if(checks==newsAndOffersCheckList.noCheck)
        {}
        else if (checks==newsAndOffersCheckList.newsCheck)
        {
            driver.findElement(newsLetterCheckBox).click();
        }
        else if(checks==newsAndOffersCheckList.offersCheck)
        {
            driver.findElement(offersCheckBox).click();
        }
        else if(checks==newsAndOffersCheckList.newsAndOffersCheck)
        {
            driver.findElement(newsLetterCheckBox).click();
            driver.findElement(offersCheckBox).click();
        }
    }
    @Step("Enter Address Information")
    public SignUpPage fillFirstAndLastName(String firstName,String lastName)
    {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        return this;
    }

    public SignUpPage fillCompanyName(String companyName)
    {
        driver.findElement(companyNameField).sendKeys(companyName);
        return this;
    }
    public SignUpPage fillAddreses(String addressOne,String addressTwo)
    {
        driver.findElement(addressOneField).sendKeys(addressOne);
        driver.findElement(addressTwoField).sendKeys(addressTwo);
        return this;
    }
    public SignUpPage selectCountry(String country)
    {
        Select countrySelection = new Select(driver.findElement(countryChoice));
        countrySelection.selectByValue(country);
        return this;
    }
    public SignUpPage fillStateAndCityAndZipCode(String state,String city ,String zipCode)
    {
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(zipCodeField).sendKeys(zipCode);
        return this;
    }
    public SignUpPage fillMobilePhone(String mobilePhone)
    {

        driver.findElement(phoneField).sendKeys(mobilePhone);
        return this;
    }
    @Step("Create a new Account")
    public SignUpPage clickOnCreateAccountButtonAndNavigateCreatedAccountPage()
    {
        driver.findElement(createAccountButton).click();
        return this;
    }
    public SignUpPage navigate()
    {
        driver.findElement(signUpButton).click();
        return this;
    }
    ////////////////Validations\\\\\\\\\\\\\\\
    public SignUpPage assertYouAreInSignUpPage(){
        Assert.assertEquals(driver.getTitle(),"Automation Exercise - Signup");
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/signup");
        return this;
    }
}
