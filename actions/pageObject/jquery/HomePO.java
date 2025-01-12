package pageObject.jquery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.HomePageUI;

import java.util.ArrayList;
import java.util.List;

public class HomePO extends BasePage {
    WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageByNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        clickToElement(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        sleepInSecond(2);
    }

    public boolean isPageNumberActived(String pageNumber, String attribute) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        return getElementAttribute(driver,HomePageUI.DYNAMIC_PAGE_LINK, attribute, pageNumber).endsWith("active");
    }

    public void enterToTextBoxByHeaderName(String headerName, String valueToSendKey) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, headerName);
        sendKeysToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, valueToSendKey, headerName);
        pressKeyToElement(driver,HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, Keys.ENTER, headerName);
    }

    public boolean isRowDataValueDisplayed(String females, String country, String males, String total) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_DATA_ROW, females,country,males, total);
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_DATA_ROW, females,country,males, total);
    }

    public void deleteRowByCountryName(String countryName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME, countryName );
        sleepInSecond(2);
    }

    public void editRowByCoutryName(String countryName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME, countryName );
        sleepInSecond(2);
    }

    public void clickToLoadDataButton() {
        waitForElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
        clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);
    }

    public void enterToTextBoxByIndex(String rowIndex, String columnName, String valueToSendkey) {
        // Lay ra duoc index cua cot
//        int columnIndexNumber = getListElementsSize(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName);
        int columnIndexNumber = getListWebElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName).size()+1;
        // Convert qua dang text(String)
        String columnIndex = String.valueOf(columnIndexNumber);
//        System.out.println(columnIndex);
//        System.out.println(columnIndex.getClass().getName());
        // Truyen 2 gia tri:
        sendKeysToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX, valueToSendkey, rowIndex, columnIndex);
    }


    public void selectToDropDownByIndex(String rowIndex, String columnName, String valueToSelect) {
        int columnIndexNumber = getListWebElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName).size()+1;
        String columnIndex = String.valueOf(columnIndexNumber);
        selecteItemInDefaultDropdown(driver,HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX,valueToSelect, rowIndex, columnIndex);
    }

    public void checkToCheckBoxByIndex(String rowIndex, String columnName, boolean checkOrUncheck) {
        int columnIndexNumber = getListWebElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName).size()+1;
        String columnIndex = String.valueOf(columnIndexNumber);
        if(checkOrUncheck){
            checkToElement(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
        }else {
            unCheckElement(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
        }
    }

    public void clickToIconByIndex(String rowIndex, String buttonName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_ICON_BY_ROW_INDEX, rowIndex, buttonName);
        clickToElement(driver, HomePageUI.DYNAMIC_ICON_BY_ROW_INDEX, rowIndex, buttonName);
    }

    public List<String> getAllValueAtColumnName(String columnName) {
        // Get the column index based on the column name
        int columnIndexNumber = getListWebElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER_2, columnName).size() + 1;

        // Convert the column index to a string
        String columnIndex = String.valueOf(columnIndexNumber);

        // Get all elements' values in the specified column
        List<WebElement> allElementValueAtColumn = getListWebElement(driver, HomePageUI.ALL_VALUE_BY_COLUMN_INDEX, columnIndex);

        // Initialize a list to store the text values
        List<String> allTextValue = new ArrayList<>();

        // Iterate through each element and add its text to the list
        for (WebElement element : allElementValueAtColumn) {
            allTextValue.add(element.getText());
        }

        // Return the list of text values
        return allTextValue;
    }

    public boolean isFileLoadedByName(String fileName) {
        waitForElementVisible(driver, HomePageUI.FILE_LOADED_BY_FILE_NAME, fileName);
        return isElementDisplayed(driver, HomePageUI.FILE_LOADED_BY_FILE_NAME, fileName);
    }

    public void clickToUploadButton(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.UPLOAD_BUTTON);
        clickToElement(driver, HomePageUI.UPLOAD_BUTTON);
    }

    public void clickToListUploadButton(WebDriver driver){
        List<WebElement> startButtons = getListWebElement(driver, HomePageUI.LIST_UPLOAD_BUTTON);
        for (WebElement button: startButtons){
            button.click();
            sleepInSecond(3);
        }
    }

    public boolean isFileLoadSuccessByName(String fileName) {
        waitForElementVisible(driver, HomePageUI.FILE_UPLOADED_SUCCESS_BY_FILE_NAME, fileName);
        return isElementDisplayed(driver, HomePageUI.FILE_UPLOADED_SUCCESS_BY_FILE_NAME, fileName);
    }
}
