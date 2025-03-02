package pageObject.nopCommerce.users;

import commons.BasePage;
import io.qameta.allure.Step;
import pageObject.nopCommerce.PageGenerator;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.users.UserSidebarPageUI;

public class UserSidebarPO extends BasePage {
    WebDriver driver;
    public UserSidebarPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open Address Page")
    public UserAddressPO openAddressPage() {
        waitForElementClickable(driver, UserSidebarPageUI.ADDRESS_LINK);
        clickToElement(driver, UserSidebarPageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }

    @Step("Open Rewar Point Page")
    public UserRewarPointPO openRewardPointPage() {
        waitForElementClickable(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        clickToElement(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getUserRewarPointPage(driver);
    }

    @Step("Open Customer Page")
    public UserCustomerInforPO openCustomerInfoPage() {
        waitForElementClickable(driver, UserSidebarPageUI.CUSTOMER_INFOR_LINK);
        clickToElement(driver, UserSidebarPageUI.CUSTOMER_INFOR_LINK);
        return PageGenerator.getUserCustomerInforPage(driver);
    }

    @Step("Open Order Page")
    public UserOrderPO openOrderPage() {
        waitForElementClickable(driver, UserSidebarPageUI.ORDER_LINK);
        clickToElement(driver, UserSidebarPageUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }


    @Step("Open sidebar link by page name: {0}")
    public UserSidebarPO openSidebarLinkByPageName(String pageName){
        waitForElementClickable(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        clickToElement(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        switch (pageName){
            case "Addresses":
                return PageGenerator.getUserAddressPage(driver);
            case "Reward points":
                return PageGenerator.getUserRewarPointPage(driver);
            case "Customer info":
                return PageGenerator.getUserCustomerInforPage(driver);
            case "Orders":
                return PageGenerator.getUserOrderPage(driver);
            default:
                throw new RuntimeException("Page name is not valid") ;
        }

    }

    public void openSidebarLinkByPageNames(String pageName){
        waitForElementClickable(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        clickToElement(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
    }
}
