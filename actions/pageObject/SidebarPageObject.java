package pageObject;

import commons.BasePage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import pageUIs.PageBaseUI;
import pageUIs.SidebarPageUI;

public class SidebarPageObject extends BasePage {
    WebDriver driver;
    public SidebarPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AddressPageObject openAddressPage() {
        waitForElementClickable(driver, SidebarPageUI.ADDRESS_LINK);
        clickToElement(driver,SidebarPageUI.ADDRESS_LINK);
        return PageGenerator.getAddressPage(driver);
    }

    public RewarPointPageObject openRewardPointPage() {
        waitForElementClickable(driver, SidebarPageUI.REWARD_POINT_LINK);
        clickToElement(driver,SidebarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getRewarPointPage(driver);
    }

    public CustomerInforPageObject openCustomerInfoPage() {
        waitForElementClickable(driver, SidebarPageUI.CUSTOMER_INFOR_LINK);
        clickToElement(driver, SidebarPageUI.CUSTOMER_INFOR_LINK);
        return PageGenerator.getCustomerInforPage(driver);
    }
    public OrderPageObject openOrderPage() {
        waitForElementClickable(driver, SidebarPageUI.ORDER_LINK);
        clickToElement(driver, SidebarPageUI.ORDER_LINK);
        return PageGenerator.getOrderPage(driver);
    }
}
