package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
//import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

//@DefaultUrl("http://gabikis.wix.com/fashion#!cart/c1y3k")
public class CartPage extends PageObject {

	@FindBy(css = ".curtain")
	private WebElementFacade closeCart;

	@FindBy(css = "footer>a[href*='#!cart/c1y3k']")
	private static WebElementFacade viewCart;

	@FindBy(css = ".above-footer")
	private WebElementFacade subtotal;

	@FindBy(css = "input.product-quantity-input")
	private List<WebElementFacade> quantityList;

	public void click_close_cart_button() {
		closeCart.click();

	}

	public static void click_view_cart_button() {
		viewCart.click();
	}

	@FindBy(css = "li.product.has-hr")
	private List<WebElementFacade> productList;
	
	@FindBy(css = "li a.product-remove")
	private List<WebElementFacade> removeFirstProduct;
	
	@FindBy(css = "span[data-hook='cart-subtotal']")
	private WebElementFacade Subtotal;
	
	@FindBy(css = "div.products-empty")
	private WebElementFacade cartIsEmptyMessage;
	
	public void remove_items_from_cart(int n) {
		waitABit(1500);
		removeFirstProduct.get(n).click();

	}
	
	public String get_subtotal () {
		return Subtotal.getText();
	}
	
	public boolean is_cart_empty_message () {
		return cartIsEmptyMessage.isVisible();
	}
	
	
	
	public int count_types_of_product() {
		waitABit(2000);
		List<WebElement> productListActual = getDriver().findElements(By.cssSelector("li.product.has-hr"));
		return productListActual.size();
	}

	public int get_product_quantity_from_index(int index) {
		WebElementFacade productQuantityElement =  quantityList.get(index);
		
		String productQuantityStr = productQuantityElement.getValue();
		
		int productQuantity	 = Integer.parseInt(productQuantityStr);
		
		return productQuantity;
		//return Integer.parseInt(quantityList.get(index).getText());					
	}
}
