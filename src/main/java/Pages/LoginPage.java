package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage  {

    private WebDriver driver;
    private WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    //Web elements
    private By  userName = By.cssSelector("input[name='username']");
    private By  password = By.cssSelector("input[type='password']");
    private By LoginButton = By.cssSelector(".oxd-button,oxd-button--medium");
    private By Invalid = By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text");
    private By Recuierd = By.xpath("//span[contains(.,Required)]");

    //Methods
    public void addUsername(String Username)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
        driver.findElement(userName).sendKeys(Username);

    }
    public void addPassword(String passwords){
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        driver.findElement(password).sendKeys(passwords);
    }
    public DashBoardPage ClickButton()
    {
        driver.findElement(LoginButton).click();
        return new DashBoardPage(driver);
    }
    public boolean InvalidErrorUser()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Invalid));
        return driver.findElement(Invalid).isDisplayed();
    }
    public boolean InvalidErrorPassword()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Invalid));
        return driver.findElement(Invalid).isDisplayed();
    }
    public boolean EmptyPassword()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Recuierd));
        return driver.findElement(Recuierd).isDisplayed();
    }
    public boolean EmptyUsername()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Recuierd));
        return driver.findElement(Recuierd).isDisplayed();
    }
    public boolean Dublicated()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Recuierd));
        List<WebElement> list = driver.findElements(Recuierd);
        for (WebElement webElement : list) {
            if (!webElement.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
    public DashBoardPage successLogin()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginButton));
        driver.findElement(userName).sendKeys("Admin");
        driver.findElement(password).sendKeys("admin123");
        driver.findElement(LoginButton).click();
        return new DashBoardPage(driver);
    }
}
