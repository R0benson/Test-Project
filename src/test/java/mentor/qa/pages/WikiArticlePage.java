package mentor.qa.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class WikiArticlePage extends BasePage {
    private final SelenideElement articleText = $("#mw-content-text");
    private final SelenideElement articleTitle = $("#firstHeading");

    @Step("Проверить выданную информацию {expectedText}")

    public WikiArticlePage checkInfo(String expectedText) {
        articleText.shouldHave(text(expectedText));
        return this;
    }
    @Step("Проверить выданную информацию {expectedText}")

    public WikiArticlePage checkTitle(String expectedTitle) {
        articleTitle.shouldHave(text(expectedTitle));

        return this;
    }
}
