package webshop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class WsCart {
    private final SelenideElement checkItemName = $("a.product-name");

    @Step("Проверяем действительно ли добавился нужный товар в корзину {name}")
    public WsCart itemNameInCart(String Name) {
        checkItemName.shouldHave(text(Name));
        return this;
    }
    @Step("Проверяем действительно ли добавилось нужное кол-во в корзину")
    public String getQuantityInCart() {
        return $("input.qty-input").getAttribute("value");
    }
    @Step("Проверяем действительно ли цена соответствует кол-во товаров в корзине")
    public WsCart checkSubtotal(String itemPrice, String itemQuantity) {
        $("span.product-subtotal").shouldHave(text(String.valueOf(Float.parseFloat(itemPrice) * Float.parseFloat(itemQuantity))));
        return this;
    }
}
