package com.automationpractice.testsuite;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.SummerDressesPage;
import com.automationpractice.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SummerDressesOptionTest extends TestBase {
    HomePage homePage;
    SummerDressesPage summerDressesPage;

    @BeforeMethod(groups = {"smoke","sanity", "regression"})
    public void init1() {
        homePage = new HomePage();
        summerDressesPage = new SummerDressesPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void viewSummerDressesOptionFromTheNavigationMenu(){
        //Select Women Category from the main menu
        homePage.selectItemFromMainMenu("Women");
        //Select summer dresses from the submenu
        homePage.selectItemsFromWomensMenu("Summer Dresses");
        //verify the summer dresses page
        summerDressesPage.verifySummerDressesPageVerificationText("SUMMER DRESSES ");
    }
}
