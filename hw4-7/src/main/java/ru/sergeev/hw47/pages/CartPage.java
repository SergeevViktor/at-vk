package ru.sergeev.hw47.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import ru.sergeev.coreui.pages.BasePage;

import static com.codeborne.selenide.Selenide.$$x;
import static ru.sergeev.hw47.enums.CartPageEnum.CART_ITEMS;
import static ru.sergeev.hw47.enums.CartPageEnum.TITLE;

public class CartPage extends BasePage {
    private static final ElementsCollection CART_ITEM_LIST = $$x(CART_ITEMS.getVal());

    @Step("Проверка открытия страницы 'Your Cart'")
    public CartPage validatePage() {
        validatePageByText("Your Cart", TITLE.getVal());

        return this;
    }

    @Step("Сохраняем кол-во элементов в корзине")
    public int getCountOfCartItemList() {
        return CART_ITEM_LIST.size();
    }
}
