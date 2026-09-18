package webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsRegistrationPage {
    private final SelenideElement maleGenderRadio = $("input#gender-male");
    private final SelenideElement pageTitle = $("div.page-title");
    private final SelenideElement firstNameInput = $("input#FirstName");
    private final SelenideElement lastNameInput = $("input#LastName");
    private final SelenideElement emailInput = $("input#Email");
    private final SelenideElement passwordInput = $("input#Password");
    private final SelenideElement confirmPasswordInput = $("input#ConfirmPassword");
    private final SelenideElement clickRegisterButton = $("input#register-button");
    private final SelenideElement resultText = $("div.result");
    private final ElementsCollection headerLinks = $$("div.header-links ul li a");


    public WsRegistrationPage register(String firstName, String lastName, String email, String password) {
                selectMalesGender()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .enterPassword(password)
                .enterConfirmPassword(password)
                .submitRegistration();
        return this;
    }
    @Step("Проверяем действительно ли открылась страница регистрации")
    public WsRegistrationPage verifyRegistrationOpened() {
        pageTitle.shouldHave(text("Register"));
        return this;
    }
    @Step("Выбираем гендер")
    public WsRegistrationPage selectMalesGender() {
        maleGenderRadio.click();
        return this;
    }
    @Step("Вводим имя {firstName}")
    public WsRegistrationPage enterFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }
    @Step("Вводим фамилию {lastName}")
    public WsRegistrationPage enterLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }
    @Step("Вводим почту {email}")
    public WsRegistrationPage enterEmail(String email) {
        emailInput.setValue(email);
        return this;
    }
    @Step("Вводим пароль {password}")
    public WsRegistrationPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }
    @Step("Подтверждаем пароль {confirmPassword}")
    public WsRegistrationPage enterConfirmPassword(String confirmPassword) {
        confirmPasswordInput.setValue(confirmPassword);
        return this;
    }
    @Step("Подтверждаем регистрацию")
    public WsRegistrationPage submitRegistration() {
        clickRegisterButton.click();
        return this;
    }
    @Step("Проверяем действительно ли мы зарегистрировались")
    public WsRegistrationPage checkRegistrationCompleted() {
        resultText.shouldHave(text("Your registration completed"));
        return this;
    }
    @Step("Проверяем отображение нашего email после регистрации {email}")
    public WsRegistrationPage checkEmailShown(String email) {
        headerLinks.get(0).shouldHave(text(email));
        return this;
    }
}
