import Pages.DashBoardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class adminTestCase extends BaseTest {

    @Test
    public void adminPage() {
        DashBoardPage dashBoardPage = loginPage.successLogin();
        dashBoardPage.clickAdminButton();
        dashBoardPage.clickAddButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser");
    }
}
