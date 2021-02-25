package com.libraryCT.pages;

import com.libraryCT.utilities.ConfigurationReader;
import com.libraryCT.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement usernameInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;

    public void loginLibrarian(){
        String url = ConfigurationReader.getProperty("qa2_url");
        Driver.getDriver().get(url);
        String username = ConfigurationReader.getProperty("lib15_user");
        String password = ConfigurationReader.getProperty("lib15_pass");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButton.click();

    }
}