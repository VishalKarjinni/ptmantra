/**
 * 
 */
package in.ptmantra.testscripts;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import in.ptmantra.actiondriver.Action;
import in.ptmantra.base.BaseClass;
import in.ptmantra.pageobjects.LoginPage;
import in.ptmantra.utility.Log;


/**
 * @author RSTPL087
 *
 */

public class Login extends BaseClass {
	LoginPage loginPage;
	Action action=new Action();
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchApp(browser);
	}
	
	
	@Test(priority=1)
	public void validCredentials() throws Throwable {
		loginPage=new LoginPage();
		//Log.startTestCase("By using the ValidCredentials");
		loginPage.usernametxt();
		loginPage.passwordtext();
		loginPage.clickLogin();
		Thread.sleep(10000);
		String actTitle = getDriver().getTitle();
		if(actTitle.equals("PTM")) {
			Assert.assertTrue(true, "Login is done successfully");
			Assert.assertEquals("PTM",actTitle);
			//Log.info("Login is done Successfully :"+actTitle);
		}else {
			Assert.assertTrue(false, "Login is done unsucessfully");
			Log.info("Login is done Unsuccessfully");
		}
		
	}
	@Test(priority=2)
	public void invalidCredentials() throws Throwable {
		loginPage=new LoginPage();
		//Log.startTestCase("By using the InvalidCredentials");
		loginPage.invalidusename();
		loginPage.invlaidpassword();
		loginPage.clickLogin();
		Thread.sleep(10000);
		String getText = loginPage.geterrormsg();
		System.out.println(getText);
		//Log.info(getText);
		
	}
	@Test(priority=3)
	public void emptyCredentials() throws Throwable {
		loginPage=new LoginPage();
		//Log.startTestCase("Tring to Login into apllication by giving the empty Credentials");
		loginPage.emptyusername();
		loginPage.emptypassword();
		loginPage.clickLogin();
		Thread.sleep(10000);
		String actmndErrormsg = loginPage.mndErrormsg();
		Assert.assertEquals("User name is mandatory for login", actmndErrormsg);
		//Log.info(actmndErrormsg);
		System.out.println(actmndErrormsg);
	}
	@Test(priority=4)
	public void correctUserName() throws Throwable {
		loginPage=new LoginPage();
		loginPage.usernametxt();
		loginPage.invlaidpassword();
		loginPage.clickLogin();
		Thread.sleep(10000);
		String getText = loginPage.geterrormsg();
		Assert.assertEquals("Incorrect username or password.", getText);
		
		System.out.println("Test case 4"+getText);
	}
	@Test(priority=5)
	public void correctPwd() throws Throwable {
		loginPage=new LoginPage();
		loginPage.invalidusename();
		loginPage.passwordtext();
		loginPage.clickLogin();
		Thread.sleep(10000);
		String getText = loginPage.geterrormsg();
		Assert.assertEquals("Incorrect username or password.", getText);
		System.out.println("Test case 5"+getText);
	}
	@Test(priority=6)
	public void registration() throws Throwable {
		loginPage=new LoginPage();
		loginPage.registrationBtn();
		Thread.sleep(10000);
		String actualtilte =getDriver().getTitle();
		if(actualtilte.equals("PTM - Register")) {
			Assert.assertTrue(true, "registration redirection is done");
			System.out.println("Test case 6"+actualtilte);
		}else {
			Assert.assertTrue(false, "registration link is not working");
		}
		
	}
	@Test(priority=7)
	public void resetPassword() throws Throwable {
		loginPage=new LoginPage();
		Thread.sleep(10000);
		loginPage.resetPassword();
		System.out.println("Test case 7");
	}
	@Parameters("browser")
	@AfterMethod
	public void teardown() {
		getDriver().close();
	}
}
