package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class C_AddToChart_page {
    private WebDriver d;
    private String producttitle1;
    private String producprice1;

    public String getProducprice1() {
        return producprice1;
    }

    public void setProducprice1(String producprice1) {
        this.producprice1 = producprice1;
    }

    public String getProducttitle1() {
        return producttitle1;
    }

    public void setProducttitle1(String producttitle1) {
        this.producttitle1 = producttitle1;
    }

    public C_AddToChart_page(WebDriver d) {
        this.d = d;
    }

    private By AddtoCartBottom_filed = By.id("add-to-cart-button");
    private By Product_name0_filed = By.id("productTitle");
    private By Product_price0_filed = By.xpath("//span[@class=\"a-price aok-align-center reinventPricePriceToPayMargin priceToPay\"]");

    private By Product_quantity0_filed = By.id("quantity");

    public void Click_AddtoCartBottom() {
        waitf().until(ExpectedConditions.visibilityOfElementLocated(AddtoCartBottom_filed));
        setProducttitle1(d.findElement(Product_name0_filed).getText());

        waitf().until(ExpectedConditions.visibilityOfElementLocated(Product_price0_filed));
        setProducprice1(d.findElement(Product_price0_filed).getText().replace("\n", ".").toLowerCase());

        d.findElement(AddtoCartBottom_filed).click();
    }

    public Wait waitf() {
        Wait wait = new FluentWait(d)
                .withTimeout(Duration.ofSeconds(12))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);
        return wait;
    }


}
