package webshop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webshop.pages.WsCart;
import webshop.pages.WsMainPage;
import webshop.steps.AuthSteps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static webshop.config.config.WEB_SHOP_URL;

public class CartTest {
    private static final Faker faker = new Faker();
    private final AuthSteps authSteps = new AuthSteps();


    @BeforeEach
    void beforeEach() {
       authSteps.registerNewUser();
    }

    @Test
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
