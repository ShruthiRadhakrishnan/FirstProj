package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPageObjects extends BasePage{

	@FindBy(xpath = "//div//p/button[1]/i")
	private WebElement tweet;
	
	@FindBy(xpath = "//div//p/button[2]/i")
	private WebElement share;
	
	@FindBy(xpath = "//*[@id='short_description_content']/p")
	private WebElement pdtDescription;
	
	public ProductDetailsPageObjects() {
		PageFactory.initElements(driver, this);
	}
	public boolean checkDescription() {
		System.out.println(pdtDescription.getText());
		return elementFound(pdtDescription);
	}
	public boolean checkTweet() {
		return elementFound(tweet);
	}
	public boolean checkShare() {
		return elementFound(share);
	}
}
