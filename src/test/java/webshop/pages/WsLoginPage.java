package webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
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


    public WsLoginPage openLoginPage() {
        clickLoginIn.click();

        return this;
    }
    public WsLoginPage checkLoginPageOpened() {
        loginPageOpened.shouldHave(text("Welcome, Please Sign In!"));

        return this;
    }
    public WsLoginPage enterEmail(String email) {
        emailInput.setValue(email);

        return this;
    }
    public WsLoginPage enterPassword(String password) {
        passwordInput.setValue(password);

        return this;
    }
    public WsLoginPage clickRememberMe() {
        rememberMeCheckBox.click();


        return this;
    }
    public WsLoginPage clickLoginButton() {
        clickLoginButton.click();

        return this;
    }
    public WsLoginPage checkEmail(String email) {
        emailShown.get(0).shouldHave(text(email));

        return this;
    }
}
