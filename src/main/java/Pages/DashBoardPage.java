package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashBoardPage {
    private  WebDriver driver;
    private WebDriverWait wait;
//Locators

    private By DashboardText = By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
    private By adminLocator = By.cssSelector(".oxd-text.oxd-text--span.oxd-main-menu-item--name");
    private By add = By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary']");
//Methods
    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }
    public boolean DashBoardTextIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DashboardText));
        return driver.findElement(DashboardText).isDisplayed();
    }
    public void clickAdminButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminLocator));
        driver.findElement(adminLocator).click();
    }
    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(add));
        driver.findElement(add).click();
    }


}
