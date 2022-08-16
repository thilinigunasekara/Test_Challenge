package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.functions.TestChallenge;

public class UnicornSearchTest extends BaseTest {

    @Test(priority = 0)
    public void testVerifyUnicornNameReturnedIfPartOfNameEnteredLowerCase() {
        TestChallenge test = new TestChallenge(getDriver());
        test.searchUnicornName(prop.getProperty("unicornName_lowerCase"));
        Assert.assertTrue(test.isUnicornNameFound(prop.getProperty("expectedName")),"Unicorn name is not returned");
    }

    @Test(priority = 1)
    public void testVerifyUnicornNameReturnedIfPartOfNameEnteredAllCaps() {
        TestChallenge test = new TestChallenge(getDriver());
        test.searchUnicornName(prop.getProperty("unicornName_upperCase"));
        Assert.assertTrue(test.isUnicornNameFound(prop.getProperty("expectedName")),"Unicorn name is not returned");
    }

    @Test(priority = 2)
    public void testVerifyUnicornNameReturnedIfPartOfNameEnteredSentenceCaps() {
        TestChallenge test = new TestChallenge(getDriver());
        test.searchUnicornName(prop.getProperty("unicornName_partiallyUpperCase"));
        Assert.assertTrue(test.isUnicornNameFound(prop.getProperty("expectedName")),"Unicorn name is not returned");
    }

    @Test(priority = 3)
    public void testVerifyUnicornNameNotReturnedIfPartOfNamePartiallyEntered() {
        TestChallenge test = new TestChallenge(getDriver());
        test.searchUnicornName(prop.getProperty("unicornName_partialName"));
        Assert.assertFalse(test.isUnicornNameFound(prop.getProperty("expectedName")),"Unicorn name returned");
    }

    @Test(priority = 4)
    public void testVerifyUnicornNameNotReturnedIfPartOfNameEnteredWithSpaces() {
        TestChallenge test = new TestChallenge(getDriver());
        test.searchUnicornName(prop.getProperty("unicornName_withSpace"));
        Assert.assertFalse(test.isUnicornNameFound(prop.getProperty("expectedName")),"Unicorn name returned");
    }

    @Test(priority = 5)
    public void testVerifyUnicornNameNotReturnedIfNoNameEntered() {
        TestChallenge test = new TestChallenge(getDriver());
        test.searchUnicornName("");
        Assert.assertFalse(test.isUnicornNameFound(prop.getProperty("expectedName")),"Unicorn name returned");
    }

    @Test(priority = 6)
    public void testVerifyUnicornNameNotReturnedIfTextContainsEnteredPartOfName() {
        TestChallenge test = new TestChallenge(getDriver());
        test.searchUnicornName(prop.getProperty("unicornName_partiallyIncorrect"));
        Assert.assertFalse(test.isUnicornNameFound(prop.getProperty("expectedName")),"Unicorn name returned");
    }

    @Test(priority = 7)
    public void testVerifyUnicornNameNotReturnedIfEntirelyInvalidTextEntered() {
        TestChallenge test = new TestChallenge(getDriver());
        test.searchUnicornName(prop.getProperty("unicornName_invalid"));
        Assert.assertFalse(test.isUnicornNameFound(prop.getProperty("expectedName")),"Unicorn name returned");
    }
    @Test(priority = 8)
    public void testVerifyUnicornNameReturnedIfSearchBySecondName() {
        TestChallenge test = new TestChallenge(getDriver());
        test.searchUnicornName(prop.getProperty("unicornName_secondName"));
        Assert.assertTrue(test.isUnicornNameFound(prop.getProperty("expectedName")),"Unicorn name is not returned");
    }
    @Test(priority = 9)
    public void testVerifyUnicornNameReturnedIfSearchByFulName() {
        TestChallenge test = new TestChallenge(getDriver());
        test.searchUnicornName(prop.getProperty("unicornName_fullName"));
        Assert.assertTrue(test.isUnicornNameFound(prop.getProperty("expectedName")),"Unicorn name is not returned");
    }
    @Test(priority = 10)
    public void testVerifyUnicornNameNotReturnedIfEnterTheInvalidCharacter() {
        TestChallenge test = new TestChallenge(getDriver());
        test.searchUnicornName(prop.getProperty("unicornName_invalidCharacter"));
        Assert.assertFalse(test.isUnicornNameFound(prop.getProperty("expectedName")),"Unicorn name returned");
    }
    @Test(priority = 10)
    public void testVerifyUnicornNameNotReturnedIfEnterTheNumbers() {
        TestChallenge test = new TestChallenge(getDriver());
        test.searchUnicornName(prop.getProperty("unicornName_numbers"));
        Assert.assertFalse(test.isUnicornNameFound(prop.getProperty("expectedName")),"Unicorn name returned");
    }
}
