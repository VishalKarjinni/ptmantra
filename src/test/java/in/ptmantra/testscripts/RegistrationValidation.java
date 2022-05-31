/**
 * 
 */
package in.ptmantra.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import in.ptmantra.actiondriver.Action;
import in.ptmantra.base.BaseClass;
import in.ptmantra.pageobjects.LoginPage;
import in.ptmantra.pageobjects.Registration;

/**
 * @author Vishal
 *
 */
public class RegistrationValidation extends BaseClass{
	LoginPage loginPage;
	Registration registration;
	Action action=new Action();
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(priority=1)
	public void validRegistration() {
		loginPage=new LoginPage();
		registration=new Registration();
		loginPage.registrationBtn();
		registration.validNPI();
		registration.validEmail();
		registration.registrationClick();
	}
	@Test(priority=2)
	public void invalidRegistration() {
		loginPage=new LoginPage();
		registration=new Registration();
		loginPage.registrationBtn();
		registration.invalidNPI();
		registration.invalidEmail();
		registration.registrationClick();
	}
	
	
}
