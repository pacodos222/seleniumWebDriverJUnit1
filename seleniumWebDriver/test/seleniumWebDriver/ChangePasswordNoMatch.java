package seleniumWebDriver;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ChangePasswordNoMatch {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testChangePasswordNoMatch() throws Exception {
    driver.get("https://logappf1hmis2018.azurewebsites.net/");
    driver.findElement(By.xpath("//a[contains(@href, '/Account/Login')]")).click();
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("mgl958@inlumine.ual.es");
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys("123456Aa.");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("Hello mgl958@inlumine.ual.es!")).click();
    driver.findElement(By.linkText("Password")).click();
    driver.findElement(By.id("OldPassword")).click();
    driver.findElement(By.id("OldPassword")).clear();
    driver.findElement(By.id("OldPassword")).sendKeys("Contraseña-1");
    driver.findElement(By.id("NewPassword")).click();
    driver.findElement(By.id("NewPassword")).clear();
    driver.findElement(By.id("NewPassword")).sendKeys("Contraseña-2");
    driver.findElement(By.id("ConfirmPassword")).click();
    driver.findElement(By.id("ConfirmPassword")).clear();
    driver.findElement(By.id("ConfirmPassword")).sendKeys("Contraseña-3");
    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    assertTrue(isElementPresent(By.id("ConfirmPassword-error")));
    driver.findElement(By.xpath("//button[@type='submit']")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
