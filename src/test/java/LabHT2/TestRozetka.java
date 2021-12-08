package LabHT2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestRozetka {
    WebDriver driver;

    @BeforeTest
    public void setupUrl() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/ua/");
    }
    @Test
    public void testByInRozetka () throws InterruptedException {
        WebElement webElement = driver.findElement(By.xpath("//a[@class='menu-categories__link'][contains(@href,'computers')]"));
        webElement.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='portal-section__heading']")));
        driver.findElement(By.xpath("//a[@class='tile-cats__picture'][contains(@href,'/notebooks/')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='catalog-settings']")));
        driver.findElement(By.xpath("//a[@class='checkbox-filter__link'][contains(@href,'hewlett-packard')]")).click();
        Select drpSortOrder = new Select(driver.findElement(By.xpath("//*[@class='catalog-settings__sorting']/*")));
        drpSortOrder.selectByValue("2: expensive");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='content content_type_catalog']")));

        driver.findElement(By.xpath("//*[@class='goods-tile__picture ng-star-inserted']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-about__sticky']")));
        driver.findElement(By.cssSelector(".buy-button.button.button_with_icon[type='button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'cart-footer')]")));
        driver.findElement(By.xpath("//a[contains(@class,'cart-footer')]")).click();
        driver.findElement(By.cssSelector(".breadcrumbs__item--home")).click();
        driver.findElement(By.xpath("//a[@class='menu-categories__link'][contains(@href,'computers')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='portal-section__heading']")));
        driver.findElement(By.xpath("//a[@class='tile-cats__picture'][contains(@href,'/monitors/')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='content content_type_catalog']")));
        driver.findElement(By.xpath("//a[@class='checkbox-filter__link'][contains(@href,'benq')]")).click();
        Select drpSortOrder1 = new Select(driver.findElement(By.xpath("//*[@class='catalog-settings__sorting']/*")));
        drpSortOrder1.selectByValue("3: popularity");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='content content_type_catalog']")));
        driver.findElement(By.xpath("//*[@class='goods-tile__picture ng-star-inserted']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-about__sticky']")));
        driver.findElement(By.xpath("//button[contains(@class,'buy-button button button_with')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal__header']")));
        driver.findElement(By.cssSelector(".modal__close")).click();
        driver.findElement(By.cssSelector(".breadcrumbs__item--home")).click();
        driver.findElement(By.xpath("//a[@class='menu-categories__link'][contains(@href,'/bt.')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class,'tile')]/a[contains(@href,'/refrigerators/')]")));
        driver.findElement(By.xpath("//li[contains(@class,'tile')]/a[contains(@href,'/refrigerators/')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='content content_type_catalog']")));
        driver.findElement(By.xpath("//a[@class='checkbox-filter__link'][contains(@href,'gorenje')]")).click();
        Select drpSortOrder2 = new Select(driver.findElement(By.xpath("//*[@class='catalog-settings__sorting']/*")));
        drpSortOrder2.selectByValue("2: expensive");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='goods-tile__picture ng-star-inserted']")));
        driver.findElement(By.xpath("//*[@class='goods-tile__picture ng-star-inserted']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-about__sticky']")));
        driver.findElement(By.xpath("//button[contains(@class,'buy-button button button_with')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cart-receipt__sum-price']")));
        System.out.println("checkpoint");
        String [] notUpdSum = driver.findElement(By.xpath("//div[@class='cart-receipt__sum-price']")).getText().split(" ");
        int sum = Integer.parseInt(notUpdSum[0]);
        System.out.println("Total amount "+sum);
        Assert.assertTrue(sum<500000);
    }
@AfterTest
public void closeBrowser(){
        driver.close();
}
}
