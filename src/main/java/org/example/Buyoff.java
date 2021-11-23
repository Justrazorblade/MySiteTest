package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Buyoff {
    public static void main(String[] args) {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe"
        );
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement sign = driver.findElement(By.linkText("Sign in"));
        sign.click();
        WebElement login = driver.findElement(By.id("email"));
        login.sendKeys("setow76287@gyn5.com");
        WebElement pass = driver.findElement(By.name("passwd"));
        pass.sendKeys("qwerty");
        WebElement bntSign = driver.findElement(By.xpath("//button[@id='SubmitLogin']"));
        bntSign.click();
        Actions action = new Actions(driver);
        WebElement ddmenu = driver.findElement(By.cssSelector("li > a[title=Women]"));
        action.moveToElement(ddmenu).build().perform();
        WebElement ddmenulink = driver.findElement(By.cssSelector("ul[style] > li > a[title=T-shirts]"));
        ddmenulink.click();
        JavascriptExecutor scroll = (JavascriptExecutor)driver;
        scroll.executeScript("window.scrollBy(0,250)", "");
        WebElement product = driver.findElement(By.cssSelector(".product-container"));
        action.moveToElement(product).build().perform();
        WebElement addBtn = driver.findElement(By.cssSelector("div.button-container > a.ajax_add_to_cart_button"));
        addBtn.click();
        WebElement checkOut = driver.findElement(By.xpath("//span[contains(text(), 'Proceed to checkout')]"));
        checkOut.click();

        //driver.quit();

    }
}
