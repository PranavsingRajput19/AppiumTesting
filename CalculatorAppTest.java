
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CalculatorAppTest {

    public static void main(String[] args) {
        try {     
        	 {
                 DesiredCapabilities capabilities = new DesiredCapabilities();
                 capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixcel 9 Pro XL API 34");
                 capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                
                 capabilities.setCapability("appPackage", "com.example.calculatorapp");
                 capabilities.setCapability("appActivity", ".MainActivity");

                 AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);

                 WebElement firstNumber = driver.findElement(By.id("com.example.calculatorapp:id/etFirstNumber"));
                 WebElement secondNumber = driver.findElement(By.id("com.example.calculatorapp:id/etSecondNumber"));
                 WebElement addButton = driver.findElement(By.id("com.example.calculatorapp:id/btnAdd"));
                 WebElement resultView = driver.findElement(By.id("com.example.calculatorapp:id/tvResult"));

                 firstNumber.sendKeys("1"); 
                 secondNumber.sendKeys("5");
                 addButton.click();

                 String resultText = resultView.getText();
                 if (resultText.contains("6")) {
                     System.out.println("Test Passed: Result is correct.");
                 } else {
                     System.out.println("Test Failed: Incorrect result.");
                 }

                 driver.quit();

        	 }
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}