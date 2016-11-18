package popups;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static heplers.Locators.get;

public class QuestionPopup {
    public static final By YES = get("QuestionPopup.yes");
    public static final By NO = get("QuestionPopup.no");

    public static void yes() {
        $(YES).click();
    }
}
