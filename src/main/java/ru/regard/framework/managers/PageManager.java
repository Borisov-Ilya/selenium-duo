package ru.regard.framework.managers;

import ru.regard.framework.pages.BasePage;
import ru.regard.framework.pages.CategoryPage;
import ru.regard.framework.pages.MainPage;
import ru.regard.framework.pages.SearchPage;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс для управления страничками
 */
public class PageManager {

    /**
     * Менеджер страниц
     */
    private static PageManager pageManager;
    private Map<String, BasePage> mapPages = new HashMap<>();

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

    public <T extends BasePage> T getPage(Class<T> ex) {
        if (mapPages.isEmpty() || mapPages.get(ex.getName()) == null) {
            try {
                mapPages.put(ex.getName(), ex.getDeclaredConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                     InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        return (T) mapPages.get(ex.getName());
    }

    public void clearMapPages() {
        mapPages.clear();
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
