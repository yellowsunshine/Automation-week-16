package com.automationpractice.testsuite;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.SummerDressesPage;
import com.automationpractice.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SummerDressesPriceRangeTest extends TestBase {

    HomePage homePage;
    SummerDressesPage summerDressesPage;

    @BeforeMethod(groups = {"smoke","sanity", "regression"})
    public void init1() {
        homePage = new HomePage();
        summerDressesPage = new SummerDressesPage();
    }

    @Test(groups = {"smoke", "regression"})
    public void updatedSearchResultsAfterChangingPriceRange(){
        //Select Women Category from the main menu
        homePage.selectItemFromMainMenu("Women");
        //Select summer dresses from the submenu
        homePage.selectItemsFromWomensMenu("Summer Dresses");
        //verify the summer dresses page
        summerDressesPage.verifySummerDressesPageVerificationText("SUMMER DRESSES ");
        //move the slider to change the price range
        summerDressesPage.moveSliderToChangePrice();
        //search results are updated
        //items returned are within the price range

    }


}
