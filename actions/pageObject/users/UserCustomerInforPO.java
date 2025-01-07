package pageObject.users;

import org.openqa.selenium.WebDriver;
import pageUIs.users.UserCustomerInforPageUI;

public class UserCustomerInforPO extends UserSidebarPO {
    WebDriver driver;
    public UserCustomerInforPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX, "value");
    }

    public String getEmailTextboxValue() {
        waitForElementVisible(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX, "value");
    }


}
