package ru.bulgakov.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class WikiArticlePage extends BasePage {
    private final SelenideElement articleText = $("#mw-content-text");
    private final SelenideElement articleTitle = $("#firstHeading");

    public WikiArticlePage checkInfo(String expectedText) {
        articleText.shouldHave(text(expectedText));
        return this;
    }

    public WikiArticlePage checkTitle(String expectedTitle) {
        articleTitle.shouldHave(text(expectedTitle));

        return this;
    }
}
