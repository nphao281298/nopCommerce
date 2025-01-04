package pageObject;

import commons.BasePage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import pageUIs.RewarPointPageUI;

public class RewarPointPageObject extends SidebarPageObject {
    WebDriver driver;
    public RewarPointPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
