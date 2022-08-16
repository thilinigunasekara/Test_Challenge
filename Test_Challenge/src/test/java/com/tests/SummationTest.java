package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.base.BaseTest;
import com.functions.TestChallenge;

public class SummationTest extends BaseTest{
	
	@Test (priority = 1)
	public void testVerifyResultWhenFirstValuesBlank()
	{
		TestChallenge test = new TestChallenge(getDriver());
		
		test.enterCalculationValues("", prop.getProperty("summation_validNumber"));
		
		Assert.assertEquals(test.getResultsValue(), prop.getProperty("summation_validNumber"));
	}
	
	@Test (priority = 2)
	public void testVerifyResultWhenSecondValues_Blank()
	{
		TestChallenge test = new TestChallenge(getDriver());
		
		test.enterCalculationValues(prop.getProperty("summation_validNumber"), "");
		
		Assert.assertEquals(test.getResultsValue(), prop.getProperty("summation_validNumber"));
	}
	
	@Test (priority = 3)
	public void testVerifyResultWhenBothValuesBlank()
	{
		TestChallenge test = new TestChallenge(getDriver());
		
		test.enterCalculationValues("", "");
		
		Assert.assertEquals(test.getResultsValue(), prop.getProperty("summation_expectedNumberInvalid"));
	}
	
	@Test (priority = 4)
	public void testVerifyResultWhenBothValuesPositive()
	{
		TestChallenge test = new TestChallenge(getDriver());
		
		test.enterCalculationValues(prop.getProperty("summation_validNumber"), prop.getProperty("summation_validSecondNumber"));
		
		Assert.assertEquals(test.getResultsValue(),prop.getProperty("summation_firstExpectedNumber") );
	}
	
	@Test (priority = 5)
	public void testVerifyResultWhenFirstValueNegative()
	{
		TestChallenge test = new TestChallenge(getDriver());
		
		test.enterCalculationValues(prop.getProperty("summation_minusNumber"), prop.getProperty("summation_validNumber"));
		
		Assert.assertEquals(test.getResultsValue(), prop.getProperty("summation_secondExpectedNumber"));
	}
	
	@Test (priority = 6)
	public void testVerifyResultWhenSecondValueNegative()
	{
		TestChallenge test = new TestChallenge(getDriver());
		
		test.enterCalculationValues(prop.getProperty("summation_validNumber"), prop.getProperty("summation_minusNumber"));

		Assert.assertEquals(test.getResultsValue(), prop.getProperty("summation_secondExpectedNumber"));
	}
	
	@Test (priority = 7)
	public void testVerifyResultWhenBothValuesDecimal()
	{
		TestChallenge test = new TestChallenge(getDriver());
		
		test.enterCalculationValues(prop.getProperty("summation_firstDecimalNumber"), prop.getProperty("summation_secondDecimalNumber"));
		
		Assert.assertEquals(test.getResultsValue(), prop.getProperty("summation_expectedDecimalNumber"));
	}
	

	@Test (priority = 8)
	public void testVerifyResultWhenFirstValueIntegerAndSecondValueDecimal()
	{
		TestChallenge test = new TestChallenge(getDriver());
		
		test.enterCalculationValues(prop.getProperty("summation_validNumber"), prop.getProperty("summation_secondDecimalNumber"));
		
		Assert.assertEquals(test.getResultsValue(), prop.getProperty("summation_secondExpectedDecimalNumber"));
	}
	
	@Test (priority = 9)
	public void testVerifyResultWhenFirstValueDecimalAndSecondValueInteger()
	{
		TestChallenge test = new TestChallenge(getDriver());

		test.enterCalculationValues(prop.getProperty("summation_secondDecimalNumber"), prop.getProperty("summation_validNumber"));

		Assert.assertEquals(test.getResultsValue(), prop.getProperty("summation_secondExpectedDecimalNumber"));
	}
	
	@Test (priority = 10)
	public void testVerifyResultWhenCalculatingLongIntegerValues()
	{
		TestChallenge test = new TestChallenge(getDriver());

		test.enterCalculationValues(prop.getProperty("summation_firstLongNumber"), prop.getProperty("summation_secondLongNumber"));

		Assert.assertEquals(test.getResultsValue(), prop.getProperty("summation_expectedLongNumber"));
	}
	@Test (priority = 11)
	public void testVerifyResultWhenEnterTheTextValue()
	{
		TestChallenge test = new TestChallenge(getDriver());

		test.enterCalculationValues(prop.getProperty("summation_firstString"), prop.getProperty("summation_secondString"));

		Assert.assertEquals(test.getResultsValue(), prop.getProperty("summation_expectedNumberInvalid"));
	}

}
