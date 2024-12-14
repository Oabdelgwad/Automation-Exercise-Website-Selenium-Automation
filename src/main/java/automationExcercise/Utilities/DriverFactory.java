package automationExcercise.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
    static WebDriver driver;
    public static WebDriver driverSetUp(String browserName, boolean isMaximized)
    {
        if(browserName.equalsIgnoreCase("Chrome"))
        {
            System.out.println("Now You have A chrome driver");
            driver=new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("Edge"))
        {
            System.out.println("Now You have A edge driver");
            driver=new EdgeDriver();
        }
        if (isMaximized)
        {
            driver.manage().window().maximize();
        }
        return  driver;
    }
}
