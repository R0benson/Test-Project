package mentor.qa;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import mentor.qa.pages.WikiMainPage;
import mentor.qa.pages.YandexSearchPage;
import webshop.test.TestBase;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.SeverityLevel.CRITICAL;

public class SearchTest extends TestBase {
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
    @Owner("Nikita")
    @Tag("positive")
    @Severity(CRITICAL)
    @Feature("Поиск нужной информации в Яндекс")
    @Story("Поиск и проверка информации на сайте Java")
    @Link(name = "TASK-124",url = "https://qafeelsgood.kaiten.ru/space/827937/boards/card/69506527")
    @DisplayName("Успешный поиск сайта в яндекс и проверка информации на нем")
    @Description("Проверяем поиск сайта wikipedia в Яндекс, а также проверку информации на нем")
    void javaArticleShouldOpenFromYandexTest() {

        open(mentor.qa.Constant.YANDEX_URL, YandexSearchPage.class)
                .search("wikipedia")
                .closeDistributionBanner()
                .openLinkWebsite(mentor.qa.Constant.WIKIPEDIA_HOST)
                .switchToWindow(1, WikiMainPage.class)
                .search("Java")
                .checkTitle("Java")
                .checkInfo("язык программирования");

    }
}

