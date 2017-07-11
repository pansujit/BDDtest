package test.method;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.mobile.MyUtility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import test.locators.LocatorsInMobile;

public class CommonMethod {
	  public AndroidDriver driver;
	  MyUtility myUtility= new MyUtility(driver);
	  
	  public CommonMethod(AndroidDriver ldriver){
		  this.driver=ldriver;
	  }
	  
	  
	 public void clickOnMainMenu(){
		 myUtility.clickWebElement(driver,LocatorsInMobile.mainMenu);
	 }
	 public void clickOnHeyParisMenu(){
		 myUtility.clickWebElement(driver,LocatorsInMobile.heyParisMenu);
	 }
	 public void waitForPresence(String text, int num){
		 myUtility.waitToPresenceOfElementToBePresent(driver, text, num); 
	 }
	 public void typeOnSourceInputText(String pathText,String inputText){
		 myUtility.TypeText(driver, pathText, inputText);
	 }
	 public void typeOnSourceInputText(String pathText,Keys inputText){
		 myUtility.TypeText(driver, pathText, inputText);
	 }
	 public String getText(String path){
		 return myUtility.getText(driver, path);
	 }
	 public void tappedToscreen(int x, int y){
		 myUtility.tappedInScreen(driver, x, y);
	 }
	 private void waitTime(){
		 try{
		 Thread.sleep(5000);
		 }catch(Exception ex){
			 ex.printStackTrace();
		 }
	 }
	
	public void testMe(){
		clickOnMainMenu();	
		clickOnHeyParisMenu();
		waitForPresence(LocatorsInMobile.sourceInputField,15);
		typeOnSourceInputText(LocatorsInMobile.sourceInputField,"Hello"+"\n");// it is working prototype
		//tappedToscreen(1000,1800);
		//typeOnSourceInputText(LocatorsInMobile.sourceInputField,"Hello");
		//driver.pressKeyCode(AndroidKeyCode.FLAG_EDITOR_ACTION );
		waitTime();
		//driver.pressKeyCode(66);
		waitForPresence(LocatorsInMobile.outputTargetField,10);
		System.out.println(getText(LocatorsInMobile.outputTargetField));
		myUtility.clickWebElement(driver, LocatorsInMobile.favouriteMenuInHeyParis);
		myUtility.clickWebElement(driver,LocatorsInMobile.targetMenu);
		waitForPresence(LocatorsInMobile.learnMore,10);
		myUtility.clickWebElement(driver,LocatorsInMobile.learnMore);
		waitForPresence( LocatorsInMobile.CheckDictionaryInHeyParis,10);
		System.out.println(myUtility.checkIfElementExist(driver, LocatorsInMobile.CheckDictionaryInHeyParis));
		
		waitTime();
		System.out.println("hi" +myUtility.checkIfElementExist(driver, LocatorsInMobile.helloExpandIconInNounInHeyParis));
		myUtility.clickWebElement(driver,LocatorsInMobile.helloExpandIconInNounInHeyParis);
		System.out.println(getText(LocatorsInMobile.sourceWord));
		
		waitTime();
		System.out.println("hello" +myUtility.checkIfElementExist(driver, LocatorsInMobile.helloExpandIconInIntjInHeyParis));
		myUtility.clickWebElement(driver,LocatorsInMobile.helloExpandIconInIntjInHeyParis);
		System.out.println(getText(LocatorsInMobile.sourceWord));
	}
}
