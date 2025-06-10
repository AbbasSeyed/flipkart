package org.main.flipkart;

import org.base.flipkart.FlipkartBase;
import org.openqa.selenium.By;
import org.pom.flipkart.PomFlipkart;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Flipkart extends FlipkartBase {
	PomFlipkart pom;
	
	@Given("lounch the browser")
	public void lounch_the_browser() {
	    lounchBrowser("chrome");
	    pom = new PomFlipkart(driver);
	    manage();
	    wait(10);
	}

	@Given("open the website")
	public void open_the_website() {
	    openurl("https://www.flipkart.com/");
	}

	@When("search the product {string}")
	public void search_the_product(String product) {
		click(pom.getSearchbar());
		sendkeyes(pom.getSearchbar(), product);
		click(pom.getSearchbarButton());   
	}

	@When("click the product")
	public void click_the_product() {
	   click(pom.getProduct());
	}
	
	@When("click addcart the product")
	public void click_addcart_the_product() {
		windowsHandle(1);
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
	}
	
	@When("click buy now the product")
	public void click_buy_now_the_product() {
	   windowsHandle(1);
	   click(pom.getBuy());
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
	   System.out.println("validation");
	}

	

}
