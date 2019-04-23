package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import pageObjects.ProductDetailsPageObjects;

public class ProductDetailsPageTest {
	HomePageObjects hp;
	ProductDetailsPageObjects pdt;
	
	public ProductDetailsPageTest() {
		hp = new HomePageObjects();
		pdt = new ProductDetailsPageObjects(); 	
	}
	@Test
	public void verifyDescription() {
		Assert.assertTrue(pdt.checkDescription(), "Failed : No product description");
	}
	@Test
	public void checkSocials() {
		hp.clickFirstPdt();
		Assert.assertTrue(pdt.checkTweet(), "Failed : Tweet is not found");
		Assert.assertTrue(pdt.checkShare(), "Failed : Share icon not found");
	}
}
