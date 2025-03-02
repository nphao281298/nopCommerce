package pageObject.nopCommerce.users;

import commons.BasePage;
import io.qameta.allure.Step;
import pageObject.nopCommerce.PageGenerator;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.users.UserRegisterPageUI;
import pojoData.UserInfo;

public class UserRegisterPO extends BasePage {
    WebDriver driver;
    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter to First Name textbox with value: {0}")
    public void enterToFirstNameTextBox(String firstNameValue) {
        waitForElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstNameValue);
    }

    @Step("Enter to Last Name textbox with value: {0}")
    public void enterToLasttNameTextBox(String lastNameValue) {
        waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastNameValue);
    }

    @Step("Enter to Email textbox with value: {0}")
    public void enterToEmailTextBox(String emailValue) {
        waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailValue);
    }

    @Step("Enter to Password textbox with value: {0}")
    public void enterToPasswordTextBox(String passwordValue) {
        waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, passwordValue);
    }
    @Step("Enter to Confirms Password textbox with value: {0}")
    public void enterToconfirmPasswordTextBox(String confirmPasswordTextBox) {
        waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPasswordTextBox);
    }

    @Step("Click Register button")
    public void clickToRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }
    @Step("Get register success message")
    public String getRegisterSuccessMessageText() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTRATION_COMPLETED_MSG);
        return getElementText(driver, UserRegisterPageUI.REGISTRATION_COMPLETED_MSG);
    }
    @Step("Click Nopcommerce Logo")
    public UserHomePO clickToNopcommerceLogo() {
        waitForElementClickable(driver, UserRegisterPageUI.NOP_COMMERCE_LOG);
        clickToElement(driver, UserRegisterPageUI.NOP_COMMERCE_LOG);
        return PageGenerator.getUserHomePage(driver);
    }

    @Step("Get register page title")
    public String getRegisterPagetitle(){
        waitForElementVisible(driver, UserRegisterPageUI.REGISTER_PAGE_TITLE);
        return getElementText(driver, UserRegisterPageUI.REGISTER_PAGE_TITLE);
    }

    @Step("Set data to register form {0}")
    public void setToRegisterForm(UserInfo userInfo){
        enterToFirstNameTextBox(userInfo.getFirstName());
        enterToLasttNameTextBox(userInfo.getLastName());
        enterToEmailTextBox(userInfo.getEmailAddress());
        enterToPasswordTextBox(userInfo.getPassword());
        enterToconfirmPasswordTextBox(userInfo.getPassword());
    }
}
