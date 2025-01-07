package commons;

import org.openqa.selenium.WebDriver;
import pageObject.admin.AdminDashboardPO;
import pageObject.admin.AdminLoginPO;
import pageObject.users.*;

public class PageGenerator {
    public static UserHomePO getUserHomePage(WebDriver driver){
        return new UserHomePO(driver);
    }
    public static UserRegisterPO getUserRegisterPage(WebDriver driver){
        return new UserRegisterPO(driver);
    }
    public static UserLoginPO getUserLoginPage(WebDriver driver) {return new UserLoginPO(driver);}
    public static UserCustomerInforPO getUserCustomerInforPage(WebDriver driver) {return new UserCustomerInforPO(driver);}
    public static UserAddressPO getUserAddressPage(WebDriver driver) {return new UserAddressPO(driver);}
    public static UserOrderPO getUserOrderPage(WebDriver driver) {return new UserOrderPO(driver);}
    public static UserRewarPointPO getUserRewarPointPage(WebDriver driver) {return new UserRewarPointPO(driver);}
    public static AdminDashboardPO getAdminDashboardPage(WebDriver driver){
        return new AdminDashboardPO(driver);
    }
    public static AdminLoginPO getAdminLoginPage(WebDriver driver){
        return new AdminLoginPO(driver);
    }
}
