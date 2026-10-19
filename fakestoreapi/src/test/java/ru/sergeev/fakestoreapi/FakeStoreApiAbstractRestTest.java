package ru.sergeev.fakestoreapi;

import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import ru.sergeev.corecommon.config.EnvConfig;
import ru.sergeev.corerest.AbstractRestTest;

import static ru.sergeev.fakestoreapi.specification.Specification.specDelete;

@Getter
@Epic("API > FakeStoreAPi")
@Link(name = "ссылка на FakeStoreAPI",
        url = "https://fakestoreapi.com/docs"
)
@ContextConfiguration(classes = {
        FakeStoreApiConfiguration.class
})
public abstract class FakeStoreApiAbstractRestTest extends AbstractRestTest {
    @Autowired
    private EnvConfig env;
    protected String BASE_END_POINT;

    @PostConstruct
    private void init() {
        BASE_END_POINT = env.getBaseUrl();
    }

    @AfterEach
    void after() {
        specDelete();
    }
}
