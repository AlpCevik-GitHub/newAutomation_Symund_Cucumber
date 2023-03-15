package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Symund_Logout_Webpage {
    public Symund_Logout_Webpage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[@id=\"expanddiv\"]/ul/li[4]/a")
    public WebElement logOut;

    @FindBy(xpath = "//*[@id=\"expand\"]/div[1]/img")
    public WebElement E_Button;
}
