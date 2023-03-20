package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Symund_WebPage {


    public Symund_WebPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user")
    public WebElement inputUsername;
    @FindBy(id = "password")
    public WebElement inputPassword;
    @FindBy(id = "submit-form")
    public WebElement logInButton;
    @FindBy(id = "lost-password")
    public WebElement forgotPasswordLink;
    @FindBy(id = "reset-password-submit")
    public WebElement resetButton;
    @FindBy(xpath = "//*[@id=\"body-login\"]/div[1]/div/main/div/div/form/fieldset/p[3]")
    public WebElement wrongMessage;
    @FindBy(xpath = "//button[contains(@class,'user-status')]")
    public WebElement setStatus;

    @FindBy(xpath = "//*[@name='user']")

    public WebElement userFillOutMessage;
    @FindBy(xpath = "//*[@name='password']")
    public WebElement passwordFillOutMessage;
    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement placeHolderPassword;
    @FindBy(xpath = "//input[@placeholder='Username or email']")
    public WebElement placeHolderUserName;

    @FindBy(xpath = "//img[@alt='Toggle password visibility']")
    public WebElement explicitPasswordImg;

    public void login(String username, String password) {
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        logInButton.click();
    }


}
