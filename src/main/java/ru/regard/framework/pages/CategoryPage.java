package ru.regard.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class CategoryPage extends BasePage {
    @FindBy(xpath = "//h1")
    private WebElement title;

    @FindBy(xpath = "//p[contains(@class, 'CardCategory_title')]")
    private List<WebElement> subCategoryList;

    @Step
    public CategoryPage waitLoadPage() {
        waitUtilElementToBeVisible(title);
        return this;
    }

    @Step
    public SearchPage selectSubCategory(String nameSubCategory) {
        for (WebElement subCategoryItem : subCategoryList) {
            try {
                waitUtilElementToBeVisible(subCategoryItem);
                if (subCategoryItem.getText().contains(nameSubCategory)) {
                    waitUtilElementToBeClickable(subCategoryItem).click();
                    return pageManager.getSearchPage();
                }
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();
            }
        }
        fail("Подкатегория товаров '" + nameSubCategory + "' не была найдена!");
        return pageManager.getSearchPage();
    }
}
