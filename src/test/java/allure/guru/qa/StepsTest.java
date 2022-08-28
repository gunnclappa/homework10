package allure.guru.qa;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepsTest extends BaseTest {

    @Test
    @DisplayName("Проверка Issue в репозитории")
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("Kayrat")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Testing", url = "https://testing.github.com")
    public void testAnnotatedStep() {
        WebSteps webSteps = new WebSteps();
        webSteps.openMainPage()
                .searchForRepository(REPOSITORY)
                .clickOnRepositoryLink(REPOSITORY)
                .openIssuesTab()
                .shouldSeeIssueWithNumber(ISSUE);
    }
}
