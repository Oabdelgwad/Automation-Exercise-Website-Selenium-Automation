package automationExcercise.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverFactory {
    static WebDriver driver;
    public static WebDriver driverSetUp(String browserName, boolean isMaximized, String headlessMode )
    {
        if(browserName.equalsIgnoreCase("Chrome"))
        {
            System.out.println("Now You have A chrome driver");
            if(headlessMode.equalsIgnoreCase("headless"))
            {
                System.out.println("Running in headless mode");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless", "--disable-gpu");
                driver = new ChromeDriver(options);
            }
            else {
                System.out.println("Running in Not headless mode");
                driver=new ChromeDriver();
            }

        }
        else if (browserName.equalsIgnoreCase("Edge"))
        {
            System.out.println("Now You have A edge driver");
            if(headlessMode.equalsIgnoreCase("headless"))
            {
                System.out.println("Running in headless mode");
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless", "--disable-gpu");
                driver = new EdgeDriver(options);
            }
            else {
                System.out.println("Running in Not headless mode");
                driver=new EdgeDriver();
            }
        }
        if (isMaximized)
        {
            driver.manage().window().maximize();
        }
        return  driver;
    }
}
