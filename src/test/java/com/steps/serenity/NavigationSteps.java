package com.steps.serenity;

import com.pages.CartPage;
import com.pages.CommentsPage;
import com.pages.FramePage;
import com.pages.HomePage;
import com.pages.ShopPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class NavigationSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	HomePage homePage;
	FramePage framePage;
	ShopPage shopPage;
	CartPage cartPage;
	CommentsPage commentsPage;


	@Step
	public void open_home_page_and_maximize_window() {
		homePage.open();
		getDriver().manage().window().maximize();

	}

	public void click_the_shop_button_from_page() {
		homePage.click_shopNow_button();

	}

	@Step
	public void open_quick_view_for_nTH_product(int n) {
		framePage.switch_to_shop_frame();
		shopPage.move_mouse_over_nTH_product_and_click_quickView(n);
		framePage.switch_to_default_content();

	}
	
	@Step 
	public void close_cart_view (){
		framePage.switch_to_cart_frame();
		cartPage.click_close_cart_button();
		framePage.switch_to_default_content();
		
	}

	@Step
	public void open_nTH_product(int n){
		framePage.switch_to_shop_frame();
		shopPage.click_nTH_product(n);
		framePage.switch_to_default_content();
	}
	
	@Step
	public void view_cart() {
		framePage.switch_to_cart_frame();
		CartPage.click_view_cart_button();
		framePage.switch_to_default_content();
	}
	
	@Step
	public void go_to_customer_care () {
		homePage.click_cusotmerCare_button();
	}
	
	@Step
	public void go_to_comments_page () {
		homePage.click_comments_button();
		waitABit(2000);
		framePage.switch_to_comments_frame();
		
	}
	
	
}