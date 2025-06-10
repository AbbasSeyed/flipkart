package org.pom.flipkart;

import org.base.flipkart.FlipkartBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomFlipkart extends FlipkartBase{
	
	public PomFlipkart (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchbar;
	
	@FindBy(xpath = "//button[@class='_2iLD__']")
	private WebElement searchbarButton;
	
	@FindBy(xpath = "//div[@class='col col-7-12']")
	private WebElement product;
	
	@CacheLookup
	@FindBy(xpath = "//button[text()='Add to cart']")
	private WebElement addcart;
	
	@FindBy(xpath = "//button[text()='Buy Now']")
	private WebElement buy;
	
	public WebElement getBuy() {
		return buy;
	}

	public WebElement getSearchbar() {
		return searchbar;
	}

	public WebElement getSearchbarButton() {
		return searchbarButton;
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getAddcart() {
		return addcart;
	}

	

}
