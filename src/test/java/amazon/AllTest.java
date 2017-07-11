package amazon;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import test.method.CommonMethod;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.mobile.MyUtility;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import java.net.URL;
import java.net.MalformedURLException;

public class AllTest {
  private String reportDirectory = "reports";
  private String reportFormat = "xml";
  private String testName = "Untitled";
  public AndroidDriver driver;
  
  @BeforeTest
  public void setUp() throws MalformedURLException {
      DesiredCapabilities dc = new DesiredCapabilities();
      dc.setCapability("reportDirectory", reportDirectory);
      dc.setCapability("reportFormat", reportFormat);
      dc.setCapability("testName", testName);
      dc.setCapability(MobileCapabilityType.UDID, "ce011711a4f314880c");
      dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.systran.ready2go");
      dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".activities.SplashActivity");
      driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
  }
  
  @Test
  public void testUntitled() {
	  CommonMethod commonMethod= new CommonMethod(driver);
	  	  PageFactory.initElements(new AppiumFieldDecorator(driver), CommonMethod.class);
	  	  commonMethod.testMe();
	    }
  
  
  @AfterTest
  public void tearDown() {
      driver.quit();
  }
}
