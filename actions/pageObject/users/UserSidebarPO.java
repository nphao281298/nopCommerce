package pageObject.users;

import commons.BasePage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import pageUIs.users.UserSidebarPageUI;

public class UserSidebarPO extends BasePage {
    WebDriver driver;
    public UserSidebarPO(WebDriver driver) {
        this.driver = driver;
    }

    public UserAddressPO openAddressPage() {
        waitForElementClickable(driver, UserSidebarPageUI.ADDRESS_LINK);
        clickToElement(driver, UserSidebarPageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }

    public UserRewarPointPO openRewardPointPage() {
        waitForElementClickable(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        clickToElement(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getUserRewarPointPage(driver);
    }

    public UserCustomerInforPO openCustomerInfoPage() {
        waitForElementClickable(driver, UserSidebarPageUI.CUSTOMER_INFOR_LINK);
        clickToElement(driver, UserSidebarPageUI.CUSTOMER_INFOR_LINK);
        return PageGenerator.getUserCustomerInforPage(driver);
    }
    public UserOrderPO openOrderPage() {
        waitForElementClickable(driver, UserSidebarPageUI.ORDER_LINK);
        clickToElement(driver, UserSidebarPageUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }
}
