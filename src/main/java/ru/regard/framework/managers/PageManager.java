package ru.regard.framework.managers;

import ru.regard.framework.pages.CategoryPage;
import ru.regard.framework.pages.MainPage;
import ru.regard.framework.pages.SearchPage;

/**
 * Класс для управления страничками
 */
public class PageManager {

    /**
     * Менеджер страниц
     */
    private static PageManager pageManager;

    /**
     * Главная страница
     */
    private MainPage mainPage;

    /**
     * Страница категорий товаров
     */
    private CategoryPage categoryPage;

    /**
     * Страница поиска
     */
    private SearchPage searchPage;

    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     *
     * @see PageManager#getPageManager()
     */
    private PageManager() {
    }

    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация {@link MainPage}
     *
     * @return MainPage
     */
    public MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    /**
     * Ленивая инициализация {@link CategoryPage}
     *
     * @return MainPage
     */
    public CategoryPage getCategoryPage() {
        if (categoryPage == null) {
            categoryPage = new CategoryPage();
        }
        return categoryPage;
    }

    /**
     * Ленивая инициализация {@link MainPage}
     *
     * @return MainPage
     */
    public SearchPage getSearchPage() {
        if (searchPage == null) {
            searchPage = new SearchPage();
        }
        return searchPage;
    }
}
