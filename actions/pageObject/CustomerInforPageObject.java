package pageObject;

import commons.BasePage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerInforPageUI;

public class CustomerInforPageObject extends SidebarPageObject {
    WebDriver driver;
    public CustomerInforPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX);
        return getElementAttribute(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, CustomerInforPageUI.LASTNAME_TEXTBOX);
        return getElementAttribute(driver, CustomerInforPageUI.LASTNAME_TEXTBOX, "value");
    }

    public String getEmailTextboxValue() {
        waitForElementVisible(driver, CustomerInforPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver, CustomerInforPageUI.EMAIL_TEXTBOX, "value");
    }


}
