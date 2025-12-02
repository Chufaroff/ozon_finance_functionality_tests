package ozon.project.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ozon.project.config.TestConfiguration;
import ozon.project.pages.WebSteps;
import ozon.project.utils.Attachment;

@Owner("Chufarov Bogdan")
@Feature("Тесты навигации")
@Story("Использование WebSteps")
public class WebStepsNavigationTests extends TestConfiguration {

    private WebSteps steps = new WebSteps();

    @Test
    @DisplayName("Двойной клик на кнопку next в карусели слайдов")
    @Tag("smoke")
    @Severity(SeverityLevel.NORMAL)
    void doubleClickOnControlsContainer() {
        steps.openMainPage();
        steps.doubleClickOnTheControlsContainer();
        Attachment.addVideo();
    }

    @Test
    @DisplayName("Наведение на вкладку 'Все продукты'")
    @Tag("smoke")
    @Severity(SeverityLevel.NORMAL)
    void hoverOverTabAllProducts() {
        steps.openMainPage();
        steps.hoverOverAllProductsTab();
        Attachment.pageSource();
    }

    @Test
    @DisplayName("Клик вкладки 'Кредитная карта'")
    @Tag("smoke")
    @Severity(SeverityLevel.NORMAL)
    void clickCreditCard() {
        steps.openMainPage();
        steps.hoverOverAllProductsTab();
        steps.clickCardInMenu("Кредитная карта");
        Attachment.screenshotAs("Кредитная карта");
    }

    @Test
    @DisplayName("Клик вкладки 'Рассрочка'")
    @Tag("smoke")
    @Severity(SeverityLevel.NORMAL)
    void clickInstalment() {
        steps.openMainPage();
        steps.hoverOverAllProductsTab();
        steps.clickInstallmentInMenu();
        steps.verifyTitleContains("Рассрочка");
        Attachment.addVideo();
    }

    @Test
    @DisplayName("Выбор тарифа во вкладке 'Для бизнеса'")
    @Tag("smoke")
    @Severity(SeverityLevel.NORMAL)
    void clickBusinessTariffs() {
        steps.openMainPage();
        steps.clickBusinessTab();
        steps.acceptCookieIfVisible();
        steps.hoverOverAllProductsTab();
        steps.clickTariffsInMenu("Тарифы");
        Attachment.screenshotAs("Тарифы");
        Attachment.pageSource();
        Attachment.browserConsoleLogs();
        Attachment.addVideo();
    }

    @Test
    @DisplayName("Информация о банке")
    @Tag("smoke")
    @Severity(SeverityLevel.MINOR)
    void bankInfo() {
        steps.openMainPage();
        steps.clickBankInfoLink();
        steps.verifyInfoBlockTitle("Ваш новый банк от группы Ozon");
    }

    @Test
    @DisplayName("Информация для клиентов")
    @Tag("smoke")
    @Severity(SeverityLevel.MINOR)
    void clientsInfo() {
        steps.openMainPage();
        steps.clickClientsInfoLink();
        steps.verifyInfoBlockTitle("Встречайте банк от группы Ozon");
    }

    @Test
    @DisplayName("Оформление карты гостю через WebSteps")
    @Tag("smoke")
    @Severity(SeverityLevel.CRITICAL)
    void getCardWithSteps() {
        steps.openMainPage();
        steps.clickGetCardButton();
        steps.verifyLoginFormIsVisible();
    }
}
