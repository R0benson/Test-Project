package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class YandexSearchPage {
    private final SelenideElement searchInupt = $("#text");
    private final SelenideElement DistributionButtonClose = $(".DistributionButtonClose");


    public YandexSearchPage search(String query) {
        searchInupt.setValue(query).pressEnter();
    return this;
    }

    public YandexSearchResultsPage DistributionButtonClose() {
        DistributionButtonClose.click();
        return new YandexSearchResultsPage();
    }
}
