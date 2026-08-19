package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class WelcomePage {
    private final SelenideElement searchJava = $("#searchInput");

    public JavaCheck search (String query) {
    searchJava.setValue(query).pressEnter();
    return new JavaCheck();
    }
}
