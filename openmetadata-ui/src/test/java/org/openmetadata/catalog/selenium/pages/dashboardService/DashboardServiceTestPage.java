/*
 *  Copyright 2021 Collate 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.openmetadata.catalog.selenium.pages.dashboardService;

import com.github.javafaker.Faker;
import io.github.artsok.RepeatedIfExceptionsTest;
import org.openmetadata.catalog.selenium.events.Events;
import org.openmetadata.catalog.selenium.properties.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Order(9)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DashboardServiceTestPage {
  static WebDriver webDriver;
  static String url = Property.getInstance().getURL();
  static Faker faker = new Faker();
  static String serviceName = faker.name().firstName();
  static String enterDescription = "//div[@data-testid='enterDescription']/div/div[2]/div/div/div/div/div/div";
  static Actions actions;
  static WebDriverWait wait;
  Integer waitTime = Property.getInstance().getSleepTime();

  @BeforeEach
  public void openMetadataWindow() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/linux/chromedriver");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    webDriver = new ChromeDriver(options);
    actions = new Actions(webDriver);
    wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
    webDriver.manage().window().maximize();
    webDriver.get(url);
  }

  @RepeatedIfExceptionsTest(repeats = 2)
  @Order(1)
  public void openDashboardServicePage() throws InterruptedException {
    Events.click(webDriver, By.cssSelector("[data-testid='closeWhatsNew']")); // Close What's new
    Events.click(webDriver, By.cssSelector("[data-testid='menu-button'][id='menu-button-Settings']")); // Setting
    Events.click(webDriver, By.cssSelector("[data-testid='menu-item-Services']")); // Setting/Services
    Events.click(webDriver, By.xpath("(//button[@data-testid='tab'])[3]"));
    Thread.sleep(waitTime);
  }

  @RepeatedIfExceptionsTest(repeats = 2)
  @Order(2)
  public void addDashboardService() throws InterruptedException {
    openDashboardServicePage();
    Thread.sleep(2000);
    List<WebElement> webElementList = webDriver.findElements(By.cssSelector("[data-testid='add-new-user-button']"));
    if (webElementList.isEmpty()) {
      Events.click(webDriver, By.cssSelector("[data-testid='add-service-button']"));
    } else {
      Events.click(webDriver, By.cssSelector("[data-testid='add-new-user-button']"));
    }
    Events.click(webDriver, By.cssSelector("[value='Looker']"));
    Events.sendKeys(webDriver, By.cssSelector("[data-testid='name']"), serviceName);
    Events.sendKeys(webDriver, By.cssSelector("[data-testid='dashboard-url']"), "http://localhost:8080");
    Events.sendKeys(webDriver, By.cssSelector("[data-testid='username']"), faker.name().firstName());
    Events.sendKeys(webDriver, By.cssSelector("[data-testid='password']"), faker.name().firstName());

    Events.click(webDriver, By.cssSelector("[data-testid='boldButton']"));
    Events.sendKeys(webDriver, By.xpath(enterDescription), faker.address().toString());
    Events.click(webDriver, By.xpath(enterDescription));
    Events.sendEnter(webDriver, By.xpath(enterDescription));
    Events.click(webDriver, By.cssSelector("[data-testid='italicButton']"));
    Events.sendKeys(webDriver, By.xpath(enterDescription), faker.address().toString());
    Events.click(webDriver, By.xpath(enterDescription));
    Events.sendEnter(webDriver, By.xpath(enterDescription));
    Events.click(webDriver, By.cssSelector("[data-testid='linkButton']"));
    Events.sendKeys(webDriver, By.xpath(enterDescription), faker.address().toString());
    Events.click(webDriver, By.cssSelector("[data-testid='save-button']"));
  }

  @RepeatedIfExceptionsTest(repeats = 2)
  @Order(3)
  public void editDashboardService() throws InterruptedException {
    openDashboardServicePage();
    Thread.sleep(2000);
    Events.click(webDriver, By.cssSelector("[data-testid='edit-service-"+ serviceName + "']"));
    Events.click(webDriver, By.xpath(enterDescription));
    Events.sendEnter(webDriver, By.xpath(enterDescription));
    Events.sendKeys(webDriver, By.xpath(enterDescription), faker.address().toString());
    Events.click(webDriver, By.cssSelector("[data-testid='save-button']"));
  }

  @RepeatedIfExceptionsTest(repeats = 2)
  @Order(4)
  public void checkDashboardServiceDetails() throws InterruptedException {
    openDashboardServicePage();
    Thread.sleep(2000);
    Events.click(webDriver, By.cssSelector("[data-testid='service-name-" + serviceName + "']"));
    Thread.sleep(waitTime);
    Events.click(webDriver, By.cssSelector("[data-testid='description-edit']"));
    Events.click(webDriver, By.xpath(enterDescription));
    Events.sendEnter(webDriver, By.xpath(enterDescription));
    Events.sendKeys(webDriver, By.xpath(enterDescription), faker.address().toString());
    Events.click(webDriver, By.cssSelector("[data-testid='save']"));
  }

  @RepeatedIfExceptionsTest(repeats = 2)
  @Order(5)
  public void searchDashboardService() throws InterruptedException {
    openDashboardServicePage();
    Thread.sleep(2000);
    Events.click(webDriver, By.cssSelector("[data-testid='service-name-"+ serviceName + "']"));
  }

  @RepeatedIfExceptionsTest(repeats = 2)
  @Order(6)
  public void deleteDashboardService() throws InterruptedException {
    openDashboardServicePage();
    Thread.sleep(2000);
    Events.click(webDriver, By.cssSelector("[data-testid='delete-service-"+ serviceName + "']"));
    Events.click(webDriver, By.cssSelector("[data-testid='save-button']"));
  }

  @AfterEach
  public void closeTabs() {
    ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
    String originalHandle = webDriver.getWindowHandle();
    for (String handle : webDriver.getWindowHandles()) {
      if (!handle.equals(originalHandle)) {
        webDriver.switchTo().window(handle);
        webDriver.close();
      }
    }
    webDriver.switchTo().window(tabs.get(0)).close();
  }
}