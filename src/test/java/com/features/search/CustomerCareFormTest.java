package com.features.search;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.serenity.CartSteps;
import com.steps.serenity.CommentsSteps;
import com.steps.serenity.CustomerSteps;
import com.steps.serenity.NavigationSteps;
import com.steps.serenity.ProductSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src\\test\\resources\\testData\\dataTest.csv")
public class CustomerCareFormTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	String name, email, subject, message, response, comments;

	@Steps
	public NavigationSteps navigationSteps;

	@Steps
	public ProductSteps productSteps;

	@Steps
	public CartSteps cartSteps;

	@Steps
	public CustomerSteps customerSteps;
	
	@Steps
	public CommentsSteps commentsSteps;
	
	@Test
	public void customer_care_form_test() throws Exception {
		navigationSteps.open_home_page_and_maximize_window();
		navigationSteps.go_to_comments_page();
		commentsSteps.fill_comments_fields(comments);
		commentsSteps.fill_name_field(name);
		commentsSteps.fill_email_field(email);
		commentsSteps.click_submit_button();
		navigationSteps.go_to_customer_care();
		customerSteps.fill_name_field(name);
		customerSteps.fill_email_field(email);
		customerSteps.fill_subject_field(subject);
		customerSteps.fill_message_field(message);
		customerSteps.click_sendButton();
		customerSteps.check_error_message_2(response);
		navigationSteps.waitABit(7000);
		customerSteps.check_email_subject_is("New message via your Wix website, from  " + email);
		customerSteps.check_email_body_is("Thank you for using Wix.com!");
		customerSteps.check_email_body_is(name);
		customerSteps.check_email_body_is(email);
		customerSteps.check_email_body_is(subject);
		customerSteps.check_email_body_is(message);
	}
}
