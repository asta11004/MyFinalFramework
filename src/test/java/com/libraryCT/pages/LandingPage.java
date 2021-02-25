package com.libraryCT.pages;

import com.libraryCT.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage { // Base Page in Asiya's requirements

    public LandingPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(id= "user_count")
    public WebElement userCount;


}
