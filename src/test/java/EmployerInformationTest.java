import core.TestBase;
import dto.Employer;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EmployerInformation;
import popups.QuestionPopup;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Selenide.$;

public class EmployerInformationTest extends TestBase {
    private Employer employer;

    @BeforeClass
    public void setupClass() {
        employer = new Employer("test", "testAddress", "12345", "111 Wheat");
    }

    @Test
    public void fillEmployerInfoTest() {
        EmployerInformation.fillEmployerInformation(employer);
        $(EmployerInformation.CLEAR_FORM).click();
        $(QuestionPopup.YES).click();
        Arrays.asList(
                EmployerInformation.COMPANY_NAME,
                EmployerInformation.ADDRESS
        ).forEach(element -> $(element).shouldBe(empty));
    }
}
