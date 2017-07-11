package amazon;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Utility.mobile.MyUtility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class StartApplication {
	
	WebDriver mydriver;
	public AndroidDriver<WebElement> driver;
	MyUtility myUtility;
	public StartApplication(){
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), MyUtility.class);
		
	}
	@Test
	public void phraseBook() throws InterruptedException, MalformedURLException{
		beforeTest();
		
		driver.findElement(By.className("android.widget.ImageButton")).click();
		
		Thread.sleep(2000);
		//myUtility.clickWebElement("//*[@text='Phrasebook']");
		Thread.sleep(2000);
		List<WebElement>  targetLangList= driver.findElements(By.id("com.systran.ready2go:id/lang"));
		for(WebElement element:targetLangList ){
			if(element.getText().toString().equalsIgnoreCase("French")){
				element.click();
				break;
			}	
		}
		Thread.sleep(2000);
		
		driver.quit();
	}
	
	
	public void quitProgram(){
		driver.quit();	
	}
	
	public void beforeTest() throws MalformedURLException, InterruptedException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		capabilities.setCapability("deviceName", "Samsung Galaxy s4");
		//capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("app", app.getAbsolutePath());
		//capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		//capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		 //capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		capabilities.setCapability("appPackage", "com.systran.ready2go");
		capabilities.setCapability("appActivity", ".activities.SplashActivity");
		
		 //capabilities.setCapability("appActivity", ".Calculator");
		//capabilities.setCapability("browserName", "chrome");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//driver.get("http://www.tothenew.com/contact-us");
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(10000);
	}
	
	
/*	@Test
	public void launchApplication() throws MalformedURLException, InterruptedException{

		try{
		
		//driver.get("http://www.wgwgwgwg.com");
		
			beforeTest();
		//driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_02")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_03")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();
		//Thread.sleep(2000);
		//System.out.println(driver.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc")).getText().toString());
		//driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		//Thread.sleep(2000);
		//Thread.sleep(2000);
		//driver.findElement(By.id("com.systran.ready2go:id/areYouLivingConfirmButton")).click();
		//Thread.sleep(2000);
		//Thread.sleep(2000);
		driver.findElement(By.className("android.widget.ImageButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@text='Translator']")).click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		
		WebElement sourceDropDown= driver.findElement(By.id("com.systran.ready2go:id/source_lang"));
		sourceDropDown.click();
		Thread.sleep(2000);
		
		List<WebElement>  sourceLangList= driver.findElements(By.id("com.systran.ready2go:id/lang"));
		System.out.println("hello " +sourceLangList.size());
		
		for(WebElement element:sourceLangList ){
			if(element.getText().toString().equalsIgnoreCase("English")){
				element.click();
				break;
			
			}
		}
		Thread.sleep(2000);
		System.out.println("hello! I am here");
		WebElement targetDropDown= driver.findElement(By.id("com.systran.ready2go:id/target_lang"));
		targetDropDown.click();
		Thread.sleep(2000);
		List<WebElement>  targetLangList= driver.findElements(By.id("com.systran.ready2go:id/lang"));
		for(WebElement element:targetLangList ){
			if(element.getText().toString().equalsIgnoreCase("French")){
				element.click();
				break;
			}	
		}
		
		
		
		 
		 Thread.sleep(2000);
		 
		 //inputSourceText.clear();
		 WebElement inputSourceText= driver.findElement(By.id("com.systran.ready2go:id/source"));
		inputSourceText.click();
		 inputSourceText.sendKeys("hello");
		 System.out.println("I am pressing 6");
		// driver.pressKeyCode(AndroidKeyCode.KEYCODE_TAB);
		// driver.pressKeyCode(66);
		TouchAction action= new TouchAction(driver);
		driver.tap(1, 1000, 1780, 500);
		//action.tap(1000,1780);
		 Thread.sleep(2000);
		 WebElement outputText=driver.findElement(By.id("com.systran.ready2go:id/target"));
		 Assert.assertTrue(outputText.getText().toString().equalsIgnoreCase("bonjour"), "The output of hello is not equal to bonjour");
		 
		}catch(Exception ex){
			System.out.println("error on handling");
				System.out.println(ex.getMessage());
			}
		
		
				
 
	}*/
	

	


}
