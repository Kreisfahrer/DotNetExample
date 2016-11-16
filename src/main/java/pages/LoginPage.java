package pages;

import core.PageBase;
import org.openqa.selenium.By;

import static heplers.Locators.get;

public class LoginPage extends PageBase {
    public static final By USERNAME = get("LoginPage.username");
    public static final By PASSWORD = get("LoginPage.password");
    public static final By LOGIN = get("LoginPage.login");

    public static void login() {
    }
}
