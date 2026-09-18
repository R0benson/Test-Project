package webshop.test;

import io.qameta.allure.*;
import net.datafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import webshop.pages.WsWelcomePage;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static webshop.config.WebShopConfig.WEB_SHOP_URL;

public class RegistrationTest extends TestBase {
    private static final Faker faker = new Faker();

    @Test
    @Owner("Nikita")
    @Tag("positive")
    @Severity(CRITICAL)
    @Epic("Авторизация")
    @Feature("Регистрация")
    @Story("Регистрация нового пользователя")
    @Link(name = "TASK-120",url = "https://qafeelsgood.kaiten.ru/space/827937/boards/card/69506527")
    @DisplayName("Успешная регистрация нового пользователя")
    @Description("Создаем нового пользователя со случайными данными через интерфейс")
    void registrationTest() {
        String password = faker.camera().model() + faker.number().positive();
        String email = faker.internet().emailAddress();

        open(WEB_SHOP_URL, WsWelcomePage.class)
                .openRegistration()
                .verifyRegistrationOpened()
                .selectMalesGender()
                .enterFirstName(faker.name().firstName())
                .enterLastName(faker.name().lastName())
                .enterEmail(email)
                .enterPassword(password)
                .enterConfirmPassword(password)
                .submitRegistration()
                .checkRegistrationCompleted()
                .checkEmailShown(email);
    }

}
