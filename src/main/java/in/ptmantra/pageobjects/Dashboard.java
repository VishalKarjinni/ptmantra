/**
 * 
 */
package in.ptmantra.pageobjects;

import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import in.ptmantra.actiondriver.Action;
import in.ptmantra.base.BaseClass;

/**
 * @author RSTPL087
 *
 */
public class Dashboard extends BaseClass {
	Action action=new Action();
    Properties pro=new Properties();
    
    public Dashboard() {
		PageFactory.initElements(getDriver(), this);
	}
}
