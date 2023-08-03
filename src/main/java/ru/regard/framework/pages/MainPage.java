package ru.regard.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {


    @FindBy(xpath = "//button[contains(@class, 'burger')]")
    private WebElement btnCatalog;

    @FindBy(xpath = "//div[contains(@class, 'mainCategoryName')]")
    private List<WebElement> categoryMenus;


    public MainPage getBtnCatalog() {
        waitUtilElementToBeVisible(btnCatalog).click();
        return this;
    }

    public MainPage categoryOfCatalog(String nameMenu) {
        for (WebElement itemMenu : categoryMenus) {
            waitUtilElementToBeVisible(itemMenu);
            if (itemMenu.getText().contains(nameMenu)) {
                itemMenu.click();
                return pageManager.getMainPage();
            }

        }
        Assertions.fail("меню с текстом" + nameMenu + "не найдена на странице")
        return pageManager.getMainPage();

}
}
