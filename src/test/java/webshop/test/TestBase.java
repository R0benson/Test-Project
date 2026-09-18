package webshop.test;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import webshop.util.AttachManager;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    void cleanUp() {
        clearBrowserCookies();
        localStorage().clear();

        AttachManager.takeScreenshot();
        AttachManager.getPageSource();
        AttachManager.getBrowserConsoleLogs();
    }
}