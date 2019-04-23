package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class DressesPageObjects extends BasePage{

	@FindBy(xpath = "//*[@class='heading-counter']")
	private WebElement productCountHeader;
	
	@FindBys(@FindBy(xpath = "//ul[@class='product_list grid row']/li"))
	private List<WebElement> productList;
	
	@FindBy(xpath = "//ul[@class='product_list grid row']/li//h5/a")
	private WebElement product;
	
	@FindBy(xpath = "//p[@id='add_to_cart']//span")
	private WebElement addToCart;
	
	@FindBy(xpath = "//div[@id='layer_cart']//div[@class='button-container']/a/span")
	private WebElement proceed;
	
	@FindBy(xpath = "//span[@class='heading-counter']/span[@id='summary_products_quantity']")
	private WebElement quantity;
	
	@FindBy(xpath = "//div[@class='layered_subtitle_heading']/span[text()='Size']")
	private WebElement sizeTab;
	
	@FindBy(xpath = "//ul[@id='ul_layered_id_attribute_group_1']/li")
	private List<WebElement> sizeList;
	
	public DressesPageObjects() {
		PageFactory.initElements(driver, this);
	}
	public int getProductCount() {
		return productList.size();
	}
	public int getCountFromHeaderText() {
		System.out.println(productCountHeader);
		return Integer.parseInt(productCountHeader.getText().split(" ")[2]);
	}
	public void clickProduct() {
		product.click();		
	}
	public boolean checkCart() {
		addToCart.click();
		if(isElementVisible(proceed)) {
			proceed.click();
		}
		String s = quantity.getText().split(" ")[0];
		int count = Integer.parseInt(s);
		if(count != 0) {
			System.out.println("Your cart contains " + s + " product(s)");
		}
		return elementFound(quantity);
	}
	public boolean getSize() {
		for(int i=0;i<sizeList.size();i++) {
			System.out.println(sizeList.get(i).getText());
		}
		return elementFound(sizeTab);
	}
}
