package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.functions.TestChallenge;

public class TargetValidateTest extends BaseTest {

    @Test(priority = 1)
    public void testVerifyUserCanSeeBattleDialogWithOneValidAndOtherTargets() {
        TestChallenge test = new TestChallenge(getDriver());
        test.clickBattleBeginButton();
        Assert.assertEquals(String.valueOf(test.getTagetCountOnBattleDialog(false)), "8","Target is incorrect");
        Assert.assertEquals(String.valueOf(test.getTagetCountOnBattleDialog(true)), "1","Target is incorrect");
    }

    @Test(priority = 2)
    public void testVerifyValidTargetAlwaysChangesItsPosition() {
        TestChallenge test = new TestChallenge(getDriver());
        test.refreshPage(); //refresh the page to reset if previous test outcomes still exist
        test.clickBattleBeginButton();
        int currentPosition = test.getValidTargetPositionOnBattleDialog();
        test.refreshPage(); //refresh the page to reset if previous test outcomes still exist
        test.clickBattleBeginButton();

        //check previous position and latest position is different
        Assert.assertNotEquals(String.valueOf(test.getValidTargetPositionOnBattleDialog()), String.valueOf(currentPosition),"Target is not changed");
    }

    @Test(priority = 3)
    public void testVerifyUserClicksInvalidTarget() {
        TestChallenge test = new TestChallenge(getDriver());
        test.refreshPage(); //refresh the page to reset if previous test outcomes still exist
        test.clickBattleBeginButton();

        //sets false to click invalid target
        test.clickTargetOnBattleDialog(false);
        Assert.assertTrue(test.isBattleDialogDisplayed(),"Battle Dialog is closed");
    }

    @Test(priority = 4)
    public void testVerifyClicksValidTargetAndBattleDialogClosed() {
        TestChallenge test = new TestChallenge(getDriver());
        test.refreshPage(); //refresh the page to reset if previous test outcomes still exist
        test.clickBattleBeginButton();

        //sets true to click invalid target
        test.clickTargetOnBattleDialog(true);
        Assert.assertFalse(test.isBattleDialogDisplayed(),"Battle Dialog is not closed");
    }

    @Test(priority = 5)
    public void testVerifyPopupNotClosingWhenHitEscape() {
        TestChallenge test = new TestChallenge(getDriver());
        test.refreshPage(); //refresh the page to reset if previous test outcomes still exist
        test.clickBattleBeginButton();

        //sets true to click invalid target
        test.pressEscapeKey();
        Assert.assertTrue(test.isBattleDialogDisplayed(),"Battle Dialog is closed");
    }
}
