package pageObject.nopCommerce.users;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.users.UserCustomerInforPageUI;

public class UserCustomerInforPO extends UserSidebarPO {
    WebDriver driver;
    public UserCustomerInforPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Get first name text box")
    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX, "value");
    }
    @Step("Get last name text box")
    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX, "value");
    }

    @Step("Get email text box")
    public String getEmailTextboxValue() {
        waitForElementVisible(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX, "value");
    }


}
