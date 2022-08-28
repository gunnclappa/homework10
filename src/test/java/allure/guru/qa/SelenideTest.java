package allure.guru.qa;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends BaseTest {

    @Test
    @DisplayName("Проверка Issue в репозитории")
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("Kayrat")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Testing", url = "https://testing.github.com")
    public void testIssueSearch() {
        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();

        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("#" + ISSUE)).should(Condition.exist);
    }
}
