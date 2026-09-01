package ru.bulgakov.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.bulgakov.qa.pages.WikiMainPage;
import ru.bulgakov.qa.pages.YandexSearchPage;
import ru.bulgakov.qa.Constant;
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
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 30000;
        Configuration.timeout = 10000;
    }

    @Test
    void javaArticleShouldOpenFromYandexTest() {

        open(Constant.YANDEX_URL, YandexSearchPage.class)
                .search("wikipedia")
                .closeDistributionBanner()
                .openLinkWebsite(Constant.WIKIPEDIA_HOST)
                .switchToWindow(1, WikiMainPage.class)
                .search("Java")
                .checkTitle("Java")
                .checkInfo("язык программирования");

    }
}

