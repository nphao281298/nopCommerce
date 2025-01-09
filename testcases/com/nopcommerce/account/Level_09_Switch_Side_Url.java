package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.admin.AdminDashboardPO;
import pageObject.admin.AdminLoginPO;
import pageObject.users.UserHomePO;
import pageObject.users.UserLoginPO;
import pageObject.users.UserRegisterPO;

public class Level_09_Switch_Side_Url extends BaseTest {
    @Parameters({"browser", "userUrl", "adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl){
        this.userUrl = userUrl;
        this.adminUrl = adminUrl;
        driver = getBrowserDriver(browserName);
        userHomePage = PageGenerator.getUserHomePage(driver);

        firstName = "John";
        lastName = "Philip";
        emailAddress = getEmailRandom();
        password = "Aa@123456";
        adminEmailAddress = "admin@yourStore.com";
        adminPassword = "Aa@123456";
        // Pre-condition
        userRegisterPage = userHomePage.openRegisterPage();
        userRegisterPage.enterToFirstNameTextBox(firstName);
        userRegisterPage.enterToLasttNameTextBox(lastName);
        userRegisterPage.enterToEmailTextBox(emailAddress);
        userRegisterPage.enterToPasswordTextBox(password);
        userRegisterPage.enterToconfirmPasswordTextBox(password);
        userRegisterPage.clickToRegisterButton();
        Assert.assertEquals(userRegisterPage.getRegisterSuccessMessageText(),"Your registration completed");
        userHomePage.clickToLogOutButton();
    }
    @Test
    public void Role_01_User_Site_To_Admin_Site(){
        userLoginPage = userHomePage.openLoginPage();
        userHomePage = userLoginPage.LoginToSystem(emailAddress, password);
        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
        userHomePage.clickToLogOutButton();
        // Step de order 1 product nao do
        //....
        // Qua trnag admin de verify/ approve order tren
        userHomePage.openUrl(driver, this.adminUrl);
        // chua login
        adminLoginPage = PageGenerator.getAdminLoginPage(driver);
        adminLoginPage.enterToEmailTextBox(adminEmailAddress);
        adminLoginPage.enterToPasswordTextBox(password);
        adminDashboardPage = adminLoginPage.clickToLoginButton();
    }

    @Test
    public void Role_02_Admin_Site_To_User_Site(){
        adminDashboardPage.openUrl(driver, this.userUrl);
        userHomePage = PageGenerator.getUserHomePage(driver);
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
    private UserHomePO userHomePage;
    private UserRegisterPO userRegisterPage;
    private UserLoginPO userLoginPage;
    private AdminLoginPO adminLoginPage;

    private AdminDashboardPO adminDashboardPage;
    String adminEmailAddress, adminPassword;
    private String userUrl, adminUrl;
    // Test git stash

}
