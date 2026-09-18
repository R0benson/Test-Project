package webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsMainPage {
        private final ElementsCollection topMenuItems = $$("ul.top-menu > li > a");
        private final SelenideElement setQuantity = $("input.qty-input");
        private final SelenideElement addCartButton = $("input.add-to-cart-button");
        private final SelenideElement notification = $("div.bar-notification.success");
        private final SelenideElement quantityInCart = $("span.cart-qty");
        private final SelenideElement goToTheCart = $("a.ico-cart");
        private final SelenideElement itemPrice = $("[itemprop=price]");
        private final ElementsCollection productLinks = $$("h2.product-title a");
        private final SelenideElement attributes = $("div.attributes");
    private final SelenideElement desktopsLink = $$("ul.top-menu > li > ul > li > a").findBy(text("Desktops"));

    @Step("Наводимся на категорию Computers")
    public WsMainPage hoverCategoryComputers() {
        topMenuItems.findBy(text("Computers")).hover();
        return this;
        }
    @Step("Выбираем категорию Desktops")
    public WsMainPage clickTypeComputer() {
        desktopsLink.click();
        return this;
    }
    @Step("Открыть карточку товара {productName}")
    public WsMainPage openProduct(String productName) {
        productLinks.findBy(exactText(productName)).click();
        return this;
    }
    @Step("Выбираем кол-во товара {itemQuantity}")
    public WsMainPage setQuantityItem(String itemQuantity) {
        setQuantity.setValue(itemQuantity);
        return this;
    }
    @Step("Выбираем процессор {processor}")
    public WsMainPage selectProcessor(String processor) {
        attributeOptions("Processor")
                .findBy(text(processor))
                .$("input")
                .click();
        return this;
    }
    private ElementsCollection attributeOptions(String groupTitle) {
        return attributes.$$("dl dt")
                .findBy(text(groupTitle))
                .sibling(0)
                .$$("li");
    }
    @Step("Нажимаем добавить в корзину")
    public WsMainPage clickAddCartButton() {
        addCartButton.click();
        return this;
    }
    @Step("Проверяем появилось ли уведомление")
    public WsMainPage checkNotification() {
        notification.shouldBe(visible).shouldHave(text("The product has been added to your shopping cart"));
        return this;
    }
    @Step("Проверяем кол-во товара в корзине {quantity}")
    public WsMainPage checkQuantityItemInCart(String quantity) {
        quantityInCart.shouldHave(text("(" + quantity + ")"));
        return this;
    }
    @Step("Переходим в корзину")
    public WsMainPage clickOnTheCart() {
        goToTheCart.click();
        return this;
    }

    public String getItemPrice() {
        return itemPrice.getText();
    }
}
