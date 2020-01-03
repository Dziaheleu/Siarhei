import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Task1_2 {
    public static void main(String[] args) throws InterruptedException {
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

        WebElement sorting = driver.findElement(By.xpath(".//li[@id=\"sortbar_dropdown_container\"]"));
        sorting.click();

        WebElement sortingChoice = driver.findElement(By.xpath(".//li[@class=\" sort_category   sort_bayesian_review_score \"]"));
        sortingChoice.click();

        Thread.sleep(10000);
        List<WebElement> hotel = driver.findElements(By.xpath(".//a[@class=\"txp-cta bui-button bui-button--primary sr_cta_button\"]"));
        WebElement element = hotel.get(0);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();

        String rating = driver.findElement(By.xpath(".//a//div[@class=\"bui-review-score__badge\"]")).getText();
        double ratingDouble = Double.parseDouble(rating);
        if (ratingDouble >= 9) {
            System.out.println("Рейтинг отеля 9 или больше");
        }
        else
            System.out.println("Рейтинг отеля меньше 9");
    }
}

