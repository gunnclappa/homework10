package allure.guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    static final String REPOSITORY = "selenide/selenide";
    static final int ISSUE = 1927;

    @BeforeAll
    public static void setup() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
