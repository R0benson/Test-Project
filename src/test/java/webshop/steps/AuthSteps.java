package webshop.steps;

import net.datafaker.Faker;
import webshop.pages.WsRegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static webshop.config.WebShopConfig.WEB_SHOP_REGISTRATION_URL;

public class AuthSteps {

    private static final Faker faker = new Faker();
    private final String email = faker.internet().emailAddress();
    private final String password = faker.camera().model() + faker.number().digits(5);


    public AuthSteps registerNewUser() {
        open(WEB_SHOP_REGISTRATION_URL, WsRegistrationPage.class)
                .register(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        email,
                        password)
                .checkRegistrationCompleted();

        return this;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}
