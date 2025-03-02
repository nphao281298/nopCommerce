package commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    String projecPath = System.getProperty("user.dir");

    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver driver;
    protected final Logger log;

    public BaseTest() {
        log = LogManager.getLogger(getClass());
    }

    protected WebDriver getBrowserDriver(String browserName){
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        if (browser == BrowserList.FIREFOX) {
            driver = new FirefoxDriver();
        } else if (browser == BrowserList.CHROME){
            driver = new ChromeDriver();
        } else if (browser == BrowserList.EDGE){
            driver = new EdgeDriver();
        } else if (browser == BrowserList.SAFARI){
            driver = new SafariDriver();
        } else {
            throw new RuntimeException("Browser name is not valid");
        }
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get("http://localhost:5000/");
        driver.manage().window().maximize();
        return driver;
    }


    protected WebDriver getBrowserDriver(String browserName, String url){
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        switch (browser){
            case FIREFOX :
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }

    protected boolean verifyTrue(boolean condition){
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
            log.info("------PASSED------");
        } catch (Throwable e) {
            pass = false;
            log.info("------FAILED------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
    protected boolean verifyFalse(boolean condition){
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
            log.info("------PASSED------");
        } catch (Throwable e) {
            pass = false;
            log.info("------FAILED------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
    protected boolean verifyEquals(Object actual, Object expected){
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info("------PASSED------");
        } catch (Throwable e) {
            pass = false;
            log.info("------FAILED------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    @BeforeSuite
    public void deleteReportFolder(){
        deleteAllFileInFolder("htmlReportNG");
        deleteAllFileInFolder("allure-results");
    }

    private void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstants.PROJECT_PATH + File.separator + folderName;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public String getEmailRandom() {
        Random rand = new Random();
        return "John" + rand.nextInt(99999) + "@kennedy.us";
    }

    public String getEmailRandom(String prefix) {
        Random rand = new Random();
        return prefix + rand.nextInt(99999) + "@kennedy.us";
    }

    protected void closeBrowser(){
        if (!(driver == null)){
            driver.quit();
        }
    }

    public void sleepInSecond(long timeInSecond){
        try {
            Thread.sleep(timeInSecond*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
