package ru.sergeev.hw47;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import ru.sergeev.corecommon.config.EnvConfig;
import ru.sergeev.coreui.AbstractUiTest;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static ru.sergeev.corecommon.config.EnvConfig.WebDriverType.EDGE;
import static ru.sergeev.coreui.enums.BrowserSizeEnum.PC;

@Getter
@ContextConfiguration(classes = {
        HwUiConfiguration.class
})
public abstract class HwAbstractUiTest extends AbstractUiTest {
    @Autowired
    protected EnvConfig envConfig;
    protected String BASE_UI_URL;

    @PostConstruct
    public void init() {
        BASE_UI_URL = envConfig.getBaseUiUrl();
        setWebDriver(startWebDriver(EDGE, PC.getVal()));
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}
