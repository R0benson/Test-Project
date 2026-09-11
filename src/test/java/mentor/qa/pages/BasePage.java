package mentor.qa.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.switchTo;

public abstract class BasePage {
    @Step("Переключить страницу")

    public <T> T switchToWindow(int index, Class<T> pageClass) {
        switchTo().window(index);

        return page(pageClass);
    }
}

