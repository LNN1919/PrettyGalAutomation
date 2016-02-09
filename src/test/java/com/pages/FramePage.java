package com.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;

public class FramePage extends PageObject {

	public void switch_to_shop_frame() {
		getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("iframe[src*='storefront/gallery?cacheKiller']")));

	}

	public void switch_to_quick_frame_and_product_view_frame() {
		getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("iframe[src*='storefront/product/']")));

	}

	public void switch_to_default_content() {
		getDriver().switchTo().defaultContent();
	}
	
	public void switch_to_cart_frame () {
		getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("iframe[src*='storefront/cartwidgetPopup?cacheKiller']")));
		
	}
	
	public void switch_to_final_cart_frame () {
		getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("iframe[src*='storefront/cart?cacheKiller']")));
		
	}
	
	public void switch_to_comments_frame () {
		getDriver().switchTo().frame(getDriver().findElement(By.cssSelector(".s20iframe")));
	}
	
	
}
