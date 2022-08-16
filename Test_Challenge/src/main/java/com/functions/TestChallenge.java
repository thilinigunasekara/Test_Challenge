package com.functions;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.base.BasePage;
import com.base.PropertyReader;
import com.pageobjects.TestPage;

public class TestChallenge extends BasePage{

	private TestPage testPg = new TestPage();

	public TestChallenge(WebDriver driver) {
		super(driver);
	}

	/**
	 * Enter Calculation Values
	 * @param value1, value2
	 * @return TestChallenge
	 */
	public TestChallenge enterCalculationValues(String value1, String value2)
	{
		try {
			WebElement valEle1 = waitElementToBeVisible(testPg.getFirstNumberInput());

			enterNumber(valEle1, value1);

			WebElement valEle2 = waitElementToBeVisible(testPg.getSecondNumberInput());

			enterNumber(valEle2, value2);

			log("Entered Vlaue 1 = " + String.valueOf(value1) + " and Value 2 = " + String.valueOf(value2));

			return this;
		} catch (Exception e) {
			log("Failed to Enter Values");
			return this;
		}
	}

	/**
	 * Returns Result Value
	 * @return String
	 */
	public String getResultsValue()
	{
		try {
			String valResult = waitElementToBeVisible(testPg.getResultField()).getAttribute("value");
			log("Result = " + valResult);
			return valResult;
		} catch (Exception e) {
			log("Failed to Get Result Value");
			return "";
		}
	}

	/**
	 * Searches Unicorn Name
	 * @param searchText
	 * @return TestChallenge
	 */
	public TestChallenge searchUnicornName(String searchText)
	{
		try {
			WebElement searchTxt = waitElementToBeVisible(testPg.getTextSearchField());

			enterText(searchTxt, searchText);
			enterText(searchTxt, Keys.ENTER);

			log("Entered Search Text = " + searchText);

			return this;
		} catch (Exception e) {
			log("Failed to Enter Search Text");
			return this;
		}
	}

	/**
	 * Returns whether unicorn's name returns for search result
	 * @param unicornName
	 * @return boolean
	 */
	public boolean isUnicornNameFound(String unicornName)
	{
		boolean flag = false;
		try {
			flag = waitElementToBeVisible(testPg.getUniconFoundElement())
					.getText().toLowerCase().contains(unicornName.toLowerCase());
			log("Unicorn Name Returned = " + flag);
			return flag;
		} catch (Exception e) {
			log("Failed to Get Result Unicorn Name");
			return flag;
		}
	}

	/**
	 * Clicks Let the battle begin button
	 * @return TestChallenge
	 */
	public TestChallenge clickBattleBeginButton()
	{
		try {
			WebElement button = waitElementToBeVisible(testPg.getBattleStartBtn());

			clickByJavascriptExecutor(button);

			log("Clicked Let the Battle Begin Button");

			return this;
		} catch (Exception e) {
			log("Failed to Click Let the Battle Begin Button");
			return this;
		}
	}

	/**
	 * Returns target counts on Battle Dialog
	 * @param isValidTarget
	 * @return Integer
	 */
	public Integer getTagetCountOnBattleDialog(boolean isValidTarget)
	{
		int positveCounter = 0;
		int negativeCounter = 0;
		
		PropertyReader prop = new PropertyReader();

		try {
			if(waitElementToBeVisible(testPg.getBattleDialog()).isDisplayed())
			{
				List<WebElement> targets = waitElementsToBeVisible(testPg.getTargets());

				for (WebElement trgt : targets)
				{					
					if(trgt.getAttribute("style").contains(prop.getDataProp().getProperty("style")))
						positveCounter += 1;
					else
						negativeCounter += 1;
				}
			}

			if(isValidTarget)
			{
				log("Valid Target Count = " + positveCounter);
				return positveCounter;
			}
			else
			{
				log("Invalid Target Count = " + negativeCounter);
				return negativeCounter;
			}

		} catch (Exception e) {
			log("Failed to Extract Taget Count");
			return 0;
		}
	}

	/**
	 * Clicks on a target on Battle Dialog
	 * @param isToClickValidTarget
	 * @return TestChallenge
	 */
	public TestChallenge clickTargetOnBattleDialog(boolean isToClickValidTarget)
	{
		PropertyReader prop = new PropertyReader();
		
		try {
			if(waitElementToBeVisible(testPg.getBattleDialog()).isDisplayed())
			{
				List<WebElement> targets = waitElementsToBeVisible(testPg.getTargets());

				for (WebElement trgt : targets)
				{					
					if(trgt.getAttribute("style").contains(prop.getDataProp().getProperty("style")) 
							&& isToClickValidTarget)
					{
						clickByJavascriptExecutor(trgt);
						log("Clicked Valid Target Orange");
						break;
					}
					else if(!trgt.getAttribute("style").contains(prop.getDataProp().getProperty("style")) 
							&& !isToClickValidTarget) 
					{
						clickByJavascriptExecutor(trgt);
						log("Clicked Invalid Target Not Orange");
						break;
					}
				}
			}

			return this;
		} catch (Exception e) {
			log("Failed to Click Any Target On Battle Dialog");
			return this;
		}
	}
	
	/**
	 * Returns position of the valid target
	 * @return Integer
	 */
	public Integer getValidTargetPositionOnBattleDialog()
	{
		PropertyReader prop = new PropertyReader();
		int position = 0;
		
		try {
			if(waitElementToBeVisible(testPg.getBattleDialog()).isDisplayed());
			{
				List<WebElement> targets = waitElementsToBeVisible(testPg.getTargets());

				for (WebElement trgt : targets)
				{
					position += 1;
					
					if(trgt.getAttribute("style").contains(prop.getDataProp().getProperty("style"))) 
					{
						log("Valid Target Position = " + String.valueOf(position));
						break;
					}
				}
			}
			return position;
		} catch (Exception e) {
			log("Failed to Get Valid Target Position On Battle Dialog");
			return position;
		}
	}

	/**
	 * Returns whether Battle Dialog is displayed
	 * @return boolean
	 */
	public boolean isBattleDialogDisplayed()
	{
		boolean flag = false;

		try {
			flag = waitElementToBeVisible(testPg.getBattleDialog()).isDisplayed();
			log("Battle Dialog Display = " + flag);

			return flag;
		} catch (Exception e) {
			log("Battle Dialog Display = " + flag);
			return flag;
		}
	}
	
	/**
	 * Hits Escape Key
	 */
	public TestChallenge pressEscapeKey()
	{
		try {
			getActions().sendKeys(Keys.ESCAPE).build().perform();
			log("Hit the Escape Key");

			return this;
		} catch (Exception e) {
			log("Error while hitting Escape Key");
			return this;
		}
	}
}
