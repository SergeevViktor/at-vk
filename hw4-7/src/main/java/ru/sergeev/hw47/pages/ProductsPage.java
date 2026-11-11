package ru.sergeev.hw47.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.sergeev.coreui.pages.BasePage;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;
import static ru.sergeev.hw47.enums.ProductsPageEnum.*;

public class ProductsPage extends BasePage {
    private static final SelenideElement SIDEBAR_BTN = $(By.id(SIDEBAR_BUTTON.getVal()));
    private static final ElementsCollection SIDEBAR_LIST = $$x(SIDEBAR_ELEMENTS.getVal());

    @Step("Проверка открытия страницы 'Products'")
    public ProductsPage validatePage() {
        validatePageByText("Products", TITLE.getVal());

        return this;
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
}
