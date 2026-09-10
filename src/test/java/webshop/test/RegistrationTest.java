package webshop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import webshop.pages.WsWelcomePage;

import static com.codeborne.selenide.Selenide.*;
import static webshop.config.config.WEB_SHOP_URL;

public class RegistrationTest {
    private static final Faker faker = new Faker();

    @Test
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
