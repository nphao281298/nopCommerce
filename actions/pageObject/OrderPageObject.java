package pageObject;

import commons.BasePage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import pageUIs.OrderPageUI;

public class OrderPageObject extends SidebarPageObject {
    WebDriver driver;
    public OrderPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
