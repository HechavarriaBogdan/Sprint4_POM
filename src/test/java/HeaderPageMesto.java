import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Класс заголовка
public class HeaderPageMesto {
    private WebDriver driver;
    // создали локатор для элемента c email в заголовке страницы
    private By headerUser = By.className("header__user");

    public HeaderPageMesto(WebDriver driver) {
        this.driver = driver;
    }

    // метод ожидания загрузки страницы
    public void waitForLoadHeader(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("header__user")));
    }

    // метод для получения текста элемента в заголовке
    public String getTextHeaderUser(){
        return driver.findElement(headerUser).getText();
    }
}
