package com.steps.serenity;

import com.pages.CartPage;
import com.pages.CommentsPage;
import com.pages.CustomerPage;
import com.pages.FramePage;
import com.pages.HomePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CommentsSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;

	HomePage homePage;
	FramePage framePage;
	CartPage cartPage;
	CustomerPage customerPage;
	CommentsPage commentsPage;


	@Step
	public void fill_comments_fields (String comments) {
		commentsPage.fill_comments_field(comments);
	}
	
	@Step
	public void fill_name_field (String name) {
		commentsPage.fill_name_field(name);
	}
	
	@Step
	public void fill_email_field (String email) {
		commentsPage.fill_email_field(email);
	}
	
	@Step
	public void click_submit_button () {
		commentsPage.click_submit_button();
	}
	
}