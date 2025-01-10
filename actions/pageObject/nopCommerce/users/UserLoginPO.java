package pageObject.nopCommerce.users;

import commons.BasePage;
import pageObject.nopCommerce.PageGenerator;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.users.UserLoginPageUI;

public class UserLoginPO extends BasePage {
    WebDriver driver;
    public UserLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public UserHomePO LoginToSystem(String emailAddress, String password) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX ,emailAddress);
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX ,password);
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getUserHomePage(driver);
    }
}
