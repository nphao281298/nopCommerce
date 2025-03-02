package com.nopcommerce.account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.nopCommerce.PageGenerator;
import pageObject.nopCommerce.users.*;

public class Level_13_Verify extends BaseTest {

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        homePage = PageGenerator.getUserHomePage(driver);

        firstName = "John";
        lastName = "Philip";
        emailAddress = getEmailRandom("");
        password = "Aa@123456";
    }

    @Test
    public void User_01_Register(){
        registerPage = homePage.openRegisterPage();
        verifyEquals(registerPage.getRegisterPagetitle(),"REGISTER");

        registerPage.enterToFirstNameTextBox(firstName);
        registerPage.enterToLasttNameTextBox(lastName);
        registerPage.enterToEmailTextBox(emailAddress);
        registerPage.enterToPasswordTextBox(password);
        registerPage.enterToconfirmPasswordTextBox(password);
        registerPage.clickToRegisterButton();

        verifyEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed!!!!!");
        homePage.clickToLogOutButton();
    }

    @Test
    public void User_02_Login(){
        loginPage = homePage.openLoginPage();
        homePage = loginPage.LoginToSystem(emailAddress, password);
        verifyTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void User_03_MyAccount() {
        customerInfoPage = homePage.openCustomerInforPage();
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), emailAddress);
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
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerInforPO customerInfoPage;
    private UserAddressPO addressPage;
    private UserOrderPO orderPage;
    private UserRewarPointPO rewardPointPage;
}
