package commons;

import org.openqa.selenium.WebDriver;
import pageObject.*;

public class PageGenerator {
    public static HomePageObject getHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }
    public static RegisterPageObject getRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }
    public static LoginPageObject getLoginPage(WebDriver driver) {return new LoginPageObject(driver);}
    public static CustomerInforPageObject getCustomerInforPage(WebDriver driver) {return new CustomerInforPageObject(driver);}
    public static AddressPageObject getAddressPage(WebDriver driver) {return new AddressPageObject(driver);}
    public static OrderPageObject getOrderPage(WebDriver driver) {return new OrderPageObject(driver);}
    public static RewarPointPageObject getRewarPointPage(WebDriver driver) {return new RewarPointPageObject(driver);}
}
