package ru.bulgakov.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

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
    open("https://ya.ru/");
    $("#text").setValue("wikipedia").pressEnter();
    sleep(2000);
    $(".DistributionButtonClose").click();
    sleep(2000);
    $(byText("wikipedia.org")).click();
    switchTo().window(1);
    $("#searchInput").setValue("Java").pressEnter();
    $("#mwAg").shouldHave(text("Эта статья — о языке программирования. О прикладной платформе на основе данного языка см. Java (программная платформа)."));
    }
}

