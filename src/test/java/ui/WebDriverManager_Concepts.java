package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager_Concepts {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.patient-seamhealth.support");
        driver.manage().window().maximize();
        driver.findElement(By.id("signInEmail")).sendKeys("xerelax126@rebona.com");
        driver.findElement(By.id("password")).sendKeys("password");
        System.out.println(driver.getTitle());
        driver.close();
    }
}
