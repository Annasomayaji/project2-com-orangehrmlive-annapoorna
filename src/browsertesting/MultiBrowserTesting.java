package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

/**
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link.
 * 7. Print the current url.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field.
 * 12. Click on Login Button.
 * 13. Close the browser.
 */

public class MultiBrowserTesting {
    static String browser = "Chrome";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        //1. Set up the browser
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println("You have entered the wrong browser name");
        }

        //2. Open the url
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 3. Print the title of the page.
        System.out.println("The title of the page is: " + driver.getTitle());
        System.out.println("***************************************");

        //4. Print the current url.
        System.out.println("Current url is: " + driver.getCurrentUrl());
        System.out.println("***************************************");

        //5. Print the page source.
        System.out.println("Page source is: " + driver.getPageSource());
        System.out.println("***************************************");


        //6. Click on ‘Forgot your password?’ link.
//        WebElement forgotPassword= driver.findElement(By.xpath("//div[4]/p"));
//        forgotPassword.click();

        driver.findElement(By.className("orangehrm-login-forgot")).click();

        //7. Print the current url.
        System.out.println("Current url is: " + driver.getCurrentUrl());
        System.out.println("***************************************");
        
        //8.Navigate back to the login page.
        driver.navigate().back();

        //9. Refresh the page
        driver.navigate().refresh();

        // 10. Enter the email to email field.
        driver.findElement(By.name("username")).sendKeys("admin");

        //11. Enter the password to password field.
        driver.findElement(By.name("password")).sendKeys("admin123");

        // 12. Click on Login Button.
       // driver.findElement(By.xpath("//div[3]/button")).click();
        WebElement loginButton=driver.findElement(By.className("orangehrm-login-action"));
        loginButton.click();

        //13. Close the browser.
        driver.quit();


    }

}
