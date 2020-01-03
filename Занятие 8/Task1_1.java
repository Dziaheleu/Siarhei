import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Task1_1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.booking.com/");

        WebElement search = driver.findElement(By.xpath(".//input[@type=\"search\"]"));
        search.click();
        search.sendKeys("Москва");

        WebElement dates = driver.findElement(By.xpath(".//div[@class=\"xp__dates xp__group\"]"));
        dates.click();

        WebElement datesIn = driver.findElement(By.xpath(".//span[@aria-label=\"20 Декабрь 2019\"]"));
        datesIn.click();

        WebElement datesOut = driver.findElement(By.xpath(".//span[@aria-label=\"22 Декабрь 2019\"]"));
        datesOut.click();

        WebElement buttonSearch = driver.findElement(By.xpath(".//div[@class=\"xp__button\"]"));
        buttonSearch.click();

        WebElement adults = driver.findElement(By.xpath(".//select[@aria-label=\"Количество взрослых\"]"));
        Select adultsSelect = new Select(adults);
        adultsSelect.selectByValue("2");

        WebElement roomNum = driver.findElement(By.xpath(".//select[@id=\"no_rooms\"]"));
        Select roomNumSelect = new Select(roomNum);
        roomNumSelect.selectByValue("1");

        WebElement Search = driver.findElement(By.xpath(".//button[@data-sb-id=\"main\"]"));
        Search.click();

        System.out.println(driver.findElement(By.xpath(".//div[@data-block-id=\"heading\"]")).getText());
    }
}
