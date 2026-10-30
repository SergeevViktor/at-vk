package ru.sergeev.hw47;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sergeev.hw47.acts.TestActs;
import ru.sergeev.hw47.pages.TestPage;

@Owner("sergeev.v.a")
//TODO: подумать какой сервис тестировать -> заполнить поля
@Epic("")
@Feature("")
public class TestConfig extends HwAbstractUiTest {
    @Autowired
    private TestActs testActs;

    //TODO: 3-5 простых теста
    @Story("")
    @DisplayName("")
    @Test
    public void test() {
        testActs.open(BASE_UI_URL, TestPage.class);
    }
}
