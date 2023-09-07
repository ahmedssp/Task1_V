package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class D_ShoppingCart_Page {
    private WebDriver d;
    private String ProductTitle2;

    public String getProductPrice2() {
        return ProductPrice2;
    }

    public void setProductPrice2(String productPrice2) {
        ProductPrice2 = productPrice2;
    }

    private String ProductPrice2;

    public D_ShoppingCart_Page(WebDriver d) {
        this.d = d;
    }

    private By ProductTitle2_field = By.cssSelector("span[class=\"a-truncate-cut\"]");
    private By Product_total_price_filed = By.id("sc-subtotal-amount-buybox");
    private By Product_totalquantity_array_filed = By.cssSelector("span[class=\"a-dropdown-prompt\"]");//Subtotal (2 items)


    public void setProductTitle2(String getProductTitle2) {
        this.ProductTitle2 = getProductTitle2;
    }

    public String getProductTitle2() {
        return ProductTitle2;
    }


    public boolean Isquantity(int quantity) {
        if (d.findElements(Product_totalquantity_array_filed).size() == quantity) {
            return true;
        } else return false;
    }

    public String protuctTitle2() {

        setProductTitle2(d.findElement(ProductTitle2_field).getText().toLowerCase());
        return getProductTitle2();

    }

    public String protuctprice2() {

        setProductPrice2(d.findElement(Product_total_price_filed).getText().toLowerCase().replace(" ", ""));
        return getProductPrice2();

    }


}
