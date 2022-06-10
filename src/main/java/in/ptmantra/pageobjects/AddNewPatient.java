package in.ptmantra.pageobjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import in.ptmantra.actiondriver.Action;
import in.ptmantra.base.BaseClass;

public class AddNewPatient extends BaseClass {
	Action action=new Action();
    Properties pro=new Properties();
    WebDriverWait wait;
    
    public AddNewPatient() {
		PageFactory.initElements(getDriver(), this);
	}
    
    public void clickOnAddToPatient() {
    	wait=new WebDriverWait(getDriver(), 10000);
    	WebElement clickOnAddPatient = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"btn add-to-patient-directory-btn\"]")));
    	action.JSClick(getDriver(), clickOnAddPatient);
    }
    @FindBy(id="firstName")
    WebElement firstNametext;
    
    @FindBy(id="lastName")
    WebElement lastNameText;
    
    @FindBy(id="email")
    WebElement emailtext;
    
    @FindBy(id="therapistId")
    WebElement pttext;
    
    @FindBy(xpath="//*[@class='btn btn-primary']")
    WebElement register;
    
    @FindBy(xpath="//*[text()='First name is mandatory for registration']")
    WebElement firstnameValidation;
    
    @FindBy(xpath="//*[text()='Last name is mandatory for registration']")
    WebElement lastnameValidation;
    
    @FindBy(xpath="//*[text()='Email ID is mandatory for registration']")
    WebElement emailValidation;
    
    @FindBy(xpath="//*[text()='Associated Therapist is mandatory for registration']")
    WebElement providernameValidation;
    
    public void firstNameText() {
    	action.type(firstNametext, "");
    }
    public void lastNameText() {
    	action.type(lastNameText, "");
    }
    public void emailText() {
    	action.type(emailtext, "");
    }
    public void providerName() {
    	action.type(pttext, "");
    }
    /*public void clickOnRegisterbtn() {
    	action.JSClick(getDriver(), register);
    }*/
    public void emptyfirstName() {
    	action.type(firstNametext, "");
    }
    
    public void emptylastName() {
    	action.type(lastNameText, "");
    }
    
    public void emptyemail() {
    	action.type(emailtext, "");
    }
    
    public String firstNameValidation() {
         String firstNameValidation = firstnameValidation.getText();
         return firstNameValidation;
    }
    
    public String lastNameValidation() {
    	String lastNameValidation = lastnameValidation.getText();
    	return lastNameValidation;
    }
    
    public String emailValidation() {
    	String emailValidations= emailValidation.getText();
    	return emailValidations;
    }
    public void clickOnRegister() {
    	wait=new WebDriverWait(getDriver(), 10000);
    	WebElement clickOnRegister = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-primary']")));
    	action.JSClick(getDriver(), clickOnRegister);
    }
   
	
}
