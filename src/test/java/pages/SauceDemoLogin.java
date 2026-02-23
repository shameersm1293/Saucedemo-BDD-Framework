package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLogin {
	WebDriver driver;
	
	    @FindBy(id="user-name") 
	    private WebElement user;
	    
	    @FindBy(id="password") 
	    private WebElement pass;
	    
	    @FindBy(id="login-button") 
	    private WebElement login;
	    
	    public SauceDemoLogin(WebDriver driver2) {
	    	 this.driver = driver2;
	    PageFactory.initElements(driver2, this);
		    
		}
		public WebElement getUser() { 
	    return user; 
	    }
	    public WebElement getPass() { 
	    return pass;
	    }
	    public WebElement getLogin() { 
	    return login; 
	    }
	   


}
