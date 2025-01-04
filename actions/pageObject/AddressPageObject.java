package pageObject;

import commons.BasePage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import pageUIs.AddressPageUI;

public class AddressPageObject extends SidebarPageObject {
    WebDriver driver;
    public AddressPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
