import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tabin\\OneDrive\\Documents\\Selenium\\SeleniumAutoTest1\\load SeleniumAct1\\src\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://interactive.canadianctb.ca/login/canvas");
    
        // Enter email and password
        WebElement emailField = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div[2]/form[1]/div[1]/input"));
        emailField.sendKeys("tabingaalexis@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div[2]/form[1]/div[2]/input"));
        passwordField.sendKeys("CCTB012023");

        // Click on Sign In button
        WebElement signInBtn = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div[2]/form[1]/div[3]/div[2]/button"));
        signInBtn.click();

        WebElement loggedInUser = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div/div/div[1]/div/h1/span"));
        String loggedInUserText = loggedInUser.getText();
        if (loggedInUserText.contains("Dashboard")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }

        driver.quit();
    }
}
