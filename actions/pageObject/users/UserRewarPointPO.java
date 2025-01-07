package pageObject.users;

import org.openqa.selenium.WebDriver;

public class UserRewarPointPO extends UserSidebarPO {
    WebDriver driver;
    public UserRewarPointPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
