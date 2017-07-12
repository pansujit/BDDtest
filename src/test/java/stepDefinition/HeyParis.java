package stepDefinition;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import Utility.mobile.MyUtility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import test.locators.LocatorsInMobile;
import io.appium.java_client.android.AndroidDriver;
public class HeyParis {
	  private String reportDirectory = "reports";
	  private String reportFormat = "xml";
	  private String testName = "Untitled";
	  public AndroidDriver driver;
	  DesiredCapabilities dc ;
	  MyUtility myUtility= new MyUtility(driver);
	  
	  public HeyParis(AndroidDriver ldriver){
		  this.driver=ldriver;
	  }
	  public HeyParis(){
		
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
	  
	  
	  
	@Given("^User should have apk installed$")
	public void User_should_have_apk_installed() throws Throwable {
	      dc = new DesiredCapabilities();
	      dc.setCapability("reportDirectory", reportDirectory);
	      dc.setCapability("reportFormat", reportFormat);
	      dc.setCapability("testName", testName);
	      dc.setCapability(MobileCapabilityType.UDID, "ce011711a4f314880c");
	      dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.systran.ready2go");
	      dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".activities.SplashActivity");
	     
	    
	}

	@Given("^launched the app$")
	public void launched_the_app() throws Throwable {
		 driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
	    
	}


	@When("^Click on the main menu on the left tip side$")
	public void Click_on_the_main_menu_on_the_left_tip_side() throws Throwable {
		clickOnMainMenu();	
	   
	}

	@When("^Click on the 'Hey Paris' menu$")
	public void Click_on_the_Hey_Paris_menu() throws Throwable {
		clickOnHeyParisMenu();
		waitForPresence(LocatorsInMobile.sourceInputField,15);
	}

	@Then("^'Hey paris' should be displayed on the top$")
	public void _Hey_paris_should_be_displayed_on_the_top() throws Throwable {
		myUtility.assertIgnoreCaseText(myUtility.getText(driver, LocatorsInMobile.AssertHeaderHeyParis),"Hey Paris");
	    
	   
	}

	@When("^User tapped on the source input field$")
	public void User_tapped_on_the_source_input_field() throws Throwable {

	}

	@When("^type the text 'hello' and send enter key.$")
	public void type_the_text_hello_and_send_enter_key() throws Throwable {
		typeOnSourceInputText(LocatorsInMobile.sourceInputField,"Hello"+"\n");
		waitTime();
	   
	}

	@Then("^In the target field 'bonjour' should be displayed$")
	public void In_the_target_field_bonjour_should_be_displayed() throws Throwable {
		myUtility.assertIgnoreCaseText(getText(LocatorsInMobile.outputTargetField),"bonjour");
	   
	}

	@When("^click on the favourite icon$")
	public void click_on_the_favourite_icon() throws Throwable {
		myUtility.clickWebElement(driver, LocatorsInMobile.favouriteMenuInHeyParis);
	}

@Then("^the Icon should be changed 'light green'$")
public void the_Icon_should_be_changed_light_green() throws Throwable {
	Set availableContexts =  driver.getContextHandles();
	List<String> handleList= new ArrayList(availableContexts);
	for(int i=0;i<handleList.size();i++){
		System.out.println(handleList.get(i));
	}
	System.out.println("Total No of Context Found After we reach to WebView = "+driver.getContext());
   
}

	@When("^click on the Expand Icon$")
	public void click_on_the_Expand_Icon() throws Throwable {
		myUtility.clickWebElement(driver,LocatorsInMobile.targetMenu);
		
	   
	}

	@Then("^'learn more' text page should be appear$")
	public void _learn_more_text_page_should_be_appear() throws Throwable {
		waitForPresence(LocatorsInMobile.learnMore,10);
	   
	}
	
	@When("^Click on the 'learn more page'$")
	public void Click_on_the_learn_more_page() throws Throwable {
		myUtility.clickWebElement(driver,LocatorsInMobile.learnMore);
		waitForPresence( LocatorsInMobile.CheckDictionaryInHeyParis,10);
	   
	}

@Then("^Translator page should be displayed$")
public void Translator_page_should_be_displayed() throws Throwable {
    // Express the Regexp above with the code you wish you had
   
}

	@Then("^dictionary item should be displayed$")
	public void dictionary_item_should_be_displayed() throws Throwable {
		waitForPresence( LocatorsInMobile.CheckDictionaryInHeyParis,10);
		System.out.println(myUtility.checkIfElementExist(driver, LocatorsInMobile.CheckDictionaryInHeyParis));
	   
	}
	@When("^Click on the 'hello\\(noun\\)' expand button$")
	public void click_on_the_hello_noun_expand_button() throws Throwable {
		waitTime();
		System.out.println("hi" +myUtility.checkIfElementExist(driver, LocatorsInMobile.helloExpandIconInNounInHeyParis));
		myUtility.clickWebElement(driver,LocatorsInMobile.helloExpandIconInNounInHeyParis);
	}


	@Then("^'pl:hello' should be displayed$")
	public void _pl_hello_should_be_displayed() throws Throwable {
		System.out.println(getText(LocatorsInMobile.sourceWord));
	   
	}

	@When("^Click on the 'hello\\(intj\\)' expand button$")
	public void Click_on_the_hello_intj_expand_button() throws Throwable {
		waitTime();
		System.out.println("hello" +myUtility.checkIfElementExist(driver, LocatorsInMobile.helloExpandIconInIntjInHeyParis));
		myUtility.clickWebElement(driver,LocatorsInMobile.helloExpandIconInIntjInHeyParis);
		
	   
	}

	@Then("^'bonjour' should be displayed.$")
	public void _bonjour_should_be_displayed() throws Throwable {
		System.out.println(getText(LocatorsInMobile.sourceWord));
	   
	}

	
	
	
	

}
