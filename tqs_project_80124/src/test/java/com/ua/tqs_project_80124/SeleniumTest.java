package com.ua.tqs_project_80124;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSelenium() throws Exception {
    driver.get("http://localhost:8082/");
    driver.findElement(By.xpath("//button[@id='next_day_button']/span")).click();
    driver.findElement(By.xpath("//button[@id='next_day_button']/span")).click();
    driver.findElement(By.xpath("//button[@id='next_day_button']/span")).click();
    driver.findElement(By.xpath("//button[@id='previous_day_button']/span")).click();
    driver.findElement(By.name("localidade")).click();
    driver.findElement(By.name("localidade")).clear();
    driver.findElement(By.name("localidade")).sendKeys("Porto");
    driver.findElement(By.xpath("//button[@id='next_day_button']/span")).click();
    driver.findElement(By.name("localidade")).click();
    driver.findElement(By.name("localidade")).clear();
    driver.findElement(By.name("localidade")).sendKeys("Lisboa");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cities'])[1]/following::i[1]")).click();
    driver.findElement(By.xpath("//button[@id='next_day_button']/span")).click();
    driver.findElement(By.xpath("//button[@id='next_day_button']/span")).click();
    driver.findElement(By.name("localidade")).click();
    driver.findElement(By.name("localidade")).clear();
    driver.findElement(By.name("localidade")).sendKeys("Porto");
    driver.findElement(By.name("localidade")).sendKeys(Keys.ENTER);
    driver.findElement(By.id("next_day_button")).click();
    driver.findElement(By.id("next_day_button")).click();
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
