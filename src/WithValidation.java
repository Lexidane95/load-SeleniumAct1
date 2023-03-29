import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WithValidation {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path of the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

        // Create an instance of ChromeDriver
        driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void testPositiveLogin() {
        // Navigate to the website
        driver.get("http://www.example.com");

        // Locate and click on the login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Locate the email and password fields and enter valid credentials
        WebElement emailField = driver.findElement(By.id("emailField"));
        WebElement passwordField = driver.findElement(By.id("passwordField"));
        emailField.sendKeys("validemail@example.com");
        passwordField.sendKeys("validpassword");

        // Locate and click on the submit button
        WebElement submitButton = driver.findElement(By.id("submitButton"));
        submitButton.click();

        // Verify that the user is logged in by checking the presence of the welcome message
        WebElement welcomeMessage = driver.findElement(By.xpath("//div[contains(text(), 'Welcome back')]"));
        Assert.assertTrue(welcomeMessage.isDisplayed(), "User was not logged in successfully");
    }

    @Test(priority = 2)
    public void testNegativeLogin() {
        // Navigate to the website
        driver.get("http://www.example.com");

        // Locate and click on the login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Locate the email and password fields and enter invalid credentials
        WebElement emailField = driver.findElement(By.id("emailField"));
        WebElement passwordField = driver.findElement(By.id("passwordField"));
        emailField.sendKeys("invalidemail@example.com");
        passwordField.sendKeys("invalidpassword");

        // Locate and click on the submit button
        WebElement submitButton = driver.findElement(By.id("submitButton"));
        submitButton.click();

        // Verify that the error message is displayed
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Invalid email or password')]"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message was not displayed for invalid login");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
