package webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsMainPage {
        private final ElementsCollection selectCategoryComputersDesktops = $$("ul.top-menu li a");
        private final SelenideElement selectTypeComputer = $(byText("Desktops"));
        private final ElementsCollection selectItem = $$("div.product-grid div");
        private final SelenideElement setQuantity = $("input.qty-input");
        private final ElementsCollection processors = $$("dl dd ul li").get(0).$$("li input");
        private final SelenideElement addCartButton = $("input.add-to-cart-button");
        private final SelenideElement notification = $("div.bar-notification.success");
        private final SelenideElement quantityInCart = $("span.cart-qty");
        private final SelenideElement goToTheCart = $("a.ico-cart");
        private final SelenideElement itemName = $("[itemprop=name]");
        private final SelenideElement itemPrice = $("[itemprop=price]");

    @Step("Наводимся на категорию")

    public WsMainPage hoverCategoryComputers() {
            selectCategoryComputersDesktops.get(1).hover();

            return this;
        }
    @Step("Выбираем категорию")

    public WsMainPage clickTypeComputer() {
        selectTypeComputer.click();

        return this;
    }
    @Step("Выбираем первый товар из категории")

    public WsMainPage selectFirstItemFromList() {
        selectItem.get(0).click();

        return this;
    }
    @Step("Выбираем кол-во товара {itemQuantity}")

    public WsMainPage setQuantityItem(String itemQuantity) {
        setQuantity.setValue(itemQuantity);
        return this;
    }
    @Step("Выбираем тип процессора")

    public WsMainPage selectProcessor(int index) {
        processors.get(index).click();

        return this;
    }
    @Step("Нажимаем добавить в корзину")

    public WsMainPage clickAddCartButton() {
        addCartButton.click();
        return this;
    }
    @Step("Проверяем появилось ли уведомление")

    public WsMainPage checkNotification() {
        notification.shouldBe(visible);

        return this;
    }
    @Step("Проверяем кол-во товара в корзине {itemQuantity}")
    public WsMainPage checkQuantityItemInCart(String Quantity) {
        quantityInCart.shouldHave(text("(" + Quantity + ")"));
        return this;
    }
    @Step("Переходим в корзину")
    public WsMainPage clickOnTheCart() {
        goToTheCart.click();
        return this;
    }
    public String getItemName() {
        return itemName.getText();
    }

    public String getItemPrice() {
        return itemPrice.getText();
    }
}
