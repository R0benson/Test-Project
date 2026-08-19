package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class YandexSearchResultsPage {


    public YandexSearchResultsPage OpenLinkWebsite(String websiteName) {
        $(byText(websiteName)).click();

        return this;
    }
}
