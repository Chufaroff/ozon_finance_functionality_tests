package ozon.project.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestConfiguration {

    @BeforeAll
    static void beforeAll() {

        // Получаем параметры из системных свойств (Jenkins передает их как -D параметры)
        String remoteUrl = System.getProperty("remote.url", "https://user1:1234@selenoid.autotests.cloud/wd/hub"); // по умолчанию локальный запуск
        String baseUrl = System.getProperty("base.url", "https://finance.ozon.ru/");
        String browser = System.getProperty("browser", "chrome");
        String browserSize = System.getProperty("browser.size", "1920x1080");

        // Настройка Selenide
        Configuration.baseUrl = baseUrl; // базовый URL для всех тестов
        Configuration.browserSize = browserSize; // размер окна браузера
        Configuration.browser = browser; // тип браузера
        Configuration.timeout = 10000; // таймаут ожидания элементов (10 секунд)
        Configuration.pageLoadStrategy = "eager"; // стратегия загрузки страницы
        Configuration.holdBrowserOpen = false; // не оставлять браузер открытым после тестов

        // Настройка Allure для логирования шагов и скриншотов
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true) // делать скриншоты на каждом шаге
                .savePageSource(true) // сохранять исходный код страницы
                .includeSelenideSteps(true) // включать шаги Selenide в отчет
        );

        // Настройка удаленного браузера (если передан URL)
        if (remoteUrl != null && !remoteUrl.isEmpty()) {
            Configuration.remote = remoteUrl;

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true,
                    "enableLog", true,
                    "sessionTimeout", "5m"
            ));

            Configuration.browserCapabilities = capabilities;
        }
    }
}
