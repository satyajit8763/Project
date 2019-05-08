package com.pacs.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 extends BaseTest {
	String expectedPageTitle="CoraAnalytics";

	@Test
	public void test() throws InterruptedException {
		pageSync(2);
		driver.findElement(By.xpath("//button[contains(@class,'dropdown')]")).click();
		pageSync(2);
		driver.findElement(By.xpath("//a[text()='Administrator']")).click();
		driver.findElement(By.xpath("//input[@name='username' ]")).sendKeys("coraAdmin");
		driver.findElement(By.xpath("//input[@name='password' ]")).sendKeys("admin");
		
		driver.findElement(By.xpath("//button[contains(@class,'loginButton')]")).click();
		pageSync(2);
		System.err.println("The page title is : "+driver.getTitle());
		String actualPageTitle=driver.getTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
		System.out.println("Page Title Varified");
		
	}
}
