package ru.sergeev.coreui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Param;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.sergeev.coreui.enums.SauceDemoLoginPageEnum;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static io.qameta.allure.model.Parameter.Mode.HIDDEN;
import static ru.sergeev.coreui.enums.SauceDemoLoginPageEnum.*;

public class SauceDemoLoginPage extends BasePage {
    private static final SelenideElement USER_FLD = $(By.id(SauceDemoLoginPageEnum.USER_FIELD.getVal()));
    private static final SelenideElement PASSWORD_FLD = $(By.id(PASSWORD_FIELD.getVal()));
    private static final SelenideElement LOGIN_BTN= $(By.id(LOGIN_BUTTON.getVal()));
    private static final SelenideElement ERROR_MSG = $x(ERROR_MESSAGE.getVal());

    @Step("Проверка открытия страницы 'Swag Labs'")
    public SauceDemoLoginPage validatePage() {
        validatePageByText("Products", LOGIN_LOGO.getVal());

        return this;
    }

    @Step("Авторизация")
    public <T extends BasePage> T login(String user, String password,
                                        @Param(mode = HIDDEN) Class<T> nextPage) {
        Allure.step("Вводим логин: " + user + " и пароль: " + password, () -> {
            USER_FLD.setValue(user);
            PASSWORD_FLD.setValue(password);
        });
        Allure.step("Нажимаем на кнопку 'Login", () -> {
            LOGIN_BTN.shouldBe(visible).click();
        });

        return nextPage.cast(page(nextPage));
    }

    @Step("Сохраняем текст ошибки авторизации")
    public String getLoginErrorMessage() {
        return ERROR_MSG.shouldBe(visible).getText();
    }
}
