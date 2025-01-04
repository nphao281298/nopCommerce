package pageObject;

import commons.BasePage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }
    public RegisterPageObject openRegisterPage() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return PageGenerator.getRegisterPage(driver);
    }

    public void clickToLogOutButton() {
        waitForElementClickable(driver, HomePageUI.LOGOUT_BUTTON);
        clickToElement(driver, HomePageUI.LOGOUT_BUTTON);
    }

    public LoginPageObject openLoginPage() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
        return PageGenerator.getLoginPage(driver);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForListElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        return getBasePage().isElementDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK);
    }

    public CustomerInforPageObject openCustomerInforPage() {
        waitForListElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getCustomerInforPage(driver);
    }
}
