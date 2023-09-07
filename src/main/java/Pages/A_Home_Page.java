package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class A_Home_Page {
    private WebDriver d;

    public A_Home_Page(WebDriver d) {
        this.d = d;
    }

    public B_Results_page search_for(String keyword) {
        d.findElement(By.id("twotabsearchtextbox")).sendKeys(keyword);
        d.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
        return new B_Results_page(d);
    }

    public D_ShoppingCart_Page Click_ShoppingCartIcon() {
        d.findElement(By.id("nav-cart-count-container")).click();
        return new D_ShoppingCart_Page(d);
    }

    public B_Results_page Click_AllTap() {
        waitf().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id=\"nav-hamburger-menu\" ]//span[text()=\"All\"]")));
        d.findElement(By.xpath("//a[@id=\"nav-hamburger-menu\" ]//span[text()=\"All\"]")).click();
        return null;
    }

    public E_TodaySDeals_Page Click_Todays_Deals() throws InterruptedException {
        Thread.sleep(2000);
        waitf().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//*[text()=\"Today's Deals\"]")));
        d.findElement(By.xpath("//li//*[text()=\"Today's Deals\"]")).click();
        return new E_TodaySDeals_Page(d);
    }

    public Wait waitf() {
        Wait wait = new FluentWait(d)
                .withTimeout(Duration.ofSeconds(12))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);
        return wait;
    }

}
