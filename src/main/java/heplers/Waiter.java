package heplers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static com.codeborne.selenide.Selenide.Wait;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class Waiter {
    public static void waitForJquery() {
        Wait().until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) executeJavaScript("return jQuery.active == 0");
            }
        });
    }

    public static void waitForPageToLoad() {
        Wait().until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return executeJavaScript("return document.readyState").equals("complete");
            }
        });
    }
}
