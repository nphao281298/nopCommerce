package pageObject.nopCommerce.users;

import org.openqa.selenium.WebDriver;

public class UserOrderPO extends UserSidebarPO {
    WebDriver driver;
    public UserOrderPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
