package com.steps.serenity;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import com.helpers.IMAPHelper;
import com.pages.CartPage;
import com.pages.CustomerPage;
import com.pages.FramePage;
import com.pages.HomePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CustomerSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;

	HomePage homePage;
	FramePage framePage;
	CartPage cartPage;
	CustomerPage customerPage;

	@Step
	public void fill_name_field(String name) {
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		jse.executeScript("window.scrollBy(0,250)", "");
		customerPage.fill_name_field(name);
	}

	@Step
	public void fill_email_field(String email) {
		customerPage.fill_email_field(email);
	}

	@Step
	public void fill_subject_field(String subject) {
		customerPage.fill_subject_field(subject);
	}

	@Step
	public void fill_message_field(String message) {
		customerPage.fill_message_field(message);
	}

	@Step
	public void click_sendButton() {
		customerPage.click_sendButton();
	}

	@Step
	public void check_error_message_1() {
		waitABit(1000);
		Assert.assertTrue(customerPage.check_error_message());

	}

	@Step
	public void check_error_message_2(String expectedMessage) {
		waitABit(500);
		Assert.assertTrue("Not as expected", expectedMessage.contentEquals(customerPage.check_error_message_2()));
	}

	@Step
	public void check_email_subject_is(String expectedSubject) throws Exception {

		iMAPHelper.connectToIMAP("imap.gmail.com", "scoalainformalait@gmail.com", "1nf0rmala");

		unreadEmails = iMAPHelper.getUnreadEmails();
		boolean subjectFlag = false;

		for (int i = 0; i < unreadEmails; i++) {
			String actualSubject = iMAPHelper.getEmailSubject(i);
			if (expectedSubject.contentEquals(actualSubject)) {
				subjectFlag = true;
				break;
			}
			// iMAPHelper.getEmailFrom(i); 
			// iMAPHelper.getEmailRecipients(i);
			// iMAPHelper.getEmailBody(i);
		}
		Assert.assertTrue("Could not find unread email with expteced subject!!!", subjectFlag);

	}

	IMAPHelper iMAPHelper = new IMAPHelper();
	int unreadEmails;

	@Step
	public void check_email_body_is(String expectedContent) throws Exception {
		
		boolean bodyFlag = false;
		
		for (int i = 0; i < unreadEmails; i++) {
			String actualContent = iMAPHelper.getEmailBody(i);
			
			if (actualContent.contains(expectedContent)){
				bodyFlag = true;
				break;
			}
		}
		Assert.assertTrue("Could not find unread email with expteced subject!!!", bodyFlag);

	}
}