/**
 * 
 */
package in.ptmantra.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import in.ptmantra.actiondriver.Action;
import in.ptmantra.base.BaseClass;
import in.ptmantra.pageobjects.AddNewPatient;
import in.ptmantra.pageobjects.LoginPage;

/**
 * @author RSTPL087
 *
 */
@Test
public class AddNewPatients extends BaseClass {
    Action action=new Action();
    LoginPage loginPage;
    AddNewPatient addnewpatient;
    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {
    	launchApp(browser);
    }
    @Parameters("browser")
    @AfterMethod
    public void tearDown() {
    	getDriver().close();
    }
    @Test(priority=1)
    public void creatingNewPatient() throws Throwable {
    	loginPage=new LoginPage();
    	addnewpatient=new AddNewPatient();
        loginPage.usernametxt();
        loginPage.passwordtext();
        loginPage.clickLogin();
        addnewpatient.clickOnAddToPatient();
        Thread.sleep(1000);
        addnewpatient.firstNameText();
        addnewpatient.lastNameText();
        addnewpatient.emailText();
        addnewpatient.clickOnRegister();
        Thread.sleep(1000);
        
          
    }
    @Test(priority=2)
    public void emptyFirstName() throws Throwable {
    	loginPage=new LoginPage();
    	addnewpatient=new AddNewPatient();
        loginPage.usernametxt();
        loginPage.passwordtext();
        loginPage.clickLogin();
        addnewpatient.clickOnAddToPatient();
        Thread.sleep(10000);
        addnewpatient.emptyfirstName();
        //assertTrue(action.isTextPresent("First name is mandatory for registration"), "Mandatory field message is coming");
        addnewpatient.lastNameText();
        addnewpatient.emailText();
        addnewpatient.clickOnRegister();
        String actfirstNameValidation = addnewpatient.firstNameValidation();
        assertEquals(actfirstNameValidation, "First name is mandatory for registration");
        System.out.println(actfirstNameValidation);
    }
    @Test(priority=3)
    public void emptyLastName() throws Throwable {
    	loginPage=new LoginPage();
    	addnewpatient=new AddNewPatient();
        loginPage.usernametxt();
        loginPage.passwordtext();
        loginPage.clickLogin();
        addnewpatient.clickOnAddToPatient();
        Thread.sleep(1000);
        addnewpatient.firstNameText();
        addnewpatient.emptylastName();
        addnewpatient.emailText();
        addnewpatient.clickOnRegister();
        String actlastNameValidation = addnewpatient.lastNameValidation();
        assertEquals(actlastNameValidation, "Last name is mandatory for registration");
        System.out.println(actlastNameValidation);
        	
    }
    @Test(priority=4)
    public void emptyEmail() throws Throwable {
    	loginPage=new LoginPage();
    	addnewpatient=new AddNewPatient();
        loginPage.usernametxt();
        loginPage.passwordtext();
        loginPage.clickLogin();
        addnewpatient.clickOnAddToPatient();
        Thread.sleep(1000);
        addnewpatient.firstNameText();
        addnewpatient.lastNameText();
        addnewpatient.emptyemail();
        Thread.sleep(1000);
        addnewpatient.clickOnRegister();
        String actemailValidation = addnewpatient.emailValidation();
        assertEquals(actemailValidation, "Email ID is mandatory for registration");
        System.out.println(actemailValidation);
    }
    @Test(priority=5)
    public void fullempty() {
    	loginPage=new LoginPage();
    	addnewpatient=new AddNewPatient();
        loginPage.usernametxt();
        loginPage.passwordtext();
        loginPage.clickLogin();
        addnewpatient.clickOnAddToPatient();
    }
    		
}
