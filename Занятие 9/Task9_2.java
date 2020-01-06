import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task9_2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.booking.com/");
        int checkIn = 3;
        int checkOut = 7;
        int daysRelax = 7;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LocalDate checkInDate = LocalDate.now().plusDays(checkIn);
        LocalDate checkOutDate = checkInDate.plusDays(checkOut);
        driver.findElement(By.xpath(".//input[@type='search']")).sendKeys("Париж");
        driver.findElement(By.xpath(".//div[@data-mode='checkin']")).click();
        driver.findElement(By.xpath(".//td[@data-date='".concat(checkInDate.toString()).concat("']"))).click();
        driver.findElement(By.xpath(".//div[@data-mode='checkout']")).click();
        driver.findElement(By.xpath(".//div[@data-mode='checkout']")).click();
        driver.findElement(By.xpath(".//td[@data-date='".concat(checkOutDate.toString()).concat("']"))).click();
        driver.findElement(By.xpath(".//button[@data-sb-id='main']")).click();
        WebElement adults = driver.findElement(By.xpath(".//select[@name=\"group_adults\"]"));
        Select adultsSelect = new Select(adults);
        adultsSelect.selectByValue("4");
        WebElement rooms = driver.findElement(By.xpath(".//select[@name=\"no_rooms\"]"));
        Select roomsSelect = new Select(rooms);
        roomsSelect.selectByValue("2");
        driver.findElement(By.xpath(".//button[@data-sb-id=\"main\"]")).click();
        driver.findElement(By.xpath(".//a[@data-id=\"pri-5\"]")).click();
        driver.findElement(By.linkText("Цена (сначала самая низкая)")).click();
        Thread.sleep(5000);
        List<WebElement> availability = driver.findElements(By.xpath(".//a[@class=\"txp-cta bui-button" +
                " bui-button--primary sr_cta_button\"]"));
        WebElement element = availability.get(1);
        Actions choiceHotel = new Actions(driver);
        choiceHotel.moveToElement(element).click().perform();
        List<WebElement> finalPrice = driver.findElements(By.xpath(".//div[@class=\"bui-price-display" +
                "__value prco-inline-block-maker-helper\"]"));
        WebElement price = finalPrice.get(1);
        String cost = price.getText();
        String costHotel = cost.replace(" ", "");
        String finalCost = costHotel.substring(3, 7);
        double costDouble = Double.parseDouble(finalCost);
        String range = driver.findElement(By.xpath(".//a[@data-id=\"pri-5\"]")).getText();
        String lowerRange = range.substring(4, 7);
        double rangeDouble = Double.parseDouble(lowerRange);
        double finalRange = costDouble / daysRelax;
        if (finalRange > rangeDouble)
            System.out.println("цена не ниже заданного диапазона " + rangeDouble + " Бел.руб. за ночь");
        else System.out.println("цена ниже заданного диапазона " + rangeDouble + " Бел.руб. за ночь");
        driver.quit();
    }
}