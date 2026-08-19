package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class JavaCheck {
    private final SelenideElement articleText = $("#mwAg");

    public JavaCheck checkInfo() {
        articleText.shouldHave(text("Эта статья — о языке программирования. О прикладной платформе на основе данного языка см. Java (программная платформа)."));
        return this;
    }
}
