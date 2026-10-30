package ru.sergeev.coreui;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import ru.sergeev.corecommon.BaseContextConfiguration;
import ru.sergeev.corecommon.BaseTest;
import ru.sergeev.corecommon.config.EnvConfig;
import ru.sergeev.corecommon.exceptions.ConfigException;

import java.util.Collections;
import java.util.List;

import static ru.sergeev.coreui.enums.BrowserSizeEnum.PC;


@SpringBootTest
@ContextConfiguration(classes = {
        BaseContextConfiguration.class,
        UiBaseConfiguration.class
})
public abstract class AbstractUiTest extends BaseTest {

    @Autowired
    private EnvConfig envConfig;

    protected WebDriver startWebDriver(EnvConfig.WebDriverType defaultType, String windowSize) {
        EnvConfig.WebDriverType webDriverType = envConfig.getWebDriverType();

        if (webDriverType == null) {
            envConfig.setWebDriverType(defaultType);
            webDriverType = defaultType;
        }
        return switch (webDriverType) {
            case EDGE -> init("edge", windowSize);
            case CHROME -> init("chrome", windowSize);
        };
    }

    private WebDriver init(String browser, String size) {
        Configuration.timeout = 5000;
        Configuration.browser = browser;
        Configuration.browserVersion = "latest";
        Configuration.browserSize = PC.getVal();

        List<String> experimentalOptions = List.of("excludeSwitches", "enable-automation");

        return switch (browser) {
            case "edge" -> new EdgeDriver(getEdgeOptions(size)
                    .setExperimentalOption(
                            experimentalOptions.get(0), Collections.singletonList(experimentalOptions.get(1))));
            case "chrome" -> new ChromeDriver(getChromeOptions(size)
                    .setExperimentalOption(
                            experimentalOptions.get(0), Collections.singletonList(experimentalOptions.get(1))));
            default -> throw new ConfigException("В окружении не указан поддерживаемый тип драйвера!");
        };
    }

    private ChromeOptions getChromeOptions(String size) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(generalOptions(size));

        return chromeOptions;
    }

    private EdgeOptions getEdgeOptions(String size) {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments(generalOptions(size));
        edgeOptions.addArguments("--disable-features=msEdgeEnableNurturingFramework");

        return edgeOptions;
    }

    private List<String> generalOptions(String size) {
        return List.of(
                "--disable-blink-features=AutomationControlled",
                "--disable-dev-shm-usage",
                "--no-sandbox",
                "--ignore-certificate-errors",
                "--incognito",
                "--no-default-browser-check",
                "--window-size=" + size
        );
    }
}
