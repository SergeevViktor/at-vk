package ru.sergeev.corerest;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import ru.sergeev.corecommon.BaseContextConfiguration;
import ru.sergeev.corecommon.BaseTest;

@SpringBootTest
@ContextConfiguration(classes = {
        BaseContextConfiguration.class,
        RestBaseConfiguration.class
})
public abstract class AbstractRestTest extends BaseTest {
}
