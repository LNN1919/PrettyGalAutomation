package com.steps.serenity;

import org.junit.Assert;

import com.pages.CartPage;
import com.pages.FramePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CartSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;

	
	FramePage framePage;
	CartPage cartPage;

	
	
	@Step 
	public void check_that_the_number_of_product_types_in_cart(int n) {
		framePage.switch_to_final_cart_frame();
		Assert.assertTrue("Number of product types is not as expected. Expected:" + n + "but got" + cartPage.count_types_of_product(), cartPage.count_types_of_product()==n);
		framePage.switch_to_default_content();
	}
		
	@Step
	public void check_that_the_number_of_product_types_in_cart_is (int totalExpected) {
		framePage.switch_to_final_cart_frame();
		int sum = 0;
		for (int i=0; i< cartPage.count_types_of_product(); i++ ){
			sum += cartPage.get_product_quantity_from_index(i);
		}
		//Assert.assertTrue("Number of product quantities is not as expected. Expected:" + totalExpected + "but got" + sum , totalExpected == sum );
		
		Assert.assertSame(totalExpected, sum);
		framePage.switch_to_default_content();
		
	}
	@Step
	public void remove_items_from_cart () {
		framePage.switch_to_final_cart_frame();
		cartPage.remove_items_from_cart(0);
		framePage.switch_to_default_content();
	}
	
	@Step
	public void check_subtotal_is(String subtotal) {
		framePage.switch_to_final_cart_frame();
		Assert.assertTrue(subtotal.contentEquals(cartPage.get_subtotal()));
		framePage.switch_to_default_content();
	}
	
	@Step
	public void check_cart_is_empty_element () {
		framePage.switch_to_final_cart_frame();
		Assert.assertTrue(cartPage.is_cart_empty_message());
		framePage.switch_to_default_content();
	}
}
