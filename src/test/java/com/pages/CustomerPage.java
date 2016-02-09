package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;



@DefaultUrl("http://gabikis.wix.com/fashion")
public class CustomerPage extends PageObject {

	@FindBy(id="i24bs8nsnameField")
	private WebElementFacade nameField;
	
	@FindBy(id="i24bs8nsemailField")
	private WebElementFacade emailField;
	
	@FindBy(id="i24bs8nssubjectField")
	private WebElementFacade subjectField;
	
	@FindBy(id="i24bs8nsmessageField")
	private WebElementFacade messageField;
	
	@FindBy(id="i24bs8nssubmit")
	private WebElementFacade sendButton;
	
	@FindBy(id="i24bs8nsnotifications")
	private WebElementFacade errorMessage;
	
	

	
	
	

	public void fill_name_field (String name) {
		nameField.sendKeys(name);
		
	}
	
	public void fill_email_field (String email) {
		emailField.sendKeys(email);
		
	}
	
	public void fill_subject_field (String subject) {
		subjectField.sendKeys(subject);
		
	}
	
	public void fill_message_field (String message) {
		messageField.sendKeys(message);
		
	}
	
	public void click_sendButton () {
		sendButton.click();
		waitABit(2000);
		
	}
	
	public boolean check_error_message () {
		return errorMessage.isVisible();
		
	}
	
	public String check_error_message_2 () {
		return errorMessage.getText();
	}

	
}
