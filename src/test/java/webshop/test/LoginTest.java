package webshop.test;

import io.qameta.allure.*;
import net.datafaker.Faker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import webshop.pages.WsLoginPage;
import webshop.pages.WsRegistrationPage;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static webshop.config.WebShopConfig.*;

public class LoginTest extends TestBase {
    private static final Faker faker = new Faker();
    private String email;
    private String password;

    @Nested
    public class PositiveTests {
        @BeforeEach
        void BeforeEach() {
            password = faker.camera().model() + faker.number().positive();
            email = faker.internet().emailAddress();

            open(WEB_SHOP_REGISTRATION_URL, WsRegistrationPage.class)
                    .register(
                            faker.name().firstName(),
                            faker.name().lastName(),
                            email,
                            password)
                    .checkRegistrationCompleted()
                    .checkEmailShown(email);


            clearBrowserCookies();
            clearBrowserLocalStorage();
        }

        @Test
        @Owner("Nikita")
        @Tag("positive")
        @Severity(CRITICAL)
        @Feature("Авторизация пользователя")
        @Story("Авторизация пользователя в учетную запись")
        @Link(name = "TASK-123",url = "https://qafeelsgood.kaiten.ru/space/827937/boards/card/69506527")
        @DisplayName("Успешная авторизация пользователя")
        @Description("Производим авторизацию пользователя")
        void successLoginTest() {

            open(WEB_SHOP_URL, WsLoginPage.class)
                    .openLoginPage()
                    .checkLoginPageOpened()
                    .enterEmail(email)
                    .enterPassword(password)
                    .clickRememberMe()
                    .clickLoginButton()
                    .checkEmail(email);
        }
    }
    @ParameterizedTest(name = "Авторизация с невалидным email: {0} ")
    @CsvFileSource(resources = "/email.csv")
    void invalidEmailLoginTest(String email) {
        open(WEB_SHOP_LOGIN_URL, WsLoginPage.class)
                .enterEmail(email)
                .enterPassword("password")
                .clickLoginButton()
                .verifyEmailValidationErrorAppear();
    }
}
