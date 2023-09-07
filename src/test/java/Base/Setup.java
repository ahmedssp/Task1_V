package Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import Pages.A_Home_Page;



public class Setup {
    protected WebDriver d;
    protected A_Home_Page homepage_obj;

    @BeforeMethod
    public void start()   {
        WebDriverManager.chromedriver().setup();
        d= new ChromeDriver();
        d.get("https://www.amazon.eg/?&tag=egtxabkgode-21&ref=pd_sl_7p2aq4fe2v_e&adgrpid=152488092398&hvpone=&hvptwo=&hvadid=666798652278&hvpos=&hvnetw=g&hvrand=16455860165181315221&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9112384&hvtargid=kwd-10573980&hydadcr=334_2589534&language=en_AE&gclid=Cj0KCQjwgNanBhDUARIsAAeIcAvBNzKuIl0lRBgUJ34sZ9ROwj3Qs5b7XKpHuUo8gtpgqbnGVxhRV7EaAlvCEALw_wcB");
        d.navigate().refresh();
        d.manage().window().setSize(new Dimension(1024,768));
        homepage_obj=new A_Home_Page(d);

    }
    @AfterMethod
    public void end(ITestResult result) throws InterruptedException {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = ((TakesScreenshot) d);
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot.toPath(), new File("resources/screenshots/" + result.getName() + ".png").toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         Thread.sleep(5000);
        d.quit();
    }
}
