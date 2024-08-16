import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// класс cтраницы редактирования профиля
public class ProfilePageMesto {

    private WebDriver driver;

    // локатор для поля «Занятие» в профиле пользователя
    private By activity = By.id("owner-description");

    // локатор для кнопки «Сохранить» в профиле пользователя
    private By save = By.xpath(".//button[@class='button popup__button' and text()='Сохранить']");

    public ProfilePageMesto(WebDriver driver) {
        this.driver = driver;
    }

   // метод для проверки открытости поля «Занятие», удаления текста из неё и ввода нового значения из параметра

    public void editActivity(String newActivity) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(activity));
        driver.findElement(activity).clear();
        driver.findElement(activity).sendKeys(newActivity);
    }

    // метод для нажатия на кнопку сохранения профиля
    public void saveClick() {
        driver.findElement(save).click();
    }


}
