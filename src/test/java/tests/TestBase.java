package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.PracticeFormPage;

import static helpers.Attachments.*;

public class TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    public static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    TestData testData = new TestData();

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = System.getProperty("browser");
        Configuration.browserVersion = System.getProperty("version");
        Configuration.browserSize = System.getProperty("browserSize");
        String remoteDriverUrl = System.getProperty("remoteDriverUrl");
        Configuration.remote = String.format("https://%s:%s@%s", config.login(), config.password(), remoteDriverUrl);
    }

    @AfterEach
    void addAttach() {
        screenshotAs("Last screenshot");
        pageSource();
        browserConsoleLogs();
        addVideo();
    }
}

