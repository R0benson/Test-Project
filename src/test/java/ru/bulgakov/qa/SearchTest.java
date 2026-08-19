package ru.bulgakov.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import pages.WelcomePage;
import pages.YandexSearchPage;
import pages.YandexSearchResultsPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest {
    /*
     * Тест-кейс - проверить, что поиск статьи на википедии работает корректно
     * 1. открыть поисковик (Яндекс)
     * 2. ввести данные сайта (wikipedia)
     * 3. прожать Enter
     * 4. в поисковой выдаче найти нужный сайт, кликнуть на него
     * 5. нажать на поле поиска
     * 6. ввести "JAVA"
     * 7. Нажать кнопку "Найти"
     * 8. проверить, что выдает статью о Джаве
     */
    @Test
    void ProbniyTest() {
        Configuration.holdBrowserOpen = true;
        YandexSearchPage yandexSearchPage = new YandexSearchPage();
        WelcomePage welcomePage = new WelcomePage();

    open("https://ya.ru/");
    yandexSearchPage
            .search("wikipedia")
            .DistributionButtonClose()
            .OpenLinkWebsite("wikipedia.org");
        switchTo().window(1);
        welcomePage.search("Java")
                        .checkInfo();

    }
}

