package QatestsMatif;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import browserUtil.Driver;

import java.util.concurrent.TimeUnit;

public class FloatingMenu {
    @BeforeMethod
    public void setUp() {

        Driver.get().get(browserUtil.ConfigReader.get("baseUrl") + "/floating_menu");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void floatingMenuTest(){
        WebElement homeButton = Driver.get().findElement(By.cssSelector("a[href=\"#home\"]"));
        homeButton.click();
        String expHomeButtonText = "Home";
        String actHomeButtonText = homeButton.getText();

        WebElement newsButton = Driver.get().findElement(By.cssSelector("a[href=\"#news\"]"));
        newsButton.click();
        String expNewsButtonText = "News";
        String actNewsButtonText = newsButton.getText();

        WebElement contactButton = Driver.get().findElement(By.cssSelector("a[href=\"#contact\"]"));
        contactButton.click();
        String expContactButtonText = "Contact";
        String actContactButtonText = contactButton.getText();

        WebElement aboutButton = Driver.get().findElement(By.cssSelector("a[href=\"#about\"]"));
        aboutButton.click();
        String expAboutButtonText = "About";
        String actAboutButtonText = aboutButton.getText();

        Assert.assertEquals(expHomeButtonText,actHomeButtonText);
        Assert.assertEquals(expNewsButtonText,actNewsButtonText);
        Assert.assertEquals(expContactButtonText,actContactButtonText);
        Assert.assertEquals(expAboutButtonText,actAboutButtonText);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    }
}
