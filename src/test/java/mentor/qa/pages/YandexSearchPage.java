package mentor.qa.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class YandexSearchPage extends BasePage {
    private final SelenideElement searchInput = $("#text");

    @Step("Ввести в поиск сайт {query}")
    public YandexSearchResultsPage search(String query) {
        searchInput.setValue(query).pressEnter();

        return page(YandexSearchResultsPage.class);
    }
}
