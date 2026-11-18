package ru.sergeev.hw47;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sergeev.coreui.pages.SauceDemoLoginPage;
import ru.sergeev.hw47.acts.SauceDemoActs;
import ru.sergeev.hw47.pageElements.ItemDescription;
import ru.sergeev.hw47.pages.CartPage;
import ru.sergeev.hw47.pages.ProductsPage;

import java.util.List;

import static ru.sergeev.coreui.acts.BaseActs.checkDifference;
import static ru.sergeev.coreui.acts.BaseActs.checkResult;
import static ru.sergeev.hw47.enums.SauceDemoEndpoints.INVENTORY;

@Owner("sergeev.v.a")
@Epic("UI")
@Feature("SauceDemo -> Products")
public class ProductsPageTests extends HwAbstractUiTest {
    @Autowired
    private SauceDemoActs sauceDemoActs;

    @Story("5")
    @DisplayName("Валидация имеющихся карточек товара и добавления в корзину")
    @Tag("products")
    @ParameterizedTest(name = ": ")
    @MethodSource("ru.sergeev.hw47.helper.DataProvider#providerValidateItemCard")
    public void validateItemCardAndAddToCart(Cookie cookie, List<String> expectedItemTitles, String attributeName) {
        sauceDemoActs.open(BASE_UI_URL, SauceDemoLoginPage.class)
                .addCookie(cookie);

        ProductsPage productsPage = sauceDemoActs
                .open(BASE_UI_URL + INVENTORY.getVal(), ProductsPage.class)
                .validatePage();

        List<ItemDescription> itemDescriptions = productsPage
                .initListItemDesc();

        Allure.step("Проверка кол-ва товаров", () ->
            checkResult(itemDescriptions.size(), expectedItemTitles.size()));

        List<String> itemTitles = productsPage
                .getTitleListByItems();

        Allure.step("Проверка корректности наименований товаров", () ->
            checkResult(itemTitles, expectedItemTitles));

        String attribute = productsPage.getAttribute(attributeName);
        itemDescriptions
                .get(0)
                .getAddToCartBtn()
                .clickOnElement();
        String attribute2 = productsPage.getAttribute(attributeName);

        Allure.step("Проверка, что у кнопки корзины поменялся аттрибут, отвечающий за наполнение корзины", () ->
            checkDifference(attribute, attribute2));

        int count = productsPage
                .toShoppingCart(CartPage.class)
                .validatePage()
                .getCountOfCartItemList();

        Allure.step("Проверка кол-ва товаров в корзине", () ->
            checkResult(count, 1));
    }
}
