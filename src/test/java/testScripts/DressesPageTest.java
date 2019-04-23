package testScripts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.DressesPageObjects;
import pageObjects.HomePageObjects;

public class DressesPageTest {
	HomePageObjects hp;
	DressesPageObjects dp;
	
	public DressesPageTest() {
		hp = new HomePageObjects();
		dp = new DressesPageObjects();
	}
	
	@BeforeClass
	public void clickDresses() {
		hp.clickDresses();
	}
	@Test
	public void verifyProductCount() {
		Assert.assertTrue(dp.getCountFromHeaderText() == dp.getProductCount(),"Failed : Count misatch");
	}
	@Test
	public void sizeElementFound() {
		hp.clickDresses();
		Assert.assertTrue(dp.getSize(), "Size element not found");
	}
	@Test
	public void VerifyCart() {
		dp.clickProduct();
		Assert.assertTrue(dp.checkCart(), "Add to cart failed");
	}
}
