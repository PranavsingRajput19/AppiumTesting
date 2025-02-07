
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.URL;

public class AppiumTesting {

    public static void main(String[] args) {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Pixcel 9 Pro XL API 34");
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

            AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);

            driver.get("https://www.apple.com/in");

            Thread.sleep(2000);

            WebElement learnMoreButton = driver.findElement(By.xpath("//a[contains(text(), 'Learn More')]"));

            learnMoreButton.click();

            Thread.sleep(2000);

            String currentUrl = driver.getCurrentUrl();
            if(currentUrl.equals("https://www.apple.com/in/iphone-16/")) {
                System.out.println("Successfully navigated to: " + currentUrl);
            } else {
                System.out.println("URL did not change correctly.");
            }
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
