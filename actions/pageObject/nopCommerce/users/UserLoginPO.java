package pageObject.nopCommerce.users;

import commons.BasePage;
import io.qameta.allure.Step;
import jsonData.UserInforJson;
import pageObject.nopCommerce.PageGenerator;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.users.UserLoginPageUI;
import pojoData.UserInfo;

public class UserLoginPO extends BasePage {
    WebDriver driver;
    public UserLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Login to system")
    public UserHomePO LoginToSystem(String emailAddress, String password) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX ,emailAddress);
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX ,password);
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getUserHomePage(driver);
    }

    @Step("Login to system")
    public UserHomePO LoginToSystem(UserInfo userInfo) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX ,userInfo.getEmailAddress());
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX ,userInfo.getPassword());
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getUserHomePage(driver);
    }

    @Step("Login to system")
    public UserHomePO LoginToSystem(UserInforJson userInfo) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX ,userInfo.getEmail());
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX ,userInfo.getPassword());
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getUserHomePage(driver);
    }
}
