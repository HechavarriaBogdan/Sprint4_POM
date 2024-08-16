import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// класс главной страницы
public class HomePageMesto {
    private WebDriver driver;

    private By profileTitle = By.className("profile__title");
    // локатор для кнопки редактирования профиля
    private By editProfileButton = By.className("profile__edit-button");
    // локатор для поля "Занятие" в профиле пользователя
    private  By activity = By.className("profile__description");

    public HomePageMesto(WebDriver driver) {
        this.driver = driver;
    }

    // метод ожидания прогрузки данных профиля
    public void waitForLoadProfileData() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(profileTitle).getText() != null
                && !driver.findElement(profileTitle).getText().isEmpty()
        ));
    }

    // метод для нажатия на кнопку редактирования профиля
    public void clickEditProfileButton() {
        driver.findElement(editProfileButton).click();
    }

    // нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра

    public void waitForChangedActivity(String changed) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElementLocated(activity, changed));
    }
}
