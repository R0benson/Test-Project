package webshop.test;

import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import webshop.pages.WsCartPage;
import webshop.pages.WsMainPage;
import webshop.steps.AuthSteps;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static webshop.config.WebShopConfig.WEB_SHOP_URL;

public class CartTest extends TestBase {
    private final AuthSteps authSteps = new AuthSteps();
    private static final String PRODUCT_NAME = "Build your own cheap computer";


    @BeforeEach
    void beforeEach() {
       authSteps.registerNewUser();
    }
    private float processorSurcharge(String processor) {
        return switch (processor) {
            case "Slow" -> 0f;
            case "Medium" -> 15f;
            case "Fast" -> 100f;
            default -> throw new IllegalArgumentException("Unknown processor: " + processor);
        };
    }
    @Test
    @Owner("Nikita")
    @Tag("positive")
    @Severity(CRITICAL)
    @Feature("Добавление товара в корзину из каталога")
    @Story("Добавление товара в корзину из каталога")
    @Link(name = "TASK-121",url = "https://qafeelsgood.kaiten.ru/space/827937/boards/card/69506527")
    @DisplayName("Успешное добавление товара в корзину из каталога")
    @Description("Проваливаемся в категорию - выбираем первый товар из списка - меняем его параметры и переходим в корзину - далее проверяем правильно ли сохранились данные")
    void addItemToCartTest() {
        String processor = "Slow";
        String itemQuantity = "2";
        WsMainPage page = open(WEB_SHOP_URL, WsMainPage.class)
                .hoverCategoryComputers()
                .clickTypeComputer()
                .openProduct(PRODUCT_NAME);

        String itemPrice = page.getItemPrice();

        page.setQuantityItem(itemQuantity)
                .selectProcessor(processor)
                .clickAddCartButton()
                .checkNotification()
                .checkQuantityItemInCart(itemQuantity)
                .clickOnTheCart();
        WsCartPage cart = page(WsCartPage.class);
        float basePrice = Float.parseFloat(itemPrice);
        float expectedUnitPrice = basePrice + processorSurcharge(processor);
        float expectedSubtotal = expectedUnitPrice * Float.parseFloat(itemQuantity);
        String expectedSubtotalText = String.format(Locale.US, "%.2f", expectedSubtotal);
        String expectedUnitPriceText = String.format(Locale.US, "%.2f", expectedUnitPrice);

        assertAll(
                () -> assertEquals(PRODUCT_NAME, cart.getItemName(), "Имя товара в корзине не совпадает с ожидаемым"),
                () -> assertEquals(itemQuantity, cart.getQuantityInCart(), "Количество товара в корзине не совпадает с ожидаемым"),
                () -> assertEquals(expectedUnitPriceText, cart.getUnitPrice(), "Цена за штуку в корзине не совпадает с ожидаемой"),
                () -> assertEquals(expectedSubtotalText, cart.getSubtotal(), "Сумма подытога в корзине не совпадает с ожидаемой")
        );
    }
    }
