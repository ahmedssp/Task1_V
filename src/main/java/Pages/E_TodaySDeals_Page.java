package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class E_TodaySDeals_Page {
    private WebDriver d;
    public E_TodaySDeals_Page(WebDriver d) {
        this.d = d;
    }
    private By grocery_Filed = By.cssSelector("input[data-csa-c-id=\"6hdmix-z3agur-87o357-helu13\"]");
    private By Firstproduct_filed = By.xpath("(//div[@class=\"DealCard-module__contentWithPadding_1mEcEYf1DvbvZJ9zcQCxtw\"]/a)[2]");
    private By Second_item_filed = By.xpath("(//ul[@class=\"a-unordered-list a-nostyle a-horizontal a-spacing-none\"]/li)[2]");


    public void ClickGrocery_box(){
        waitf().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-csa-c-element-id=\"filter-department-18020637031\"]")));
        d.findElement(By.xpath("//input[@data-csa-c-element-id=\"filter-department-18020637031\"]")).click();
    }
    public void ClickMobilePhoneandAcessorys_box(){
        waitf().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-csa-c-element-id=\"filter-department-21832868031\"]")));
        d.findElement(By.xpath("//input[@data-csa-c-element-id=\"filter-department-21832868031\"]")).click();
    }
    public void Click_Offer_box(){

        waitf().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li//div[@class=\"a-row\"]//ancestor::div)[22]")));
        d.findElement(By.xpath("(//li//div[@class=\"a-row\"]//ancestor::div)[22]")).click();
    }
    public void click_Firstproduct() {
        waitf().until(ExpectedConditions.visibilityOfElementLocated(Firstproduct_filed));
        d.findElement(Firstproduct_filed).click();
    }
    public C_AddToChart_page get_pageNo_4_ifexist() {
        try {
            for(int i=0;i<4;i++){
                waitf().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"a-text-center notranslate\"]//ancestor::li)[3]")));
                d.findElement(By.xpath("(//div[@class=\"a-text-center\"]/ul/li/a)[2]")).click();
            }

        } catch (Exception e) {
            System.out.println("this product have one item ");
            d.findElement(By.xpath("(//li[@class=\"a-list-normal a-spacing-none no-margin-right overflow-hidden octopus-response-li-width\"])[1]")).click();
        }
        return new  C_AddToChart_page(d);
    }

    public Wait waitf() {
        Wait wait = new FluentWait(d)
                .withTimeout(Duration.ofSeconds(12))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);
        return wait;
    }

}
