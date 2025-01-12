package pageObject.nopCommerce.users;

import commons.BasePage;
import pageObject.nopCommerce.PageGenerator;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.users.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
    WebDriver driver;
    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstNameTextBox(String firstNameValue) {
        waitForElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstNameValue);
    }

    public void enterToLasttNameTextBox(String lastNameValue) {
        waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastNameValue);
    }

    public void enterToEmailTextBox(String emailValue) {
        waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailValue);
    }

    public void enterToPasswordTextBox(String passwordValue) {
        waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, passwordValue);
    }

    public void enterToconfirmPasswordTextBox(String confirmPasswordTextBox) {
        waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPasswordTextBox);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisterSuccessMessageText() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTRATION_COMPLETED_MSG);
        return getElementText(driver, UserRegisterPageUI.REGISTRATION_COMPLETED_MSG);
    }
    public UserHomePO clickToNopcommerceLogo() {
        waitForElementClickable(driver, UserRegisterPageUI.NOP_COMMERCE_LOG);
        clickToElement(driver, UserRegisterPageUI.NOP_COMMERCE_LOG);
        return PageGenerator.getUserHomePage(driver);
    }


}
