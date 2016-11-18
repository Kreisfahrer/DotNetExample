import core.TestBase;
import dto.Employer;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EmployerInformationPage;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class EmployerInformationTest extends TestBase {
    private Employer employer;

    @BeforeClass
    public void setupClass() {
        employer = new Employer("test", "testAddress", "123456", "111 Wheat");
    }

    @Test
    public void fillEmployerInfoTest() {
        EmployerInformationPage.fillEmployerInformation(employer);
        EmployerInformationPage.clearForm();
        $(EmployerInformationPage.COMPANY_NAME).shouldBe(empty);
        $(EmployerInformationPage.ADDRESS).shouldBe(empty);
    }

    @Test
    public void failingTest() {
        EmployerInformationPage.fillEmployerInformation(employer);
        EmployerInformationPage.clickContinue();
        $(EmployerInformationPage.VALIDATION).shouldNotBe(visible);
    }
}
