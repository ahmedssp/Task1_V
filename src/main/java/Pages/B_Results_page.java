package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class B_Results_page {
    private WebDriver d;

    public B_Results_page(WebDriver d) {
        this.d = d;
    }

    private By firstItem1_Filed = By.xpath("(//div[@cel_widget_id=\"MAIN-SEARCH_RESULTS-3\" ]//a)[4]");

    public C_AddToChart_page Click_firest_item() {
        waitf().until(ExpectedConditions.visibilityOfElementLocated(firstItem1_Filed));
        d.findElement(firstItem1_Filed).click();
        return new C_AddToChart_page(d);
    }


    public Wait waitf() {
        Wait wait = new FluentWait(d)
                .withTimeout(Duration.ofSeconds(12))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);
        return wait;
    }
}
