package com.features.search;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.serenity.CartSteps;
import com.steps.serenity.CustomerSteps;
import com.steps.serenity.NavigationSteps;
import com.steps.serenity.ProductSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class AddToCartTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public NavigationSteps navigationSteps;

	@Steps
	public ProductSteps productSteps;

	@Steps
	public CartSteps cartSteps;
	
	@Steps
	public CustomerSteps customerSteps;

	@Test
	public void add_to_cart_using_quick_view_and_product_view() {
		navigationSteps.open_home_page_and_maximize_window();
		//navigationSteps.click_the_shop_button_from_page();

		/*int q1 = 2;
		int q2 = 3;
		int q3 = 5;
		int productIndex = 1;
		int productIndex2 =2;
		int productIndex3 =3;
		*/
		//navigationSteps.open_quick_view_for_nTH_product(productIndex);
		//productSteps.select_quantity(q1);
		//productSteps.add_to_cart();
		//navigationSteps.close_cart_view();
		//navigationSteps.open_quick_view_for_nTH_product(productIndex2);
		//productSteps.select_quantity(q2);
		//productSteps.add_to_cart();
		//productSteps.add_to_cart();
		//navigationSteps.view_cart();
		//cartSteps.check_that_the_number_of_product_types_in_cart(2);
		//cartSteps.check_that_the_number_of_product_types_in_cart_is(q1 + q2);
		//navigationSteps.close_cart_view();
		//navigationSteps.open_quick_view_for_nTH_product(productIndex3);
		//productSteps.select_quantity(q3);
		//productSteps.add_to_cart();
		//navigationSteps.view_cart();
		//cartSteps.remove_items_from_cart();
		//cartSteps.remove_items_from_cart();
		//cartSteps.remove_items_from_cart();
		//cartSteps.check_cart_is_empty_element();
		//cartSteps.check_subtotal_is("$0.00");
	
		
		
		navigationSteps.waitABit(2000);
	}

}

