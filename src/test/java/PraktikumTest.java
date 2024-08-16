import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.is;

// Класс с автотестом
public class PraktikumTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Указали путь до драйвера
        System.setProperty("webdriver.chrome.driver", "D:/WebDriver/bin/chromedriver-win64/chromedriver.exe");
        // создали драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        // Если раскоментить опции, то тест не будет запускать UI
        // options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // перешли на страницу тестового приложения
        driver.get("https://qa-mesto.praktikum-services.ru/");
    }

    @Test
    public void checkEmailInHeader() {
        // создали объект класса страницы авторизации
        LoginPageMesto objLoginPage = new LoginPageMesto(driver);
        // выполнили авторизацию
        String email = "Hechavarria_38@gmail.com";
        String password = "123456";
        objLoginPage.login(email, password);
        // создали объект класса заголовка приложения
        HeaderPageMesto objHeaderPage = new HeaderPageMesto(driver);
        // дождались загрузки заголовка
        objHeaderPage.waitForLoadHeader();
        // сделали проверку, что полученное значение совпадает с email
        MatcherAssert.assertThat(email, is(objHeaderPage.getTextHeaderUser()));

    }

    @Test
    public void checkActivity() {
        // объект класса страницы авторизации
        LoginPageMesto objLoginPage = new LoginPageMesto(driver);
        // выполнили авторизацию
        String email = "Hechavarria_38@gmail.com";
        String password = "123456";
        objLoginPage.login(email, password);
        // объект класса главной страницы приложения
        HomePageMesto objHomePage = new HomePageMesto(driver);
        // дождись загрузки данных профиля на главной странице
        objHomePage.waitForLoadProfileData();
        // кликни на кнопку редактирования профиля
        objHomePage.clickEditProfileButton();
        // объект класса для поп-апа редактирования профиля
        ProfilePageMesto objProfilePage = new ProfilePageMesto(driver);
        // переменная со значением, которое надо ввести в поле «Занятие»
        String newActivity = "Тестировщик";
        // в одном шаге проверь, что поле «Занятие» доступно для редактирования, и введи в него новое значение
        objProfilePage.editActivity(newActivity);
        // сохрани изменения в профиле
        objProfilePage.saveClick();
        // проверь, что поле «Занятие» на основной странице поменяло значение на новое
        objHomePage.waitForChangedActivity(newActivity);
    }

    @After
    public void tearDown() {
        // Закрываем браузер
        driver.quit();
    }
}
