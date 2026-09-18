package webshop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class WsCartPage {
    private final SelenideElement checkItemName = $("a.product-name");
    private final SelenideElement subtotal = $("span.product-subtotal");
    private final SelenideElement unitPrice = $("span.product-unit-price");
    private final SelenideElement quantityInput = $("input.qty-input");

    @Step("Проверяем действительно ли добавился нужный товар в корзину {name}")
    public WsCartPage itemNameInCart(String name) {
        checkItemName.shouldHave(text(name));
        return this;
    }
    @Step("Получить имя товара в корзине")
    public String getItemName() {
        return checkItemName.getText();
    }
    @Step("Получить количество товара в корзине")
    public String getQuantityInCart() {
        return quantityInput.getAttribute("value");
    }
    @Step("Получить цену за штуку в корзине")
    public String getUnitPrice() {
        return unitPrice.getText();
    }
    @Step("Получить сумму подытога из корзины")
    public String getSubtotal() {
        return subtotal.getText();
    }
}
