package pageObject.nopCommerce.users;

import commons.BasePage;
import io.qameta.allure.Step;
import pageObject.nopCommerce.PageGenerator;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.users.UserHomePageUI;

public class UserHomePO extends BasePage {
    WebDriver driver;
    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Open Register Page")
    public UserRegisterPO openRegisterPage() {
        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
        clickToElement(driver, UserHomePageUI.REGISTER_LINK);
        return PageGenerator.getUserRegisterPage(driver);
    }

    @Step("Logout System")
    public void clickToLogOutButton() {
        waitForElementClickable(driver, UserHomePageUI.LOGOUT_BUTTON);
        clickToElement(driver, UserHomePageUI.LOGOUT_BUTTON);
    }
    @Step("Open Login Page")
    public UserLoginPO openLoginPage() {
        waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
        clickToElement(driver, UserHomePageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }
    @Step("Verify My Account Link is Displayed")
    public boolean isMyAccountLinkDisplayed() {
        waitForListElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return getBasePage().isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
    }

    @Step("Open User Customer Infor Page")
    public UserCustomerInforPO openCustomerInforPage() {
        waitForListElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getUserCustomerInforPage(driver);
    }
}
