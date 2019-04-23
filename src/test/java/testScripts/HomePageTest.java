package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;

public class HomePageTest {
	HomePageObjects hp;
	public HomePageTest() {
		hp = new HomePageObjects();
	}
	@Test
	public void verifyTabs() {
		Assert.assertTrue(hp.checkWomenTab(), "Failed : Women tab not found");
		Assert.assertTrue(hp.checkDressesTab(), "Failed : Dresses tab not found");
		Assert.assertTrue(hp.checkTshirtsTab(), "Failed : T-shirts tab not found");
	}
	@Test
	public void verifyNavigation() {
		Assert.assertTrue(hp.navToWomen(), "Navigation failed");
		Assert.assertTrue(hp.navToDresses(), "Navigation failed");
		Assert.assertTrue(hp.navToTshirts(), "Navigation failed");
	}
	@Test
	public void verifyNewsletter() {
		hp.setValue();
		Assert.assertTrue(hp.getAlert(), "Failed : Subscription failed");
	}
	@Test
	public void verifyCartBtn() {
		Assert.assertTrue(hp.checkCartButton(), "Failed to find Add to cart button");
	}
}
