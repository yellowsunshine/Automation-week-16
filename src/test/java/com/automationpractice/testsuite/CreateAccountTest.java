package com.automationpractice.testsuite;

import com.automationpractice.pages.AuthenticationPage;
import com.automationpractice.pages.CreateAccountPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.MyAccountPage;
import com.automationpractice.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;


public class CreateAccountTest extends TestBase {

    HomePage homePage;
    AuthenticationPage authenticationPage;
    CreateAccountPage createAccountPage;
    MyAccountPage myAccountPage;

    @BeforeMethod(groups = {"smoke","sanity", "regression"})
    public void init1() {
        homePage = new HomePage();
        authenticationPage = new AuthenticationPage();
        createAccountPage = new CreateAccountPage();
        myAccountPage = new MyAccountPage();
    }

    @Test(groups = {"sanity", "regression"},dataProvider = "Valid Credentials", dataProviderClass = TestData.class)
    public void customerCanCreateANewAccountUsingValidDetails
            (String name, String surname, String password,
             String address, String city, String state,
             String postcode, String mobileNumber,
             String message, String accountName){

        //click on the sign-in button from the homepage
        homePage.clickOnSignInButton();
        //enter an email address in email address field
        authenticationPage.enterRandomEmailInTheEmailAddressField();
        //click on create an account tab
        authenticationPage.clickOnCreateAnAccountTab();
        //fill all mandatory fields
        createAccountPage.fillMandatoryFields(name, surname, password, address, city, state, postcode, mobileNumber );
        //click on register
        createAccountPage.clickOnRegister();
        //verify my account text
        createAccountPage.verifyMyAccountText(message);
        // verify user can see his account name on top right
        myAccountPage.verifyUserCanSeeAccountNameOnTopRight(accountName);
    }

    @Test(groups = {"smoke", "regression"},dataProvider = "Invalid Credentials", dataProviderClass = TestData.class)
    public void userWillGetAnErrorMessageWhileCreatingAccountWithInvalidDetails
            (String name, String surname, String password,
             String address, String city, String state,
             String postcode, String mobileNumber,
             String message){
        //click on the sign-in button from the homepage
        homePage.clickOnSignInButton();
        //enter an email address in email address field
        authenticationPage.enterRandomEmailInTheEmailAddressField();
        //click on create an account tab
        authenticationPage.clickOnCreateAnAccountTab();
        //fill all mandatory fields
        createAccountPage.fillMandatoryFields(name, surname, password, address, city, state, postcode, mobileNumber );
        //click on register
        createAccountPage.clickOnRegister();
        //verify that invalid information will give an error message
        createAccountPage.verifyErrorMessage(message);

    }


}
