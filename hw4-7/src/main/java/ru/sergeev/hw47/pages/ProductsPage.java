package ru.sergeev.hw47.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Param;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.sergeev.coreui.pages.BasePage;
import ru.sergeev.hw47.pageElements.Button;
import ru.sergeev.hw47.pageElements.ItemDescription;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.model.Parameter.Mode.HIDDEN;
import static ru.sergeev.hw47.enums.ProductsPageEnum.*;

public class ProductsPage extends BasePage {
    private static final SelenideElement SIDEBAR_BTN = $(By.id(SIDEBAR_BUTTON.getVal()));
    private static final ElementsCollection SIDEBAR_LIST = $$x(SIDEBAR_ELEMENTS.getVal());
    //Решил тут использовать паттерн Page element
    private static final Button shoppingCartBtn = new Button($x(SHOPPING_CART_BUTTON.getVal()));
    private final List<ItemDescription> itemDescriptions = new ArrayList<>();

    @Step("Проверка открытия страницы 'Products'")
    public ProductsPage validatePage() {
        validatePageByText("Products", TITLE.getVal());

        return this;
    }

    @Step("Переходим в корзину")
    public <T extends BasePage> T toShoppingCart(@Param(mode = HIDDEN) Class<T> nextPage) {
        shoppingCartBtn.clickOnElement();

        return nextPage.cast(page(nextPage));
    }

    @Step("Открываем боковое меню")
    public ProductsPage openSidebarMenu() {
        SIDEBAR_BTN.shouldBe(visible).click();

        return this;
    }

    @Step("Сохраняем наименования вкладок бокового меню")
    public List<String> getTextElementsOfSidebarMenu() {
        List<String> result = new ArrayList<>();
        for (SelenideElement element : SIDEBAR_LIST) {
            result.add(element.shouldBe(visible).getText());
        }

        return result;
    }

    @Step("Инициализируем карточки товаров")
    public List<ItemDescription> initListItemDesc() {
        for (SelenideElement element : $$x(ITEM_DESCRIPTIONS.getVal())) {
            itemDescriptions.add(new ItemDescription(element));
        }

        return itemDescriptions;
    }

    @Step("Сохраняем наименования карточек товаров")
    public List<String> getTitleListByItems() {
        List<String> titles = new ArrayList<>();
        for (ItemDescription item : itemDescriptions) {
            titles.add(item.getTitle().getText());
        }

        return titles;
    }

    public String getAttribute(String attribute) {
        return shoppingCartBtn.getAttribute(attribute);
    }
}
