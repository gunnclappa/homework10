package allure.guru.qa;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public WebSteps openMainPage() {
        open("https://github.com/");
        return this;
    }

    @Step("Ищем репозиторий {repo}")
    public WebSteps searchForRepository(final String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
        return this;
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public WebSteps clickOnRepositoryLink(final String repo) {
        $(linkText(repo)).click();
        return this;
    }

    @Step("Открываем таб Issues")
    public WebSteps openIssuesTab() {
        $("#issues-tab").click();
        return this;
    }

    @Step("Проверяем наличие Issue с номером {issue}")
    public WebSteps shouldSeeIssueWithNumber(final int issue) {
        $(withText("#" + issue)).should(Condition.exist);
        return this;
    }
}
