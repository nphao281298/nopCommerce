package pageObject.users;

import commons.BasePage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import pageUIs.users.UserHomePageUI;

public class UserHomePO extends BasePage {
    WebDriver driver;
    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }
    public UserRegisterPO openRegisterPage() {
        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
        clickToElement(driver, UserHomePageUI.REGISTER_LINK);
        return PageGenerator.getUserRegisterPage(driver);
    }

    public void clickToLogOutButton() {
        waitForElementClickable(driver, UserHomePageUI.LOGOUT_BUTTON);
        clickToElement(driver, UserHomePageUI.LOGOUT_BUTTON);
    }

    public UserLoginPO openLoginPage() {
        waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
        clickToElement(driver, UserHomePageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForListElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return getBasePage().isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
    }

    public UserCustomerInforPO openCustomerInforPage() {
        waitForListElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getUserCustomerInforPage(driver);
    }
}
