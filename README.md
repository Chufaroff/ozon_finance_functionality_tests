# 🏦 Ozon Finance Automation Testing Suite

![Java](https://img.shields.io/badge/Java-17-007396?logo=openjdk&logoColor=white)
![Selenide](https://img.shields.io/badge/Selenide-7.11.1-43B02A?logo=selenium&logoColor=white)
![Allure](https://img.shields.io/badge/Allure-2.19.0-EB4C42?logo=allure&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit-5.10.0-25A162?logo=junit5&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-7.4.1-02303A?logo=gradle&logoColor=white)
![Jenkins](https://img.shields.io/badge/Jenkins-CI/CD-D24939?logo=jenkins&logoColor=white)
![Telegram](https://img.shields.io/badge/Telegram-Notifications-26A5E4?logo=telegram&logoColor=white)
![Selenoid](https://img.shields.io/badge/Selenoid-Containers-4B32C3?logo=docker&logoColor=white)

<div align="center">
  
  **Профессиональный фреймворк автотестов для Ozon Bank**
  
  *Автоматизация тестирования финансового сервиса группы Ozon*

</div>

---

## 📋 О проекте

<div align="center">
  
  ![Ozon Finance Главная Страница](demo/mainpageozon.png)
  *Главная страница Ozon Finance - объект тестирования*

</div>

**Ozon Банк** — российский банк, входящий в группу «Ozon», который предлагает финансовые услуги как для физических, так и для юридических лиц. Банк фокусируется на онлайн-обслуживании и предоставляет:
- 💳 Дебетовые и кредитные карты
- 💰 Накопительные счета
- 🏦 Расчетные счета для бизнеса
- 🔄 Рассрочку и кредиты

Данный проект представляет собой **полнофункциональный фреймворк** для автоматизированного тестирования веб-приложения [finance.ozon.ru](https://finance.ozon.ru/). Реализует современные подходы к автоматизации тестирования с полным циклом CI/CD.

### 🎯 Ключевые возможности:
- ✅ **Полная автоматизация** основных пользовательских сценариев
- ✅ **3 архитектурных подхода** (Lambda, Page Object, Web Steps)
- ✅ **Профессиональные отчеты** Allure с визуализацией
- ✅ **Удаленный запуск** через Selenoid с записью видео
- ✅ **CI/CD пайплайн** в Jenkins
- ✅ **Автоматические уведомления** в Telegram
- ✅ **Параллельный запуск** тестов
- ✅ **Кросс-браузерное** тестирование

---

## :computer: Использованный стек технологий

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="logo/Java.svg">
<img width="6%" title="Selenide" src="logo/Selenide.svg">
<img width="6%" title="Selenoid" src="logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="logo/Gradle.svg">
<img width="6%" title="JUnit5" src="logo/JUnit5.svg">
<img width="6%" title="GitHub" src="logo/GitHub.svg">
<img width="6%" title="Jenkins" src="logo/Jenkins.svg">
<img width="6%" title="Telegram" src="logo/Telegram.svg">
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования Selenide.
- В качестве сборщика был использован - <code>Gradle</code>.
- Использованы фреймворки <code>JUnit 5</code> и [Selenide](https://selenide.org/).
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота.

---

## :arrow_forward: Запуск автотестов

### Запуск тестов из терминала

```
clean smoke_test 
-Dremote=https://user1:1234@selenoid.autotests.cloud/wd/hub 
-DbaseUrl=https://finance.ozon.ru/
-Dbrowser=chrome:100 
-DbrowserSize=1920x1080
```

### <img src="logo/param.svg" title="Параметры сборки" width="4%"/> Параметры сборки

* <code>REMOTE_DRIVER_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты.
* <code>BASE_URL</code> – Url, по которому будет открываться тестируемое приложение. По-умолчанию - <code>1920x1080</code>.
* <code>BROWSER</code> – браузер, в котором будут выполняться тесты. По-умолчанию - <code>chrome</code>.
* <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты.



## <img src="logo/Jenkins.svg" title="Jenkins" width="4%"/> Сборка в Jenkins
<p align="center">
<img title="Jenkins Build" src="demo/build_jenkins.png">
</p>

---

## <img src="logo/Allure_Report.svg" title="Allure Report" width="4%"/> Allure-отчет
### Overview

<div align="center">

| Обзор тестов | Детали теста | Статистика |
|--------------|--------------|-------------------|
| ![Allure Overview](demo/statistic.png) | ![Test Details](demo/stepstest.png) | ![Charts](demo/grafics.png) |
| *Общая статистика 24 тестов* | *Детализация шагов выполнения* | *Графики успешности и duration* |

</div>

---

## 📊 Демонстрация работы

### 🎥 Видеодемонстрация выполнения тестов

<div align="center">
  
  ![Видео выполнения теста](demo/13a10191340d47668d15f614c30c3f35.gif)
  
  *Демонстрация выполнения автотеста с навигацией по Ozon Finance*

  *Видео записывается автоматически при каждом запуске тестов в Selenoid*

</div>

---


### 📱 Telegram уведомления

<div align="center">
  
  [![Telegram Notification](https://img.shields.io/badge/📱_Посмотреть_уведомление_в_Telegram-26A5E4?style=for-the-badge&logo=telegram)](https://t.me/qa_auto_testing/12)
  
  *Пример уведомления о результатах тестирования в Telegram-канале*

</div>

---

## 🏗️ Архитектура проекта

```mermaid
graph TD
    C[Chrome 128]
    D[Ozon Finance]
    
    F[Test Code] --> E[Test Frameworks]
    E --> G[Lambda Tests]
    E --> H[Page Objects]
    E --> I[Web Steps]
    
    G --> J[Allure Reports]
    H --> J
    I --> J
    
    J --> K[Telegram Bot]
    J --> L[Archive Artifacts]
    
    K --> M[Telegram Channel]
    L --> N[Allure Dashboard]
    
    style C fill:#024939
    style D fill:#4832C3
    style E fill:#684642
    style F fill:#264564
    style G fill:#264564
```
