package com.libraryCT.step_definitions;

import com.libraryCT.pages.LandingPage;
import com.libraryCT.pages.LoginPage;
import com.libraryCT.utilities.ConfigurationReader;
import com.libraryCT.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Login_StepDefinition {

    LoginPage loginPage = new LoginPage();  // Object of the login page created
    LandingPage landingPage = new LandingPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("I am on the login page")
    public void user_is_on_the_login_page(){
        String url = ConfigurationReader.getProperty("qa2_url");
        Driver.getDriver().get(url);
    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian(){
        String username = ConfigurationReader.getProperty("lib15_user");
        String password = ConfigurationReader.getProperty("lib15_pass");

        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.signInButton.click();

    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() throws InterruptedException{
        String expected = "dashboard";

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.urlContains(expected));
        String actual = Driver.getDriver().getCurrentUrl();
        System.out.println("actual= "+actual);

        Assert.assertTrue(actual.contains(expected));

        Driver.closeDriver();

    }


    @When("I login as a student")
    public void iLoginAsAStudent() {
        String username = ConfigurationReader.getProperty("stu98_user");
        String password = ConfigurationReader.getProperty("stu98_pass");

        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.signInButton.click();
    }

    @Then("books should be displayed")
    public void booksShouldBeDisplayed() {
        String expected = "books";

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.urlContains(expected));
        String actual = Driver.getDriver().getCurrentUrl();
        System.out.println("actual= "+actual);

        Assert.assertTrue(actual.contains(expected));

        Driver.closeDriver();
    }

    @When("I enter username {string}")
    public void i_enter_username(String string1) {
        String username = string1;
        loginPage.usernameInput.sendKeys(username);
    }

    @When("I enter password {string}")
    public void i_enter_password(String string2) {
        String password = string2;
        loginPage.passwordInput.sendKeys(password);

    }
    @When("click the sign in button")
    public void click_the_sign_in_button() {
        loginPage.signInButton.click();

    }
    @Then("there should be {int} user")
    public void there_should_be_user(Integer int1) {
        int expectedUserNumber = int1;
        wait.until(ExpectedConditions.visibilityOf(landingPage.userCount));

        String expected = String.valueOf(expectedUserNumber);
        String actual = landingPage.userCount.getText();

        Assert.assertEquals("Actual user number is not as expected!", actual, expected);

    }

}
