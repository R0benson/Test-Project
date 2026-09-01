package ru.bulgakov.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class WikiMainPage extends BasePage {
    private final SelenideElement searchInput = $("#searchInput");

    public WikiArticlePage search(String query) {
        searchInput.setValue(query).pressEnter();

        return new WikiArticlePage();
    }
}
