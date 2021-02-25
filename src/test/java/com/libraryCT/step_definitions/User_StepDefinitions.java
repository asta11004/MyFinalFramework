package com.libraryCT.step_definitions;

import com.libraryCT.pages.LoginPage;
import com.libraryCT.pages.UsersPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class User_StepDefinitions {

    UsersPage userPage = new UsersPage();



    @Given("I'm on the User Management page")
    public void i_m_on_the_user_management_page() {
       userPage.usersModule.click();
    }

    @Then("I should see {int} records on the page")
    public void i_should_see_records_on_the_page(int expectedCount) {
     expectedCount = 10;
     String actual = userPage.defaultRecords.getText();
    int act=Integer.parseInt(actual);
        Assert.assertTrue(expectedCount==act);
    }

    @Then("I can see count records on the page")
    public void i_can_see_count_records_on_the_page(List<String> expectedList) {

    Select selectDropdown= new Select(userPage.recordDropdown);
    List<WebElement> listAsWebElement= selectDropdown.getOptions();
    List<String> listAsString= new ArrayList<>();

        for (WebElement each : listAsWebElement) {
            listAsString.add(each.getText());
        }

       Assert.assertTrue(listAsString.equals(expectedList));
    }

    @When("I click on records")
    public void iClickOnRecords() {
        userPage.recordDropdown.click();
    }

    @Then("the user should see the following column names")
    public void the_user_should_see_the_following_column_names(List<String> expectedColumnNames) {
        List<String> actualTableNames = new ArrayList<>();

        for (WebElement each : userPage.tableColumns) {
            actualTableNames.add(each.getText());
        }
      Assert.assertTrue(actualTableNames.equals(expectedColumnNames));
    }

    @Given("the user click Status dropdown")
    public void the_user_click_status_dropdown() {
      userPage.statusDropdown.click();
    }

    @Then("the user should see the following options")
    public void the_user_should_see_the_following_options(List<String> expectedResult) {

      Select select = new Select(userPage.statusDropdown) ;
        List<String> actualResult = new ArrayList<>();
       List< WebElement> webList= select.getOptions();
        for (WebElement each : webList) {
            actualResult.add(each.getText());
        }
        Assert.assertTrue(expectedResult.equals(actualResult));
    }

}
