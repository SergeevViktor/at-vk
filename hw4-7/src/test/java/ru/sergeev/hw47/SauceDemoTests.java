package ru.sergeev.hw47;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sergeev.coreui.pages.SauceDemoLoginPage;
import ru.sergeev.hw47.acts.SauceDemoActs;
import ru.sergeev.hw47.pages.ProductsPage;
import ru.sergeev.hw47.pages.TestPage;

import java.util.List;

import static ru.sergeev.coreui.acts.BaseActs.checkResult;
import static ru.sergeev.coreui.enums.SauceDemoAccountEnum.PASSWORD;
import static ru.sergeev.coreui.enums.SauceDemoAccountEnum.STANDARD_USER;
import static ru.sergeev.hw47.enums.SauceDemoEndpoints.INVENTORY;

@Owner("sergeev.v.a")
@Epic("UI")
@Feature("SauceDemo")
public class SauceDemoTests extends HwAbstractUiTest {
    @Autowired
    private SauceDemoActs sauceDemoActs;

    @Disabled
    @Story("0")
    @DisplayName("Тест")
    @Test
    public void test() {
        sauceDemoActs.open(BASE_UI_URL, TestPage.class);
    }

    @Story("1")
    @DisplayName("Авторизация")
    @Tag("authorization")
    @Test
    public void successAuthorization() {
        sauceDemoActs.open(BASE_UI_URL, SauceDemoLoginPage.class)
                .validatePage()
                .login(STANDARD_USER.getVal(), PASSWORD.getVal(), ProductsPage.class)
                .validatePage();
    }

    @Story("2")
    @DisplayName("Авторизация")
    @Tag("authorization")
    @ParameterizedTest(name = ": негативный")
    @MethodSource("ru.sergeev.hw47.helper.DataProvider#providerAuthorizationNegative")
    public void authorizationNegative(String password, String expectedErrorMessage) {
        String errorMessage = sauceDemoActs
                .open(BASE_UI_URL, SauceDemoLoginPage.class)
                .validatePage()
                .login(STANDARD_USER.getVal(), password, SauceDemoLoginPage.class)
                .getLoginErrorMessage();

        Allure.step("Проверка, что сообщение в ошибке соответствует ожидаемой", () -> {
            checkResult(expectedErrorMessage, errorMessage);
        });
    }

    @Story("3")
    @DisplayName("Валидация бокового меню")
    @Tag("sidebar")
    @Timeout(5)
    @ParameterizedTest(name = ": ")
    @MethodSource("ru.sergeev.hw47.helper.DataProvider#providerValidateSidebarMenu")
    public void validateSidebarMenu(Cookie cookie, List<String> expectedSidebarElements) {
        sauceDemoActs.open(BASE_UI_URL, SauceDemoLoginPage.class)
                .addCookie(cookie);

        List<String> elements = sauceDemoActs
                .open(BASE_UI_URL + INVENTORY.getVal(), ProductsPage.class)
                .validatePage()
                .openSidebarMenu()
                .getTextElementsOfSidebarMenu();

        Allure.step("Проверка, что наименования элементов бокового меню соответсвуют ожидаемым", () -> {
            checkResult(expectedSidebarElements, elements);
        });
    }
}
