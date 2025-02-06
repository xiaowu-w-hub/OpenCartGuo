package testCases;import org.testng.Assert;import org.testng.annotations.Test;import pageObjects.HomePage;import pageObjects.LoginPage;import pageObjects.MyAccountPage;import testBase.BaseClass;public class TC002_LoginTest extends BaseClass {    @Test(groups = {"Sanity", "Master"})    public void verify_login() {        try {            logger.info("--------starting TC002_LoginTest--------");            //homepage            HomePage hp = new HomePage(driver);            hp.clickMyAccount();            hp.clickLogin();            logger.info("login link is clicked...");            //loginpage            LoginPage lp = new LoginPage(driver);            lp.setEmailAddress(p.getProperty("email"));            lp.setPassword(p.getProperty("password"));            lp.clickLogin();            //MyAccountpage            MyAccountPage macc = new MyAccountPage(driver);            Boolean targetPage = macc.isMyAccountPageExists();            Assert.assertTrue(targetPage);        }        catch (Exception e){            Assert.fail();        }        logger.info("--------finish TC002_LoginTest--------");    }}