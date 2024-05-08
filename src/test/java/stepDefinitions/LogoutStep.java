package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pagesObjects.home.HomePage;

public class LogoutStep {
    private  final HomePage homePage = new HomePage();


    @Given("I'm connected")
    public void iMConnected() {
        Assert.assertTrue(this.homePage.isLogged());
    }

    @When("I log out")
    public void iLogOut() {
        this.homePage.clickOnAvatarIcon();
        this.homePage.clickOnLogoutBtn();
    }

    @Then("I am logged out and redirected to the home page")
    public void iAmLoggedOutAndRedirectedToTheHomePage() {
        Assert.assertTrue(this.homePage.isLogout());
    }
}
