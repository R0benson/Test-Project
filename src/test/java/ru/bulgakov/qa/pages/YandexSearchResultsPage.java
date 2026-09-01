package ru.bulgakov.qa.pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YandexSearchResultsPage extends BasePage {

    private final SelenideElement distributionCloseButton = $(".DistributionButtonClose");

    public YandexSearchResultsPage closeDistributionBanner() {
        if (distributionCloseButton.is(visible, Duration.ofSeconds(3))) {
            distributionCloseButton.click();
        }
        return this;
    }

    public YandexSearchResultsPage openLinkWebsite(String websiteName) {
        $$("a[href*='" + websiteName + "']").filterBy(visible)
                .first()
                .click();

        return this;
    }
}
