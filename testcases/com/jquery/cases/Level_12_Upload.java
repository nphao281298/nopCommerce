package com.jquery.cases;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.jquery.HomePO;
import pageObject.jquery.PageGenerator;

public class Level_12_Upload extends BaseTest {

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePage(driver);

        danang = "DaNang.jpg";
        hochiminh = "HoChiMinh.jpg";
        hanoi = "HaNoi.jpg";
    }

    @Test
    public void Upload_01(){
        // Lay ra duoc duong dan cua file/ thu muc cho dun
        // Tat ca cac OS: Win/ Mac/ Linux de chay duoc
        homePage.uploadMultipleFiles(driver, danang);
//        homePage.sleepInSecond(3);
//        homePage.refreshCurrentPage(driver);
//        homePage.uploadMultipleFiles(driver, danang,hanoi);
//        homePage.sleepInSecond(3);
//        homePage.refreshCurrentPage(driver);
//        homePage.uploadMultipleFiles(driver,danang,hanoi,hochiminh);
//        homePage.sleepInSecond(3);
//        homePage.refreshCurrentPage(driver);
        // Co the upload 1 lan 1 file
        // Co the upload 1 lan nhieu file
        // --> Chi dung 1 ham
        //co the verify
        Assert.assertTrue(homePage.isFileLoadedByName(danang));
//        Assert.assertTrue(homePage.isFileLoadedByName(hochiminh));
//        Assert.assertTrue(homePage.isFileLoadedByName(hanoi));

        homePage.clickToUploadButton(driver);
        Assert.assertTrue(homePage.isFileLoadSuccessByName(danang));
//        Assert.assertTrue(homePage.isFileLoadSuccessByName(hochiminh));
//        Assert.assertTrue(homePage.isFileLoadSuccessByName(hanoi));
        // Co can phai care den viec open file dailog khong? -- Khon can dung toi Open file dailog

    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }

    WebDriver driver;
    HomePO homePage;
    private String danang, hanoi, hochiminh;
}
