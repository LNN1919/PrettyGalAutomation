package com.pages;

import java.util.List;

import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;



@DefaultUrl("http://gabikis.wix.com/fashion")
public class HomePage extends PageObject {

	@FindBy(css="a > img.media-item.active")
	private List<WebElementFacade> productImageList;

	@FindBy(css="a.action.quickview")
	private List<WebElementFacade> quickViewList;
	
	@FindBy(css="a#i2epz4bn_1link")
	private WebElementFacade shopNow_button;
	
	@FindBy(id="i1ltay0q3")
	private WebElementFacade customerCare;
	
	@FindBy(id="i1ltay0q3label")
	private WebElementFacade comments;
	
	

	public void move_mouse_over_nTH_product_and_click_quickView(int n) {

		Actions builder = new Actions(getDriver());
		builder.moveToElement(productImageList.get(n));
		builder.perform();

		quickViewList.get(n).click();

	}

	public void click_shopNow_button() {
		shopNow_button.waitUntilVisible();
		shopNow_button.click();

	}

	public void click_cusotmerCare_button () {
		customerCare.click();
		waitABit(2000);
	}
	
	public void click_comments_button () {
		comments.click();
		waitABit(2000);
	}
	
}
