package ru.regard.framework.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.regard.framework.core.BaseTests;
import ru.regard.framework.pages.MainPage;
import ru.regard.framework.utils.MyAllureListener;

@ExtendWith(MyAllureListener.class)
@DisplayName("Набор тестов для Regard.ru")
public class RegardTest extends BaseTests {
    @Test
    @DisplayName("Добавление товара в корзину")
    public void addToCart() {
        app.getPage(MainPage.class)
                .getBtnCatalog()
                .categoryOfCatalog("Электроника")
                .waitLoadPage()
                .selectSubCategory("Планшеты")
                .waitLoadPage();
    }
}
