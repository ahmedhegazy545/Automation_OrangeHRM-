import Pages.DashBoardPage;
import Pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTestCase extends BaseTest {
    @Test
    public void testsuccessLogin() {
        //add username
        loginPage.addUsername("Admin");
        //add password
        loginPage.addPassword("admin123");
        //click Button
       DashBoardPage dashBoard = loginPage.ClickButton();
       // assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        assertTrue(dashBoard.DashBoardTextIsDisplayed(),"DashBoard text");
    }
    @Test
    public void testUserInvalid() {
        loginPage.addUsername("dmin");
        loginPage.addPassword("admin123");
        loginPage.ClickButton();
       assertTrue( loginPage.InvalidErrorUser(),"Error User name");
    }
    @Test
    public void testPasswordInvalid() {
        loginPage.addUsername("Admin");
        loginPage.addPassword("admin1");
        loginPage.ClickButton();
        assertTrue( loginPage.InvalidErrorPassword(),"Error Password");
    }
    @Test
    public void EmptyPass(){
        loginPage.addUsername("Admin");
        loginPage.addPassword("");
        loginPage.ClickButton();
        assertTrue(loginPage.EmptyPassword(),"Empty_Password");
    }
    @Test
    public void EmptyUser(){
        loginPage.addUsername("");
        loginPage.addPassword("admin123");
        loginPage.ClickButton();
        assertTrue(loginPage.EmptyPassword(),"Empty_Password");
    }
    @Test
    public void EmptyUserAndPassword(){
        loginPage.addUsername("");
        loginPage.addPassword("");
        loginPage.ClickButton();
        assertTrue(loginPage.EmptyPassword(),"Empty_Password");
    }
    @Test
    public void Dublicate(){
        loginPage.addUsername("Admin");
        loginPage.addPassword("");
        loginPage.ClickButton();
        assertTrue(loginPage.Dublicated(),"Empty UserName and Password");
    }


}
