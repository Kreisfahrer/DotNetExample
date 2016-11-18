package pages;

import core.PageBase;
import dto.Employer;
import org.openqa.selenium.By;
import popups.QuestionPopup;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static heplers.Locators.get;

public class EmployerInformationPage extends PageBase {
    public static final By COMPANY_NAME = get("EmployerInformation.companyName");
    public static final By ADDRESS = get("EmployerInformation.address");
    public static final By CITY = get("EmployerInformation.city");
    public static final By PRIMARY_ZIP = get("EmployerInformation.primaryZip");
    public static final By PHONE = get("EmployerInformation.phone");
    public static final By SIC_CODE_BUTTON = get("EmployerInformation.sicCodeButton");
    public static final By SIC_CODES = get("EmployerInformation.sicCodes");
    public static final By CLEAR_FORM = get("EmployerInformation.clearForm");
    public static final By CONTINUE = get("EmployerInformation.continue");
    public static final By VALIDATION = get("EmployerInformation.validation");

    public static void fillEmployerInformation(Employer employer) {
        $(COMPANY_NAME).val(employer.companyName);
        $(ADDRESS).val(employer.address);
        $(PRIMARY_ZIP).val(employer.zip);
        selectSic(employer.sic);
    }

    public static void selectSic(String sic) {
        $(SIC_CODE_BUTTON).click();
        $$(SIC_CODES).get(0).click();
    }

    public static void clearForm() {
        $(CLEAR_FORM).click();
        QuestionPopup.yes();
    }

    public static void clickContinue() {
        $(CONTINUE).click();
    }
}
