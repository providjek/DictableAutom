package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pagesObjects.home.HomePage;

public class LoginStep {
    private final HomePage homePage = new HomePage();

    @Then("I am logged with {string} in and redirected to the home page")
    public void iMLoggedInAndRedirectedToTheHomePage( String mail) {
        this.homePage.waitVisibility(this.homePage.getEmailPlaceholder());
        Assert.assertTrue(this.homePage.getContentOfEmailPlaceholder().contains(mail), "Le texte du paragraphe ne contient "+mail);

    }

    @When("I log with my {string} and {string}")
    public void iLogWithMyAnd(String email, String pass) throws InterruptedException {
        this.homePage.fillLoginForm(email, pass);
    }

    @Then("The connection fails and I receive the message {string}")
    public void theConnectionFailsAndIReceiveTheMessageMessage(String message) {
        this.homePage.waitVisibility(this.homePage.getLoginErrorPlaceholder());
        Assert.assertTrue(this.homePage.getTextLoginErrorPlaceholder().contains(message));
    }

    @When("I connect to my google account")
    public void iConnectToMyGoogleAccount() {
     this.homePage.clickOnLogSbmtBtn();
    }
}
