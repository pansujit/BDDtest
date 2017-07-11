package Utility.mobile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import amazon.StartApplication;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyUtility {
	
	public AndroidDriver  driver;
	
	
	public MyUtility(AndroidDriver  ldriver){
		this.driver=ldriver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	private WebElement createXpath(AndroidDriver driver,String path){
		return driver.findElement(By.xpath(path));	
	}
	
	public void clickWebElement(AndroidDriver driver,String path){
		try{
			createXpath(driver,path).click();
			System.out.println("Clicked xpath:"+"'"+path+"'");
						
		}catch(Exception e){
			System.out.println("Error On clicking xpath:"+"'"+path+"'");
			e.printStackTrace();
		}
	}
	
	public void TypeText(AndroidDriver driver,String text,String inputText){
		try{
			//createXpath(driver,text).clear();
			//createXpath(driver,inputText).click();
			createXpath(driver,text).sendKeys(inputText);
			System.out.println("Typed:"+" "+inputText+" "+"in"+" "+"xpath:"+"'"+text+"'");
			
		}catch(Exception e){
			System.out.println("Error on typing text:"+" "+inputText+" "+"in"+" "+"xpath:"+"'"+text+"'");
			e.printStackTrace();
		}
	}
	public void TypeText(AndroidDriver driver,String text,Keys inputText){
		try{
			//createXpath(driver,text).clear();
			//createXpath(driver,inputText).click();
			createXpath(driver,text).sendKeys(inputText);
			System.out.println("Typed:"+" "+inputText+" "+"in"+" "+"xpath:"+"'"+text+"'");
			
		}catch(Exception e){
			System.out.println("Error on typing text:"+" "+inputText+" "+"in"+" "+"xpath:"+"'"+text+"'");
			e.printStackTrace();
		}
	}
	
	public void waitToPresenceOfElementToBePresent(AndroidDriver driver,String path,int time){
		new WebDriverWait(driver, time).until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
		
	}
	public String getText(AndroidDriver driver, String text){
		return createXpath(driver,text).getText().toString();
	}
	
	public void tappedInScreen(AndroidDriver driver, int x, int y){
		driver.tap(1, x, y,200);

	}
	public boolean checkIfElementExist(AndroidDriver driver, String path){
		boolean test= false;
		try{
			test= createXpath(driver,path).isDisplayed();
			System.out.println("the xpath:"+" "+path+ " "+ "is exist");
			return test;
		}catch(Exception e){
			System.out.println("the xpath:"+" "+path+ " "+ "is exist");
			return test;
		}
		
	}

}
