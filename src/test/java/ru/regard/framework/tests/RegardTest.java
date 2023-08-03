package ru.regard.framework.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.regard.framework.core.BaseTests;
import ru.regard.framework.utils.MyAllureListener;

@ExtendWith(MyAllureListener.class)
@DisplayName("123")
public class RegardTest extends BaseTests {
    @Test
    @DisplayName("Добавление товара в корзину")
    public void addToCart() {
        app.getMainPage()
                .getBtnCatalog()
                .categoryOfCatalog("Электроника")
                .waitLoadPage()
                .selectSubCategory("Планшеты")
                .waitLoadPage();
    }
    @Test
    @DisplayName("Добавление товара в корзину")
    public void addToCartTwo() {
        app.getMainPage()
                .getBtnCatalog()
                .categoryOfCatalog("Периферия")
                .waitLoadPage()
                .selectSubCategory("Мониторы")
                .waitLoadPage();
    }
}
