package com.libraryCT.pages;

import com.libraryCT.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UsersPage {

    public UsersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//option[@value='10']")
    public WebElement defaultRecords;

    @FindBy(xpath = "//i[@class='fa fa-user']//../span[1]")
    public WebElement usersModule;

    @FindBy(xpath = "//*[@id=\"tbl_users_length\"]/label/select")
    public WebElement recordDropdown;

    @FindBy(xpath = "//table[@id='tbl_users']//thead//th")
    public List<WebElement> tableColumns;

    @FindBy(id= "user_status")
    public WebElement statusDropdown;

}
