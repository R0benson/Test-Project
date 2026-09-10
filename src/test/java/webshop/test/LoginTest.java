package webshop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webshop.pages.WsLoginPage;
import webshop.pages.WsRegistrationPage;
import webshop.pages.WsWelcomePage;

import static com.codeborne.selenide.Selenide.*;
import static webshop.config.config.WEB_SHOP_REGISTRATION_URL;
import static webshop.config.config.WEB_SHOP_URL;

public class LoginTest {
    private static final Faker faker = new Faker();
    private String email;
    private String password;

 @BeforeEach
    void beforeAll() {
     password = faker.camera().model() + faker.number().positive();
     email = faker.internet().emailAddress();

        open(WEB_SHOP_REGISTRATION_URL, WsRegistrationPage.class)
                .register(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        email,
                        password)
                .checkEmailShown(email);


        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @Test
    void succesLoginTest() {

        open("https://demowebshop.tricentis.com/", WsLoginPage.class)
                .openLoginPage()
                .checkLoginPageOpened()
                .enterEmail(email)
                .enterPassword(password)
                .clickRememberMe()
                .clickLoginButton()
                .checkEmail(email);
        System.out.println(1);
    }
}
