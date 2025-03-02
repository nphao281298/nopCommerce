package com.nopcommerce.account;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.nopCommerce.PageGenerator;
import pageObject.nopCommerce.users.*;
import pojoData.UserInfo;
import utilities.FakerConfig;

@Feature("User")
public class Level_27_Data_POJO extends BaseTest {

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        homePage = PageGenerator.getUserHomePage(driver);
        userInfo = UserInfo.getUser();
        userInfo.setEmailAddress(getEmailRandom("john"));
        userInfo.setFirstName("John");
        userInfo.setLastName("Kennedy");
        userInfo.setPassword("123456");
    }

    @Description("Register to application")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void User_01_Register(){
        registerPage = homePage.openRegisterPage();

//        registerPage.enterToFirstNameTextBox(userInfo.getFirstName());
//        registerPage.enterToLasttNameTextBox(userInfo.getLastName());
//        registerPage.enterToEmailTextBox(userInfo.getEmailAddress());
//        registerPage.enterToPasswordTextBox(userInfo.getPassword());
//        registerPage.enterToconfirmPasswordTextBox(userInfo.getPassword());
        registerPage.setToRegisterForm(userInfo);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");

        homePage.clickToLogOutButton();
    }

    @Description("Login to application")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void User_02_Login(){
        loginPage = homePage.openLoginPage();
        homePage = loginPage.LoginToSystem(userInfo);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void User_03_MyAccount() {
        customerInfoPage = homePage.openCustomerInforPage();
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), userInfo.getFirstName());
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), userInfo.getLastName());
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), userInfo.getEmailAddress());
    }

    @Test
    public void User_04_Dynamic_Page() {
        addressPage = (UserAddressPO) customerInfoPage.openSidebarLinkByPageName("Addresses");
        rewardPointPage = (UserRewarPointPO) addressPage.openSidebarLinkByPageName("Reward points");
        orderPage = (UserOrderPO) rewardPointPage.openSidebarLinkByPageName("Orders");
        addressPage = (UserAddressPO) orderPage.openSidebarLinkByPageName("Addresses");
        customerInfoPage = (UserCustomerInforPO) addressPage.openSidebarLinkByPageName("Customer info");
    }

    @Test
    public void User_05_Dynamic_Page() {
        customerInfoPage.openSidebarLinkByPageNames("Addresses");
        addressPage = PageGenerator.getUserAddressPage(driver);

        addressPage.openSidebarLinkByPageName("Reward points");
        rewardPointPage = PageGenerator.getUserRewarPointPage(driver);

        rewardPointPage.openSidebarLinkByPageName("Orders");
        orderPage = PageGenerator.getUserOrderPage(driver);

        orderPage.openSidebarLinkByPageName("Addresses");
        addressPage = PageGenerator.getUserAddressPage(driver);

        addressPage.openSidebarLinkByPageName("Customer info");
        customerInfoPage = PageGenerator.getUserCustomerInforPage(driver);
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
    private FakerConfig fakerConfig;
    private UserInfo userInfo;
}
