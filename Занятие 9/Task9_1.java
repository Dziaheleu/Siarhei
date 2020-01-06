import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task9_1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.booking.com/");
        int checkIn = 3;
        int checkOut = 7;
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
        Thread.sleep(5000);
        WebElement lowPrice = driver.findElement(By.linkText("Цена (сначала самая низкая)"));
        Actions priceCost = new Actions(driver);
        priceCost.moveToElement(lowPrice).click().perform();
        System.out.println(driver.findElement(By.xpath(".//div[@class=\"sr_header  sr_header--reduced\"]")).getText());
        driver.findElement(By.xpath(".//a[@data-id=\"pri-1\"]")).click();

        WebElement ratingCost = driver.findElement(By.linkText("Оценка по отзывам и цена"));
        Actions evaluation = new Actions(driver);
        evaluation.moveToElement(ratingCost).click().perform();
        Thread.sleep(5000);
        List<WebElement> hotel = driver.findElements(By.xpath(".//a[@class=\"txp-cta " +
                "bui-button bui-button--primary sr_cta_button\"]"));
        WebElement element = hotel.get(0);
        Actions choiceHotel = new Actions(driver);
        choiceHotel.moveToElement(element).click().perform();
        List<WebElement> print = driver.findElements(By.xpath(" .//div[@class=\"prco-wrapper " +
                "bui-price-display prco-sr-default-assembly-wrapper prc-d-sr-wrapper\"]"));
        WebElement printText = print.get(0);
        String cost = printText.getText();
        String bestCost = cost.substring(23, 28);
        double ratingDouble = Double.parseDouble(bestCost);
        System.out.println("Лучшее предложение за 7 дней " + ratingDouble + " Бел.руб");
        driver.quit();
    }
}