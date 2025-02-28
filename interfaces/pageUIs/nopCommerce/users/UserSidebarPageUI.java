package pageUIs.nopCommerce.users;

public class UserSidebarPageUI {
    public static final String ADDRESS_LINK = "xpath=//div[contains(@class, 'block-account-navigation')]//li[contains(@class, 'customer-addresses')]/a";
    public static final String ORDER_LINK = "xpath=//div[contains(@class, 'block-account-navigation')]//li[contains(@class, 'customer-orders')]/a";
    public static final String REWARD_POINT_LINK = "xpath=//div[contains(@class, 'block-account-navigation')]//li[contains(@class, 'reward-points')]/a";
    public static final String CUSTOMER_INFOR_LINK = "xpath=//div[contains(@class, 'block-account-navigation')]//li[contains(@class, 'customer-info')]/a";
    public static final String DYNAMIC_LINK_BY_PAGE_NAME = "xpath=//div[contains(@class, 'block-account-navigation')]//a[text()='%s']";
}
