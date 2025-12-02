package ozon.project.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ozon.project.pages.MainPage;
import ozon.project.utils.Attachment;

public class PageObjectsNavigationTests {

    private MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Наведение на вкладку 'Все продукты'")
    @Tag("smoke")
    @Severity(SeverityLevel.NORMAL)
    void hoverOverTabAllProducts() {

        mainPage.openMainPage()
                .hoverOverAllProductsTab();

        Attachment.pageSource();
    }

    @Test
    @DisplayName("Клик вкладки 'Кредитная карта'")
    @Tag("smoke")
    @Severity(SeverityLevel.NORMAL)
    void clickCreditCard() {

        mainPage.openMainPage()
                .hoverOverAllProductsTab()
                .clickCreditCard();

        Attachment.screenshotAs("Кредитная карта");
    }

    @Test
    @DisplayName("Клик вкладки 'Рассрочка'")
    @Tag("smoke")
    @Severity(SeverityLevel.NORMAL)
    void clickInstalment() {

        mainPage.openMainPage()
                .hoverOverAllProductsTab()
                .clickInstallment()
                .verifyInstallmentTitle();

        Attachment.addVideo();
    }

    @Test
    @DisplayName("Выбор тарифа во вкладке 'Для бизнеса'")
    @Tag("smoke")
    @Severity(SeverityLevel.NORMAL)
    void clickBusinessTariffs() {

        mainPage.openMainPage()
                .clickBusinessTab()
                .acceptCookiesIfVisible()
                .hoverOverAllProductsTab()
                .clickTariffs();

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

        mainPage.openMainPage()
                .clickBankInfo()
                .verifyBankInfoTitle();
    }

    @Test
    @DisplayName("Информация для клиентов")
    @Tag("smoke")
    @Severity(SeverityLevel.MINOR)
    void clientsInfo() {

        mainPage.openMainPage()
                .clickClientsInfo()
                .verifyClientsInfoTitle();
    }

    @Test
    @DisplayName("Оформление карты гостю")
    @Tag("smoke")
    @Severity(SeverityLevel.CRITICAL)
    void getCardWithSteps() {

        mainPage.openMainPage()
                .clickGetCardButton()
                .verifyLoginForm();
    }
}
