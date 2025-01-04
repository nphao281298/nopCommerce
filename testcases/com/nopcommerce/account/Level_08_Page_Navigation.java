package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.*;

public class Level_08_Page_Navigation extends BaseTest {

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        homePage = PageGenerator.getHomePage(driver);

        firstName = "John";
        lastName = "Philip";
        emailAddress = getEmailRandom();
        password = "Aa@123456";
    }

    @Test
    public void User_01_Register(){
        registerPage = homePage.openRegisterPage();
        registerPage.enterToFirstNameTextBox(firstName);
        registerPage.enterToLasttNameTextBox(lastName);
        registerPage.enterToEmailTextBox(emailAddress);
        registerPage.enterToPasswordTextBox(password);
        registerPage.enterToconfirmPasswordTextBox(password);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");
        homePage.clickToLogOutButton();
    }

    @Test
    public void User_02_Login(){
        loginPage = homePage.openLoginPage();
        homePage = loginPage.LoginToSystem(emailAddress, password);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void User_03_MyAccount() {
        customerInfoPage = homePage.openCustomerInforPage();
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), emailAddress);

    }

    @Test
    public void User_04_Switch_page() {
        addressPage = customerInfoPage.openAddressPage();
        rewardPointPage = addressPage.openRewardPointPage();
        orderPage = rewardPointPage.openOrderPage();
        addressPage = orderPage.openAddressPage();
        customerInfoPage = addressPage.openCustomerInfoPage();
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }

    WebDriver driver;
    private String lastName;
    private String firstName;
    private String emailAddress;
    private String password;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerInforPageObject customerInfoPage;
    private AddressPageObject addressPage;
    private OrderPageObject orderPage;
    private RewarPointPageObject rewardPointPage;
}
