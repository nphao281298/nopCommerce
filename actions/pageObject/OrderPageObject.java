package pageObject;

import commons.BasePage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import pageUIs.OrderPageUI;

public class OrderPageObject extends BasePage {
    WebDriver driver;
    public OrderPageObject(WebDriver driver) {
        this.driver = driver;
    }


}
