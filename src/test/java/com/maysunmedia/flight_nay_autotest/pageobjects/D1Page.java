package com.maysunmedia.flight_nay_autotest.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D1Page extends BasePage{
	@FindBy(how=How.XPATH,xpath="//div[@ng-bind-html='df1a_data.state']")
	private WebElement delayDiv;
	@FindBy(how=How.XPATH,xpath=".//*[@id='cf12a']//div[@class='CF12-main']")
	private WebElement leftDataDiv;
	private WebDriver driver;
	public D1Page(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	//当前出港航班延误情况
	public String getAllFlightsDelayOrNot(){
		//等待
		new WebDriverWait(driver,10).until(
			new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver arg0) {
					return delayDiv.isDisplayed();					
				}
			});
		return delayDiv.getText();
	}
	public void getAllFlightsData(){
		System.out.println(leftDataDiv.findElements(By.tagName("ul")).size());
		List<WebElement> rows=leftDataDiv.findElements(By.tagName("ul"));
		for(WebElement row:rows){
			List<WebElement> cols=row.findElements(By.tagName("li"));
			for(WebElement col:cols){
					System.out.print(col.getAttribute("textContent").toString()+"\t");
				
			}
			System.out.println();
		}
		
		
	}
}