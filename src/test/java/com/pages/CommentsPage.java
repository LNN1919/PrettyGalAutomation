package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;



@DefaultUrl("http://gabikis.wix.com/fashion")
public class CommentsPage extends PageObject {

	@FindBy(css="div>.form-control.animate-grow")
	private WebElementFacade commentsField;
	
	@FindBy(css=".form-control.ng-pristine")
	private WebElementFacade nameField;
	
	@FindBy(css=".wxa-form-group.ng-scope>.form-control.ng-pristine")
	private WebElementFacade emailField;
	
	@FindBy(css="div>.btn.btn-primary")
	private WebElementFacade submitButton;
	

	

	public void fill_comments_field (String comments) {
		commentsField.sendKeys(comments);
		
		
	}
	
	public void fill_email_field (String email) {
		emailField.sendKeys(email);
	}
	
	public void fill_name_field (String email) {
		nameField.sendKeys(email);
	}
	
	public void click_submit_button () {
		submitButton.click();
	}
		
	
}
