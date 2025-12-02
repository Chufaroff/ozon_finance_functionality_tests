package ozon.project.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ozon.project.config.TestConfiguration;
import ozon.project.utils.Attachment;
import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Owner("Chufarov Bogdan")
@Severity(SeverityLevel.MINOR)
public class OzonClickTabsLambdaTests extends TestConfiguration {

    @Test
    @DisplayName("Открытие главной страницы и наведение курсора на выбранную вкладку")
    @Tag("smoke")
    void hoverOverTabAllProducts() {

        step("Открываем главную страницу Ozon Finance", () -> {
            open("https://finance.ozon.ru/");
        });

        step("Наводим курсор на вкладку 'Все продукты'", () -> {
            $(".menu-item").hover();
        });

        step("Получаем исходный HTML-код текущей открытой веб-страницы", () -> {
            Attachment.pageSource();
        });
    }

    @Test
    @DisplayName("Клик вкладки 'Кредитная карта'")
    @Tag("smoke")
    void hoverOverTabAllProductsAndClickOnTheCard() {
        step("Открываем главную страницу Ozon Finance", () -> {
            open("https://finance.ozon.ru/");
        });

        step("Наводим курсор на вкладку 'Все продукты'", () -> {
            $(".menu-item").hover();
        });

        step("Выбираем желаемый продукт", () -> {
            $(byText("Кредитная карта")).click();
        });

        step("Делаем скриншот текущей веб-страницы", () -> {
           Attachment.screenshotAs("Screenshot");
        });
    }

    @Test
    @DisplayName("Клик вкладки 'Рассрочка' и проверка появления нужного заголовка страницы")
    @Tag("smoke")
    void hoverOverTabAllProductsAndClickOnTheInstalmentSystem() {
        step("Открываем главную страницу Ozon Finance", () -> {
            open("https://finance.ozon.ru/");
        });

        step("Наводим курсор на вкладку 'Все продукты'", () -> {
            $(".menu-item").hover();
        });

        step("Выбираем желаемый продукт", () -> {
            $("a[href='/promo/partpayment/landing?utm_source=main_page_menu']").click();
        });

        step("Убеждаемся, что появился ожидаемый заголовок", () -> {
            $(byTagName("h1")).shouldHave(text("Рассрочка"));
        });

        step("Записываем видео процесса", () -> {
            Attachment.addVideo();
        });
    }

    @Test
    @DisplayName("Выбор тарифа во вкладке 'Для бизнеса'")
    @Tag("smoke")
    void clickOnTheTabForBusinessAndGoToTheTabTariffs() {
        step("Открываем главную страницу Ozon Finance", () -> {
            open("https://finance.ozon.ru/");
        });

        step("Кликаем вкладку 'Для бизнеса'", () -> {
            $("#business").click();
        });

        step("Подтверждаем cookie, при появлении баннера", () -> {
            $(".cookie-banner").shouldBe(visible, Duration.ofSeconds(5));
            $(byText("Хорошо")).click();
        });

        step("Наводим курсор на вкладку 'Все продукты'", () -> {
            $(".menu-item").hover();
        });

        step("В появившемся списке выбираем тарифы", () -> {
            $(byText("Тарифы")).click();
        });

        step("Используем все возможные Attachments", () -> {
           Attachment.screenshotAs("Screenshot");
           Attachment.pageSource();
           Attachment.browserConsoleLogs();
           Attachment.addVideo();
        });
    }

    @Test
    @DisplayName("Проверка вкладки с информацией о банке")
    @Tag("smoke")
    void clickInformationAboutTheBank() {

        step("Открываем главную страницу Ozon Finance", () -> {
            open("https://finance.ozon.ru/");
        });

        step("Кликаем вкладку с информацией о банке", () -> {
            $("a[href='/docs']").click();
        });

        step("Убеждаемся, что вкладка открылась и появился ожидаемый заголовок", () -> {
            $(".infoBlock h1").shouldHave(text("Ваш новый банк от группы Ozon"));
        });
    }

    @Test
    @DisplayName("Проверка вкладки с информацией для клиентов")
    @Tag("smoke")
    void clickOnTheTabClients() {

        step("Открываем главную страницу Ozon Finance", () -> {
            open("https://finance.ozon.ru/");
        });

        step("Кликаем вкладку с информацией для клиентов", () -> {
            $("a[href='/products']").click();
        });

        step("Убеждаемся, что вкладка открылась и появился ожидаемый заголовок", () -> {
            $(".infoBlock h1").shouldHave(text("Встречайте банк от группы Ozon"));
        });
    }

    @Test
    @DisplayName("Попытка оформить карту гостевому пользователю")
    @Tag("smoke")
    void clickOnTheButtonGetACard() {

        step("Открываем главную страницу Ozon Finance", () -> {
            open("https://finance.ozon.ru/");
        });

        step("Нажимаем на кнопку 'Оформить карту'", () -> {
            $(".product-btns").click();
        });

        step("Наблюдаем форму авторизации", () -> {
            $(".form-container").shouldHave(text("Войдите в Ozon"));
        });
    }
}
