package ozon.project.pages;

import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу Ozon Finance")
    public void openMainPage() {
        open("https://finance.ozon.ru/");
    }

    @Step("Двойной клик в карусели слайдов на главной странице")
    public void doubleClickOnTheControlsContainer() {
        $("[data-testid='go-next-button']").doubleClick();
    }

    @Step("Наводим курсор на вкладку 'Все продукты'")
    public void hoverOverAllProductsTab() {
        $(".menu-item").hover();
    }

    @Step("Наводим на меню и кликаем на '{itemName}'")
    public void clickCardInMenu(String itemName) {
        $(".menu-item").hover();
        $(byText(itemName)).click();
    }

    @Step("Кликаем на ссылку 'Рассрочка' в меню")
    public void clickInstallmentInMenu() {
        $(".menu-item").hover();
        $("a[href='/promo/partpayment/landing?utm_source=main_page_menu']").click();
    }

    @Step("Кликаем на вкладку 'Для бизнеса'")
    public void clickBusinessTab() {
        $("#business").click();
    }

    @Step("Принимаем куки, если баннер отображается")
    public void acceptCookieIfVisible() {
        if ($(".cookie-banner").isDisplayed()) {
            $(".cookie-banner").shouldBe(visible, Duration.ofSeconds(5));
            $(byText("Хорошо")).click();
        }
    }

    @Step("Кликаем на '{tariffs}' в меню")
    public void clickTariffsInMenu(String tariffs) {
        $(byText(tariffs)).click();
    }

    @Step("Кликаем на ссылку 'Информация о банке'")
    public void clickBankInfoLink() {
        $("a[href='/docs']").click();
    }

    @Step("Кликаем на вкладку 'Клиентам'")
    public void clickClientsInfoLink() {
        $("a[href='/products']").click();
    }

    @Step("Кликаем на кнопку 'Получить карту'")
    public void clickGetCardButton() {
        $(".product-btns").click();
    }

    @Step("Проверяем, что отображается заголовок '{expectedText}'")
    public void verifyTitleContains(String expectedText) {
        $(byTagName("h1")).shouldHave(text(expectedText));
    }

    @Step("Проверяем, что отображается заголовок '{expectedText}' в блоке .infoBlock")
    public void verifyInfoBlockTitle(String expectedText) {
        $(".infoBlock h1").shouldHave(text(expectedText));
    }

    @Step("Проверяем, что отображается форма авторизации")
    public void verifyLoginFormIsVisible() {
        $(".form-container").shouldHave(text("Войдите в Ozon"));
    }

    @Step("Проверяем, что баннер с куки отображается")
    public void verifyCookieBannerVisible() {
        $(".cookie-banner").shouldBe(visible, Duration.ofSeconds(5));
    }
}
