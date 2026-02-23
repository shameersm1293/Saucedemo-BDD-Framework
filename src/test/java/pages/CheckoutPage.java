package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	WebDriver driver;
	
	 @FindBy(id="first-name") 
	 private WebElement firstName;
	 
	 @FindBy(id="last-name") 
	 private WebElement lastName;
	 
	 @FindBy(id="postal-code") 
	 private WebElement postalCode;
	    
	 @FindBy(id="continue") 
	 private WebElement continueBtn;
	 
	 @FindBy(id="finish") 
	 private WebElement finishBtn;
	 
	 @FindBy(className="complete-header") 
	 private WebElement confirmationMsg;
	 
	 @FindBy(xpath="//div[@class='error-message-container error']") 
	 private WebElement errorMsg;


		public CheckoutPage(WebDriver driver2) {
			this.driver = driver2;
			PageFactory.initElements(driver2, this);
		
		}



		public WebElement getFirstName() { 
	    	return firstName; 
	    }
	    public WebElement getLastName() { 
	    	return lastName; 
	    }
	    public WebElement getPostalCode() { 
	    	return postalCode; 
	    }
	    public WebElement getContinueBtn() { 
	    	return continueBtn;
	    }
	    public WebElement getFinishBtn() { 
	    	return finishBtn; 
	    }
	    public WebElement getConfirmationMsg() { 
	    	return confirmationMsg; 
	    }
	    public WebElement getErrorMsg() { 
	    	return errorMsg; 
	    
	}
}
