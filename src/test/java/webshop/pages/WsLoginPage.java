package webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsLoginPage {
    private final SelenideElement clickLoginIn = $("a.ico-login");
    private final SelenideElement loginPageOpened = $("div.page-title h1");
    private final SelenideElement emailInput = $("input#Email");
    private final SelenideElement passwordInput = $("input#Password");
    private final SelenideElement rememberMeCheckBox = $("input#RememberMe");
    private final SelenideElement clickLoginButton = $("input.login-button");
    private final ElementsCollection emailShown = $$("div.header-links ul li a");

    @Step("Перейти на страницу авторизации")
    public WsLoginPage openLoginPage() {
        clickLoginIn.click();

        return this;
    }
    @Step("Проверяем действительно ли мы перешли на страницу авторизации")
    public WsLoginPage checkLoginPageOpened() {
        loginPageOpened.shouldHave(text("Welcome, Please Sign In!"));

        return this;
    }

    @Step("Ввести электронную почту {email}")
    public WsLoginPage enterEmail(String email) {
        emailInput.setValue(email);

        return this;
    }
    @Step("Ввести пароль {password}")

    public WsLoginPage enterPassword(String password) {
        passwordInput.setValue(password);

        return this;
    }
    @Step("Выбираем параметр RememberMe")
    public WsLoginPage clickRememberMe() {
        rememberMeCheckBox.click();


        return this;
    }
    @Step("Подтвердить авторизацию")

    public WsLoginPage clickLoginButton() {
        clickLoginButton.click();

        return this;
    }
    @Step("Проверить, что появилось сообщение с ошибкой валидации почты")

    public WsLoginPage verifyEmailValidationErrorAppear() {
        $("span.field-validation-error").shouldBe(visible);

        return this;
    }
    @Step("Проверить электронную почту {email}")
    public WsLoginPage checkEmail(String email) {
        emailShown.get(0).shouldHave(text(email));

        return this;
    }
}
