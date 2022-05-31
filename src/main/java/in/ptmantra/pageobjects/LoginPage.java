/**
 * 
 */
package in.ptmantra.pageobjects;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import in.ptmantra.actiondriver.Action;
import in.ptmantra.base.BaseClass;

/**
 * @author RSTPL087
 *
 */
public class LoginPage extends BaseClass {
    Action action=new Action();
    Properties pro=new Properties();
    
    
   	@FindBy(xpath="//*[@class='form-control form-control']")
	WebElement usernametext;
	
	@FindBy(name="password")
	WebElement passwordtext;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	WebElement loginbtn;
	
	@FindBy(xpath="//*[@id='showhide']")
	WebElement showhide;
	
	@FindBy(xpath="//*[@class='alert alert-danger align-middle p-3']")
	WebElement errormsg;
	
	@FindBy(xpath="//*[@class='alert alert-danger']")
	WebElement mndusererrormsg;
	
	@FindBy(xpath="//*[@class='alert alert-danger']")
	WebElement mndpwderrormsg;
	
	@FindBy(xpath="//a[@href='/#/register']")
	WebElement registrationbtn;
	
	@FindBy(xpath="//*[@class='resetlink']")
	WebElement resetpassword;
	
	
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void usernametxt() {
	   action.type(usernametext,"ptmantraqa+john@gmail.com");
	   
	}
	
	public void passwordtext() {
		action.type(passwordtext,"Pass@123");
	}
	
	public void invalidusename() {
		action.type(usernametext, "jdsdshvhv");
	}
	
	public void invlaidpassword() {
		action.type(passwordtext, "jnjnjnfnnn");
	}
	
	public void emptyusername() {
		action.type(usernametext, "");
	}
	public void emptypassword() {
		action.type(passwordtext, "");
	}
	
	public String geterrormsg() {
		String getText = errormsg.getText();
		return getText;
	}
	
	public String mndErrormsg()
	{
		String msderrormsg = mndusererrormsg.getText();
		return msderrormsg;
	}
	
	public String mndpwdErrormsg()
	{
		String msdpwderrormsg = mndpwderrormsg.getText();
		return msdpwderrormsg;
	}
	
	public void registrationBtn() 
	{
		action.JSClick(getDriver(), registrationbtn);
	}
	
	public void resetPassword() 
	{
		action.JSClick(getDriver(), resetpassword);
	}
	
	
	public Dashboard clickLogin() {
	    action.JSClick(getDriver(), loginbtn);
		return new Dashboard();
	}

 
}
