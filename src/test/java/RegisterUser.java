import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class RegisterUser {
    public static void main(String[] args) {

        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement logoDisplay = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoDisplay.isDisplayed());
        //4. Click on 'Signup / Login' button
        WebElement loginClick = driver.findElement(By.xpath("//a[@href='/login']"));
        loginClick.click();
        //5. Verify 'New User Signup!' is visible
        WebElement signupText = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(signupText.isDisplayed());
        //6. Enter name and email address
        WebElement enterName=driver.findElement(By.xpath("//input[@name='name']"));
        enterName.sendKeys("kubra");
        WebElement enterEmail=driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        enterEmail.sendKeys("kubra5@caliskan.com");
        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement accountInfoText = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(accountInfoText.isDisplayed());
        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.id("id_gender2")).click();

        WebElement enterPassword=driver.findElement(By.id("password"));
        enterPassword.sendKeys("123456");
        Select birthDay= new Select(driver.findElement(By.id("days")));
        birthDay.selectByVisibleText("1");

        Select birthMonth= new Select(driver.findElement(By.id("months")));
        birthMonth.selectByVisibleText("April");

        Select birthYear= new Select(driver.findElement(By.id("years")));
        birthYear.selectByVisibleText("1990");
        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.id("newsletter")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("optin")).click();
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
       WebElement formBox=driver.findElement(By.id("first_name"));
       Actions actions=new Actions(driver);
            actions.click(formBox)
                        .sendKeys("Kubra")
                        .sendKeys(Keys.TAB)
                        .sendKeys("Caliskan")
                        .sendKeys(Keys.TAB)
                        .sendKeys("-")
                        .sendKeys(Keys.TAB)
                        .sendKeys("Atakum")
                        .sendKeys(Keys.TAB)
                        .sendKeys("Korfez")
                        .perform();

        Select selectCountry= new Select(driver.findElement(By.id("country")));
        selectCountry.selectByVisibleText("United States");

        WebElement formBox2=driver.findElement(By.id("state"));
        Actions actions1=new Actions(driver);
        actions1.click(formBox2)
                .sendKeys("los angelas")
                .sendKeys(Keys.TAB)
                .sendKeys("samsun")
                .sendKeys(Keys.TAB)
                .sendKeys("55200")
                .sendKeys(Keys.TAB)
                .sendKeys("555 55 555")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        //13. Click 'Create Account button'
        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreated = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(accountCreated.isDisplayed());
        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        //16. Verify that 'Logged in as username' is visible
        WebElement accountLogout = driver.findElement(By.xpath("//a[@href='/logout']"));
        Assert.assertTrue(accountLogout.isDisplayed());
        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button


        WebElement accountDelete = driver.findElement(By.xpath("//h1[text()='Delete Account']"));
        Assert.assertTrue(accountDelete.isDisplayed());
    }
}
