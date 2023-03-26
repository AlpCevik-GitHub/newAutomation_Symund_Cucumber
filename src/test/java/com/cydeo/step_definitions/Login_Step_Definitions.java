package com.cydeo.step_definitions;

import com.cydeo.pages.Symund_WebPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Map;

public class Login_Step_Definitions {
    Symund_WebPage webPage = new Symund_WebPage();
    String userName = "";
    String passWord = "";

    /* @Given("user is on the Symund login page")
     public void user_is_on_the_symund_login_page() {

         Driver.getDriver().get(ConfigurationReader.getProperty("environment"));
     }*/
    @Given("user is on the Symund login page")
    public void user_is_on_the_symund_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("environment"));
    }

    @When("user enters employee username in username field")
    public void user_enters_employee_in_username_field(Map<String, String> username) {
        webPage.inputUsername.sendKeys(username.get("username"));
    }

    @When("user enters employee password in  password field")
    public void user_enters_employee_password_in_password_field(Map<String, String> password) {
        webPage.inputPassword.sendKeys(password.get("password"));
    }

    @When("user hit the enter")
    public void user_hit_the_enter() {

        webPage.logInButton.sendKeys(Keys.ENTER);
    }

    @When("user click the login button")
    public void user_click_the_login_button() {

        webPage.logInButton.click();
    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {

        String expected = "Set status";
        String actual = webPage.setStatus.getText().trim();
        Assert.assertEquals(expected, actual);

    }

    @When("user enters employee {string} and {string}")
    public void user_enters_employee_and(String username, String password) {
        if (!username.isEmpty()) {
            webPage.inputUsername.sendKeys(username);
            userName = username;
            passWord="";
        } else if (!password.isEmpty()) {
            webPage.inputPassword.sendKeys(password);
            passWord = password;
            userName="";
        }

    }


    @Then("user should see wrong message")
    public void user_should_see_wrong_message() {
        String expected = "Wrong username or password.";
        String actual = webPage.wrongMessage.getText();
        Assert.assertEquals(expected, actual);

    }


    @Then("user should see Please fill out this field message")
    public void user_should_see_please_fill_out_this_field_message() {
        String expected = "Please fill out this field.";
        if (userName.isEmpty()) {
            String actual = webPage.userFillOutMessage.getAttribute("validationMessage");
            Assert.assertEquals(expected, actual);
            System.out.println(actual);
        } else if (passWord.isEmpty()) {
            String actual = webPage.passwordFillOutMessage.getAttribute("validationMessage");
            Assert.assertEquals(expected, actual);
            System.out.println(actual);
        }


    }


    @When("user can see Forgot password? link")
    public void user_can_see_forgot_password_link() {
        String expected = "Forgot password?";
        String actual = webPage.forgotPasswordLink.getText();
        Assert.assertEquals(expected, actual);

    }

    @When("user click on forget password link")
    public void user_click_on_forget_password_link() {

        webPage.forgotPasswordLink.click();
    }

    @Then("user can see the Reset Password button on the next page")
    public void user_can_see_the_reset_password_button_on_the_next_page() {
        String expected = "Reset password";
        String actual = webPage.resetButton.getAttribute("value");
        Assert.assertEquals(expected, actual);

    }

    @When("User can see the password in a form of dots by default")
    public void user_can_see_the_password_in_a_form_of_dots_by_default() {
        String expected = "password";
        String actual = webPage.inputPassword.getAttribute("type");
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
    }

    @When("user click explicitly image to see password")
    public void user_click_explicitly_image_to_see_password() {
        webPage.explicitPasswordImg.click();
    }


    @Then("user  can see password explicitly")
    public void user_can_see_password_explicitly() {

        String expected = "text";
        String actual = webPage.inputPassword.getAttribute("type");
        Assert.assertEquals(expected, actual);
        System.out.println(actual);


        System.out.println("webPage.inputPassword.getAttribute(\"type\") = " + webPage.inputPassword.getAttribute("type"));


    }


    @When("User can see valid placeholders on Username and Password fields")
    public void user_can_see_valid_placeholders_on_username_and_password_fields() {
        String expected = "Username or email";
        String actual = webPage.placeHolderUserName.getAttribute("placeholder");
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
        String expected1 = "Password";
        String actual1 = webPage.placeHolderPassword.getAttribute("placeholder");
        Assert.assertEquals(expected1, actual1);
        System.out.println(actual1);
    }

    @When("user enters employee as a {string} and {string}")
    public void userEntersEmployeeAsAAnd(String username, String password) {
        webPage.inputUsername.sendKeys(username);
        webPage.inputPassword.sendKeys(password);


    }
}
