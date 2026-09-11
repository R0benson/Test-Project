package webshop.test;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import webshop.util.AttachManager;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;

public class TestBase {

    @BeforeAll
    static void setUP(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    void cleanUp() {
        clearBrowserCookies();
        clearBrowserLocalStorage();

        AttachManager.takeScreenshot();
        AttachManager.getPageSource();
        AttachManager.getBrowserConsoleLogs();
    }
}