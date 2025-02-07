

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ToDoTest {

    public static void main(String[] args) throws InterruptedException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixcel 9 Pro XL API 34"); 
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("appPackage", "com.example.todo"); 
        caps.setCapability("appActivity", ".MainActivity"); 

        try {
            AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
            Thread.sleep(3000); 

            WebElement addTaskButton = driver.findElement(By.id("com.example.todo:id/addTaskButton"));
            addTaskButton.click();
            Thread.sleep(2000);

            WebElement titleField = driver.findElement(By.id("com.example.todo:id/taskInput"));
            titleField.sendKeys("Complete Homework");
            Thread.sleep(1000);

            WebElement addTaskConfirmButton = driver.findElement(By.id("com.example.todo:id/addTaskButton"));
            addTaskConfirmButton.click();
            Thread.sleep(2000);

            WebElement viewTasksButton = driver.findElement(By.id("com.example.todo:id/viewTasksButton"));
            viewTasksButton.click();
            Thread.sleep(2000);

            WebElement taskText = driver.findElement(By.xpath("//android.widget.TextView[@text='Complete Homework']"));

            if (taskText.isDisplayed()) {
                System.out.println("Test Passed: Task added successfully and displayed.");
            } else {
                System.out.println("Test Failed: Task not found in task list.");
            }

            // Quit driver
            driver.quit();

        }  catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
