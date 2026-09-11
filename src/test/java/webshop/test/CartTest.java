package webshop.test;

import io.qameta.allure.*;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import webshop.pages.WsCart;
import webshop.pages.WsMainPage;
import webshop.steps.AuthSteps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static webshop.config.config.WEB_SHOP_URL;

public class CartTest extends TestBase {
    private static final Faker faker = new Faker();
    private final AuthSteps authSteps = new AuthSteps();


    @BeforeEach
    void beforeEach() {
       authSteps.registerNewUser();
    }

    @Test
    @Owner("Nikita")
    @Tag("possitive")
    @Severity(CRITICAL)
    @Feature("Добавление товара в корзину из каталога")
    @Story("Добавление товара в корзину из каталога")
    @Link(name = "TASK-121",url = "https://qafeelsgood.kaiten.ru/space/827937/boards/card/69506527")
    @DisplayName("Успешное добавление товара в корзину из каталога")
    @Description("Проваливаемся в категорию - выбираем первый товар из спика - меняем его параметры и переходим в корзину - далее проверяем правильно ли сохранились данные")
    void addItemToCartTest() {

    WsMainPage page = open(WEB_SHOP_URL, WsMainPage.class)
            .hoverCategoryComputers()
            .clickTypeComputer()
            .selectFirstItemFromList();

        String itemName  = page.getItemName();
        String itemPrice = page.getItemPrice();
        String itemQuantity = "2";

        page.setQuantityItem(itemQuantity)
                .selectProcessor(0)
                .clickAddCartButton()
                .checkNotification()
                .checkQuantityItemInCart(itemQuantity)
                .clickOnTheCart();
                WsCart cart = page(WsCart.class)
                .itemNameInCart(itemName)
                .checkSubtotal(itemPrice, itemQuantity);
        assertEquals(itemQuantity, cart.getQuantityInCart());

    }
}
