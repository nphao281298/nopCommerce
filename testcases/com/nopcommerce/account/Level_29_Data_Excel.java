package com.nopcommerce.account;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jsonData.UserInforJson;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.nopCommerce.PageGenerator;
import pageObject.nopCommerce.users.*;
import utilities.ExcelConfig;
import utilities.FakerConfig;

@Feature("User")
public class Level_29_Data_Excel extends BaseTest {
    //01:14:00
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        homePage = PageGenerator.getUserHomePage(driver);
        excelConfig = ExcelConfig.getExcelData();

        excelConfig.switchToSheet("userData");
        firstName = excelConfig.getCellData("FirstName", 1);
        lastName = excelConfig.getCellData("LastName", 1);
        emailAddress = getEmailRandom(excelConfig.getCellData("EmailAddress", 1));
        password = excelConfig.getCellData("Password", 1);
    }

    @Description("Register to application")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void User_01_Register(){
        registerPage = homePage.openRegisterPage();

        registerPage.enterToFirstNameTextBox(firstName);
        registerPage.enterToLasttNameTextBox(lastName);
        registerPage.enterToEmailTextBox(emailAddress);
        registerPage.enterToPasswordTextBox(password);
        registerPage.enterToconfirmPasswordTextBox(password);
//        registerPage.enterToRegisterForm(userInfo);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");

        homePage.clickToLogOutButton();
    }

    @Description("Login to application")
    @Severity(SeverityLevel.NORMAL)
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
    private ExcelConfig excelConfig;
}
