import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task10 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
        String login = "Dziaheleu";
        String password = "qazplokijuh";
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement boxLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[@id=" +
                "\"mailbox:login\"]")));
        boxLogin.click();
        boxLogin.sendKeys(login);
        boxLogin.submit();

        WebElement boxPassword = wait.until((ExpectedConditions.elementToBeClickable(By.xpath(".//input[@id=" +
                "\"mailbox:password\"]"))));
        boxPassword.sendKeys(password);
        boxPassword.submit();

        WebElement click = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//div[@class=" +
                "\"ll-av__container\"])[1]")));
        Actions clickBox = new Actions(driver);
        clickBox.moveToElement(click).click().perform();

        driver.findElement(By.xpath("(.//span[@class=\"button2__txt\"])[5]")).click();
        driver.findElement(By.xpath(".//a[@href=\"/spam/\"]")).click();

        Thread.sleep(5000);
        WebElement click2 = driver.findElement(By.xpath(".//span[@class=\"button2__explanation\"]"));
        Actions clickBoxSpam = new Actions(driver);
        clickBoxSpam.moveToElement(click2).click().perform();

        WebElement page = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//span[@class=" +
                "\"button2__txt\"])[4]")));
        Actions actionsPage = new Actions(driver);
        actionsPage.moveToElement(page).click().perform();

        WebElement inBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@title=\"Входящие\"]")));
        Actions actionsInBox = new Actions(driver);
        actionsInBox.moveToElement(inBox).click().perform();

        driver.findElement(By.xpath(".//span[@title=\"Написать письмо\"]")).click();

        WebElement who = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//div[@class=" +
                "\"text--1czzf\"])[1]")));
        Actions actionsWho = new Actions(driver);
        actionsWho.moveToElement(who).click().perform();

        WebElement clickFirstMan = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@title=" +
                "\"send\"]")));
        Actions actionsClickFirst = new Actions(driver);
        actionsClickFirst.moveToElement(clickFirstMan).click().perform();

        WebElement clickSecondMan = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//" +
                "div[@title=\"sind\"]")));
        Actions actionsClickSecond = new Actions(driver);
        actionsClickSecond.moveToElement(clickSecondMan).click().perform();

        WebElement buttonAdd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[@class=\"button2 " +
                "button2_base button2_primary button2_hover-support\"]")));
        Actions actionsButtonAdd = new Actions(driver);
        actionsButtonAdd.moveToElement(buttonAdd).click().perform();

        WebElement messageSend = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//" +
                "span[@class=\"button2 button2_base button2_primary button2_hover-support js-shortcut\"]")));
        Actions actionsMessageSend = new Actions(driver);
        actionsMessageSend.moveToElement(messageSend).click().perform();

        WebElement messageSendElse = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[@class=\"" +
                "c3178 c3153 c3176 c3151\"]")));
        Actions actionsMessageSendElse = new Actions(driver);
        actionsMessageSendElse.moveToElement(messageSendElse).click().perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[@class=\"button2 b" +
            "utton2_has-ico button2_close button2_pure button2_clean button2_short button2_hover-support\"]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//a[@href=\"/inbox/\"]"))).click();

        WebElement clickFlag = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//div[@class=" +
                "\"llc__item llc__item_flag\" and button[@title=\"Пометить флажком\"]])[1]")));
        Actions actionsClickFlag = new Actions(driver);
        actionsClickFlag.moveToElement(clickFlag).click().perform();

        WebElement clickFlagSecond = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//div[@class=" +
                "\"llc__item llc__item_flag\" and button[@title=\"Пометить флажком\"]])[2]")));
        Actions actionsClickFlagSecond = new Actions(driver);
        actionsClickFlag.moveToElement(clickFlagSecond).click().perform();

        WebElement clickFlagThird = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//div[@class=" +
                "\"llc__item llc__item_flag\" and button[@title=\"Пометить флажком\"]])[3]")));
        Actions actionsClickFlagThird = new Actions(driver);
        actionsClickFlag.moveToElement(clickFlagThird).click().perform();

        WebElement removeClickFlag = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//" +
                "div[@class=\"llc__item llc__item_flag\" and button[@title=\"Пометить флажком\"]])[1]")));
        Actions actionsRemoveClickFlag = new Actions(driver);
        actionsClickFlag.moveToElement(removeClickFlag).click().perform();

        WebElement removeClickFlagSecond = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//" +
                "div[@class=\"llc__item llc__item_flag\" and button[@title=\"Пометить флажком\"]])[2]")));
        Actions actionsRemoveClickFlagSecond = new Actions(driver);
        actionsClickFlag.moveToElement(removeClickFlagSecond).click().perform();

        WebElement removeClickFlagThird = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//div" +
                "[@class=\"llc__item llc__item_flag\" and button[@title=\"Пометить флажком\"]])[3]")));
        Actions actionsRemoveClickFlagThird = new Actions(driver);
        actionsClickFlag.moveToElement(removeClickFlagThird).click().perform();
        driver.quit();
    }
}