package org.example.lesson_3.homeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test_5_SelectLanguageInLanguageList {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();//установка актуальной версии браузера с помощью WebDriverManager
        // задаем параметры работы для браузера ( пока закомментим, чтобы можно было просмотреть, как отработает тест)
//       ChromeOptions chromeOptions = new ChromeOptions();// с помощью конструктора создаем экземпляр класса ChromeOptions
//        chromeOptions.addArguments("--headless");// добавляем аргумент headless-работа без рафического интерфейса
//        chromeOptions.addArguments("--disable-notifications");// добавляем аргумент disable-notifications - работа без всплывающих уведомлений
        //WebDriver webDriver = new ChromeDriver(chromeOptions);//передавая в конструктор экземпляр chromeOptions создаем экземпляр класса драйвера
        WebDriver webDriver = new ChromeDriver();//с помощью конструктора создаем экземпляр класса
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));//настраиваем браузер на ожидание с лимитом в 3 секнды
        //переходим на страницу
        webDriver.get("https://translate.yandex.ru/?lang=ru-en&text=%D0%B4%D0%B5%D0%BB%D0%B0%D1%82%D1%8C%20%D0%B4%D0%BE%D0%BC%D0%B0%D1%88%D0%BD%D0%B5%D0%B5%20%D0%B7%D0%B0%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5");
        webDriver.findElement(By.id("srcLangButton")).click();// находим элемент по локатору(id), кликаем
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));//с помощью конструктора создаем экземпляр класса WebdriverWait
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"langs-column langs-column_count_5\"]//div[text()=\"Английский\"]")));//с помощью webDriverWait дожидаемся появления элемента( задаем локатор-xpath)
        webDriver.findElement(By.xpath("//div[@class=\"langs-column langs-column_count_5\"]//div[text()=\"Английский\"]")).click();//находим элемент по локатору(xpath), кликаем
        Thread.sleep(5000);//безусловное ожидание для удобства наблюдение за прохождение теста( в идеале не нужно)
        webDriver.quit();// закрываем окно браузера

    }

}
