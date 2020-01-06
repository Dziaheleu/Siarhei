import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task9_3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.booking.com/");
        int checkIn = 3;
        int checkOut = 7;
        String cardNumber = "4242 4242 4242 424";
        String cvcCode = "258";

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

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        Thread.sleep(5000);
        WebElement order = driver.findElement(By.xpath("(.//a[contains(@class, 'b-button b-button_primary')])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(order).click().perform();

        Thread.sleep(5000);
        WebElement IOrder = driver.findElement(By.xpath(".//div[@class=\"hprt-reservation-cta\"]"));
        Actions clickOrder = new Actions(driver);
        clickOrder.moveToElement(IOrder).doubleClick().perform();

        driver.findElement(By.xpath(".//span[@class=\"modal-mask-closeBtn bp_rlu_footer_close\"]")).click();
        driver.findElement(By.xpath(".//input[@name=\"lastname\"]")).sendKeys("Ivanov");
        driver.findElement(By.xpath(".//input[@id=\"email\"]")).sendKeys("gmail@mail.com");
        driver.findElement(By.xpath(".//input[@id=\"email_confirm\"]")).sendKeys("gmail@mail.com");

        WebElement button = driver.findElement(By.xpath(".//i[@class=\"submit-button__arrow\"]"));
        Actions buttonAction = new Actions(driver);
        buttonAction.moveToElement(button).click().perform();

        driver.findElement(By.xpath(".//span[@class=\"modal-mask-closeBtn bp_rlu_footer_close\"]")).click();
        driver.findElement(By.xpath(".//input[@id=\"phone\"]")).sendKeys("297788990");

        WebElement typeCard = driver.findElement(By.xpath(".//select[@id=\"cc_type\"]"));
        Select cardVisa = new Select(typeCard);
        cardVisa.selectByValue("Visa");

        driver.findElement(By.xpath(".//input[@name=\"cc_number\"]")).sendKeys(cardNumber);
        driver.findElement(By.xpath(".//input[@name=\"cc_cvc\"]")).sendKeys(cvcCode);

        List<WebElement> dataValidation = driver.findElements(By.xpath(".//ins[@class=\"submit_holder_button_text_wrap\"]"));
        WebElement dataVal = dataValidation.get(1);
        Actions moveVal = new Actions(driver);
        moveVal.moveToElement(dataVal).click().perform();

        System.out.println(driver.findElement(By.xpath(".//span[@class=\"bui-alert__title\"]")).getText());
        System.out.println(driver.findElement(By.xpath(".//a[@href=\"#cc_number\"]")).getText());
        driver.quit();
    }
}