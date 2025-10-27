import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class DemoTest {
    RemoteWebDriver driver;

    @BeforeMethod
    public void setup(Method method) throws MalformedURLException {
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "dev");
        capabilities.setCapability("platformName", "Windows 10");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("build", "Selenium-Sample-Assignment");
        ltOptions.put("name",method.getName() + " - " + "chrome" + " - " + "Windows 10");
        ltOptions.put("network", true);
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("console", true);
        ltOptions.put("tunnel", true);
        ltOptions.put("tunnelName", "azure-lambdatest-tunnel-Job");
        capabilities.setCapability("lt:options", ltOptions);

        driver = new RemoteWebDriver(
                new URL("https://devanshsingh:LT_kjmzzJCYu70kReE7lwE0w2MOXLWg2q72EMh68BOot6fYI1c@hub.lambdatest.com/wd/hub"), capabilities
        );
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://github.com/devanshsingh15");
        //driver.get("http://localhost/myapps/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.titleContains("devanshsingh15"));
        //WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='login-section']/button")));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}













