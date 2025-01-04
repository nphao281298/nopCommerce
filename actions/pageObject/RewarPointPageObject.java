package pageObject;

import commons.BasePage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import pageUIs.RewarPointPageUI;

public class RewarPointPageObject extends BasePage {
    WebDriver driver;
    public RewarPointPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
