package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import heplers.ScreenshotListener;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners({ScreenshotListener.class})
public class TestBase {
    protected static final String BASE_URL = "http://minsk-dev-ihcgg:8090/#/quote/new";
    protected Properties env = new Properties();

    @BeforeTest
    public void configure() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.baseUrl = System.getProperty("baseUrl", BASE_URL);
        env.setProperty("Url", Configuration.baseUrl);
    }

    @BeforeMethod
    public void setup() {
        open(BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        if (env.getProperty("Browser") == null) {
            RemoteWebDriver remote = (RemoteWebDriver) getWebDriver();
            env.setProperty("Browser", remote.getCapabilities().getBrowserName());
            env.setProperty("Browser Version", remote.getCapabilities().getVersion());
            env.setProperty("Platform", remote.getCapabilities().getPlatform().name());
            env.setProperty("Platform version", remote.getCapabilities().getPlatform().getMajorVersion() + "." +
                    remote.getCapabilities().getPlatform().getMinorVersion());
        }
        Selenide.close();
    }

    @AfterTest(alwaysRun = true)
    public void saveEnvironment() {
        File file = Paths.get(System.getProperty("user.dir"), "/target/allure-results").toAbsolutePath().toFile();
        if (!file.exists()) {
            System.out.println("Created dirs: " + file.mkdirs());
        }
        try (FileWriter out = new FileWriter("./target/allure-results/environment.properties")) {
            env.store(out, "Environment variables for report");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
