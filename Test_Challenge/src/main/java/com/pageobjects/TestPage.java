package com.pageobjects;

import org.openqa.selenium.By;

public class TestPage {

	public By getFirstNumberInput()
	{
		return By.id("mat-input-0");
	}
	
	public By getSecondNumberInput()
	{
		return By.id("mat-input-1");
	}
	
	public By getResultField()
	{
		return By.id("mat-input-2");
	}
	
	public By getTextSearchField()
	{
		return By.id("mat-input-3");
	}
	
	public By getUniconFoundElement()
	{
		return By.xpath("//div[@class='ng-star-inserted']");
	}
	
	public By getBattleStartBtn()
	{
		return By.xpath("//button[.='Let the battle begin']");
	}
 
	public By getBattleDialog()
	{
		return By.tagName("mat-dialog-container");
	}
	
	public By getTargets()
	{
		return By.xpath("//div[@class='arena']//i");
	}
}
