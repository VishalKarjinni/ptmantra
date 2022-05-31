/**
 * 
 */
package in.ptmantra.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.ptmantra.actiondriver.Action;
import in.ptmantra.base.BaseClass;

/**
 * @author RSTPL087
 *
 */
public class Registration extends BaseClass {
	Action action=new Action();
	
	public Registration() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//*[@class='form-control form-control']")
	WebElement npNPI;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement emailid;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	WebElement registration;
	
	public void validNPI() {
		action.type(npNPI, " ");
	}
	public void validEmail() {
		action.type(emailid, " ");
	}
	
	public void invalidNPI()
	{
		action.type(npNPI, " ");
	}
	public void invalidEmail()
	{
		action.type(emailid, " ");
	}
	public void registrationClick() {
		action.JSClick(getDriver(), registration);
	}
	
	
}
