package pageObject.nopCommerce.users;

import org.openqa.selenium.WebDriver;

public class UserAddressPO extends UserSidebarPO {
    WebDriver driver;
    public UserAddressPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
