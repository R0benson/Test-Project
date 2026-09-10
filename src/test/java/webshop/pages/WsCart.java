package webshop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class WsCart {
    private final SelenideElement checkItemName = $("a.product-name");

    public WsCart itemNameInCart(String Name) {
        checkItemName.shouldHave(text(Name));
        return this;
    }
    public String getQuantityInCart() {
        return $("input.qty-input").getAttribute("value");
    }
    public WsCart checkSubtotal(String itemPrice, String itemQuantity) {
        $("span.product-subtotal").shouldHave(text(String.valueOf(Float.parseFloat(itemPrice) * Float.parseFloat(itemQuantity))));
        return this;
    }
}
