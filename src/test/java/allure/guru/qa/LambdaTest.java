package allure.guru.qa;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaTest extends BaseTest {

    @Test
    @DisplayName("Проверка Issue в репозитории")
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("Kayrat")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Testing", url = "https://testing.github.com")
    public void testLambdaStep() {
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем наличие Issue с номером " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }
}
