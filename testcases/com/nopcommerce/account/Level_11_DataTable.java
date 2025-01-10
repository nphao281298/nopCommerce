package com.nopcommerce.account;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.jquery.HomePO;
import pageObject.jquery.PageGenerator;
import pageUIs.jquery.HomePageUI;

public class Level_11_DataTable extends BaseTest {

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePage(driver);
    }

    @Test
    public void Table_01_Paging(){
        // Navigate to any page(paging) in table
        homePage.openPageByNumber("12");
        homePage.isPageNumberActived("12","class");

        homePage.openPageByNumber("11");
        homePage.isPageNumberActived("11","class");

        homePage.openPageByNumber("1");
        homePage.isPageNumberActived("1","class");
    }

    @Test
    public void Table_02_Search(){
        homePage.enterToTextBoxByHeaderName("Country", "Afghanistan");
        sleepInSecond(3);
        Assert.assertTrue(homePage.isRowDataValueDisplayed("384187","Afghanistan","407124","791312"));
        homePage.refreshCurrentPage(driver);

//        homePage.enterToTextBoxByHeaderName("Males", "407124");
//        sleepInSecond(3);
//        Assert.assertTrue(homePage.isRowDataValueDisplayed("","","",""));
//        homePage.refreshCurrentPage(driver);
//
//        homePage.enterToTextBoxByHeaderName("Females", "384187");
//        sleepInSecond(3);
//        Assert.assertTrue(homePage.isRowDataValueDisplayed("","","",""));
//        homePage.refreshCurrentPage(driver);
    }

    @Test
    public void Table_03_Delete_Edit(){
        homePage.enterToTextBoxByHeaderName("Country", "Afghanistan");
        sleepInSecond(3);
        homePage.deleteRowByCountryName("Afghanistan");
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextBoxByHeaderName("Country", "AFRICA");
        sleepInSecond(3);
        homePage.editRowByCoutryName("AFRICA");
        homePage.refreshCurrentPage(driver);
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }

    WebDriver driver;
    HomePO homePage;
}
