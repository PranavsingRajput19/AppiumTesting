import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Vehicle {
    public static void main(String[] args) {
        try {
     
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 9 Pro XL API 34");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

            capabilities.setCapability("appPackage", "com.example.vehicalinsuranceclaimapp");
            capabilities.setCapability("appActivity", ".LoginActivity");

            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(By.id("com.example.vehicalinsuranceclaimapp:id/usernameEditText")).sendKeys("user");
            driver.findElement(By.id("com.example.vehicalinsuranceclaimapp:id/passwordEditText")).sendKeys("wrongpassword");
            driver.findElement(By.id("com.example.vehicalinsuranceclaimapp:id/loginButton")).click();
            Thread.sleep(2000);
            System.out.println("Test 1: Invalid Login Attempt Completed.");

            driver.findElement(By.id("com.example.vehicalinsuranceclaimapp:id/usernameEditText")).clear();
            driver.findElement(By.id("com.example.vehicalinsuranceclaimapp:id/passwordEditText")).clear();
            driver.findElement(By.id("com.example.vehicalinsuranceclaimapp:id/usernameEditText")).sendKeys("user");
            driver.findElement(By.id("com.example.vehicalinsuranceclaimapp:id/passwordEditText")).sendKeys("password");
            driver.findElement(By.id("com.example.vehicalinsuranceclaimapp:id/loginButton")).click();
            Thread.sleep(3000);

            String currentActivity = driver.currentActivity();
            if (currentActivity.equals(".DashboardActivity")) {
                System.out.println("Test 2 Passed: Successfully navigated to Dashboard.");
            } else {
                System.out.println("Test 2 Failed: Did not reach Dashboard.");
            }

            driver.startActivity(new Activity("com.example.vehicalinsuranceclaimapp", ".FeedbackActivity"));
            Thread.sleep(3000);

            currentActivity = driver.currentActivity();
            if (currentActivity.equals(".FeedbackActivity")) {
                System.out.println("Test 3 Passed: Successfully navigated to Feedback.");
            } else {
                System.out.println("Test 3 Failed: Did not reach Feedback.");
            }

            driver.startActivity(new Activity("com.example.vehicalinsuranceclaimapp", ".LoginActivity"));
            Thread.sleep(3000);

            currentActivity = driver.currentActivity();
            if (currentActivity.equals(".LoginActivity")) {
                System.out.println("Test 4 Passed: Successfully navigated back to Login.");
            } else {
                System.out.println("Test 4 Failed: Did not return to Login.");
            }

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
