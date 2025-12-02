package ozon.project.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

// Page Object класс для главной страницы Ozon Finance
public class MainPage {

    // Локаторы элементов страницы
    private SelenideElement
            menuItem = $(".menu-item"),
            creditCardLink = $(byText("Кредитная карта")),
            installmentLink = $("a[href='/promo/partpayment/landing?utm_source=main_page_menu']"),
            businessTab = $("#business"),
            cookieBanner = $(".cookie-banner"),
            cookieAcceptButton = $(byText("Хорошо")),
            tariffsLink = $(byText("Тарифы")),
            bankInfoLink = $("a[href='/docs']"),
            clientsTab = $("a[href='/products']"),
            getCardButton = $(".product-btns"),
            loginForm = $(".form-container"),
            carouselButton = $("[data-testid='go-next-button']");

    // Методы для работы с элементами
    @Step("Открываем главную страницу Ozon Finance")
    public MainPage openMainPage() {
        open("https://finance.ozon.ru/");
        return this;
    }

    @Step("Производим двойной клик в каруселе слайдов на главной странице")
    public MainPage doubleClickOnCarouselSlides() {
        carouselButton.doubleClick();
        return this;
    }

    @Step("Наводим курсор на вкладку 'Все продукты'")
    public MainPage hoverOverAllProductsTab() {
        menuItem.hover();
        return this;
    }

    @Step("Кликаем на 'Кредитная карта' в меню")
    public MainPage clickCreditCard() {
        creditCardLink.click();
        return this;
    }

    @Step("Кликаем на 'Рассрочка' в меню")
    public MainPage clickInstallment() {
        installmentLink.click();
        return this;
    }

    @Step("Кликаем на вкладку 'Для бизнеса'")
    public MainPage clickBusinessTab() {
        businessTab.click();
        return this;
    }

    @Step("Принимаем cookie, если баннер отображается")
    public MainPage acceptCookiesIfVisible() {
        if (cookieBanner.isDisplayed()) {
            cookieBanner.shouldBe(visible, Duration.ofSeconds(5));
            cookieAcceptButton.click();
        }
        return this;
    }

    @Step("Кликаем на 'Тарифы' в меню")
    public MainPage clickTariffs() {
        tariffsLink.click();
        return this;
    }

    @Step("Кликаем на ссылку 'Информация о банке'")
    public MainPage clickBankInfo() {
        bankInfoLink.click();
        return this;
    }

    @Step("Кликаем вкладку 'Клиентам'")
    public MainPage clickClientsInfo() {
        clientsTab.click();
        return this;
    }

    @Step("Кликаем на кнопку 'Получить карту'")
    public MainPage clickGetCardButton() {
        getCardButton.click();
        return this;
    }

    // Методы проверок (assertions)
    @Step("Проверяем, что отбражается заголовок 'Рассрочка'")
    public MainPage verifyInstallmentTitle() {
        $(byTagName("h1")).shouldHave(text("Рассрочка"));
        return this;
    }

    @Step("Проверяем, что отображается заголовок 'Ваш новый банк от группы Ozon'")
    public MainPage verifyBankInfoTitle() {
        $(".infoBlock h1").shouldHave(text("Ваш новый банк от группы Ozon"));
        return this;
    }

    @Step("Проверяем, что отображается заголовок 'Встречайте банк от группы Ozon'")
    public MainPage verifyClientsInfoTitle() {
        $(".infoBlock h1").shouldHave(text("Встречайте банк от группы Ozon"));
        return this;
    }

    @Step("Проверяем, что отображается форма авторизации 'Войдите в Ozon'")
    public MainPage verifyLoginForm() {
        loginForm.shouldHave(text("Войдите в Ozon"));
        return this;
    }

    @Step("Проверяем, что баннер с cookie отображается")
    public MainPage verifyCookiesBannerVisible() {
        cookieBanner.shouldBe(visible, Duration.ofSeconds(5));
        return this;
    }
}
