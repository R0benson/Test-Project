package mentor.qa.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class WikiMainPage extends BasePage {
    private final SelenideElement searchInput = $("#searchInput");
    @Step("Проверить верно ли выдает информацию о {query}")

    public WikiArticlePage search(String query) {
        searchInput.setValue(query).pressEnter();

        return new WikiArticlePage();
    }
}
