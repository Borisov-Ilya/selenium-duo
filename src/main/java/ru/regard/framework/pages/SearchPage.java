package ru.regard.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
    @FindBy(xpath = "//span[contains(@class, 'PageTitle_count')]")
    private WebElement titleCount;

    @Step
    public SearchPage waitLoadPage() {
        waitUtilElementToBeVisible(titleCount);
        return this;
    }
}
