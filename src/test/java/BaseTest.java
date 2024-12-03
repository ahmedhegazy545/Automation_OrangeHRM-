import Pages.DashBoardPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;
    protected LoginPage loginPage;
    protected DashBoardPage dashBoardPage;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        dashBoardPage = new DashBoardPage(driver);
    }
    @AfterMethod
    public void tearDown() {
      //  driver.quit();

    }

}
