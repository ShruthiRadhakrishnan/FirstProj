package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects extends BasePage{

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/a")
	private WebElement womenTab;
	
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
	private WebElement dressesTab;
	
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[3]/a")
	private WebElement tshirtsTab;
	
	@FindBy(xpath = "//h1/span[@class='cat-name']")
	private WebElement navigationTab;

	@FindBy(id = "newsletter-input")
	private WebElement textBox;
	
	@FindBy(xpath = "//*[@class='alert alert-success']")
	private WebElement alertSuccess;
		
	@FindBy(xpath = "//button[@name='submitNewsletter']")
	private WebElement enter;
	
	@FindBys(@FindBy(xpath = "//ul[@id='homefeatured']/li/div"))
	private List<WebElement> products;
	
	@FindBys(@FindBy(xpath = "//ul[@id='homefeatured']/li/div//a/span[text()='Add to cart']"))
	private List<WebElement> cartButtons;
	
	@FindBy(xpath = ".//*[@id='homefeatured']/li[1]/div")
	private WebElement firstPdt;
	
	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}
	public boolean checkWomenTab() {
		return elementFound(womenTab);
	}
	public boolean checkDressesTab() {
		return elementFound(dressesTab);
	}
	public boolean checkTshirtsTab() {
		return elementFound(tshirtsTab);
	}
	public void clickWomen() {
		womenTab.click();
	}
	public void clickDresses() {
		dressesTab.click();
	}
	public void clickTshirts() {
		tshirtsTab.click();
	}
	public void clickFirstPdt() {
		firstPdt.click();
	}
	public boolean navToWomen() {		
		if(navigationTab.getText().contains("WOMEN")) {
			System.out.println(navigationTab.getText());
		}
		return elementFound(navigationTab);
	}
	public boolean navToDresses() {		
		if(navigationTab.getText().contains("DRESSES")) {
			System.out.println(navigationTab.getText());
		}
		return elementFound(navigationTab);
	}
	public boolean navToTshirts() {
		if(navigationTab.getText().contains("T-SHIRTS")) {
			System.out.println(navigationTab.getText());
		}
		return elementFound(navigationTab);
	}
	public void setValue() {
		setText(textBox, "test" + Math.round(Math.floor(Math.random()*1000)) + "@gmail.com");
		System.out.println(textBox.getAttribute("value"));
		enter.click();
	}
	public boolean getAlert() {
		return isElementVisible(alertSuccess);
	}
	public boolean checkCartButton() {
		Actions ac = new Actions(driver);
		for(WebElement a : products) {
			ac.moveToElement(a);
			elementFound(cartButtons.get(0));
		}
		return true;
	}
}
