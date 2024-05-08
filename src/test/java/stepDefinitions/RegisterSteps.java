package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pagesObjects.home.HomePage;

public class RegisterSteps {
    private final HomePage homePage = new HomePage();

  /*  @Given("I am on the registration section")
    public void iAmOnTheRegistrationSection() throws InterruptedException {
        this.homePage.openRegisterSection("registration");
    }
*/
    @When("I fill in my {string} and {string} details")
    public void iFillInMyAndDetails(String email, String pass) {
        this.homePage.fillRegisterForm(email, pass);
    }

    @When("I fill in my false {string} {string}  and {string} details")
    public void iFillInMyAndDetailsFalse(String email, String pass, String confPass) {
        this.homePage.fillRegisterForm(email, pass, confPass);
    }

    @Then("I am registered and logged in with my address {string}")
    public void iAmRegisteredAndLoggedInWithMyAddress(String mail) {
            this.homePage.waitVisibility(this.homePage.getEmailPlaceholder());
            Assert.assertTrue(this.homePage.getContentOfEmailPlaceholder().contains(mail), "Le texte du paragraphe ne contient "+mail);
    }

    @Then("Registration fails and I receive the message {string}")
    public void registrationFailsAndIReceiveTheMessage(String errorMsg) {
        this.homePage.waitVisibility(this.homePage.getRegisterErrorPlaceholder());
        Assert.assertTrue(this.homePage.getTextRegisterErrorEmailExisting().contains(errorMsg));
    }

    @When("I register with my google account")
    public void iRegisterWithMyGoogleAccount() {
    }

    @Then("I am redirected to the google login page")
    public void iAmRedirectedToTheGoogleLoginPage() {
        this.homePage.clickOnGoogleLogin();

    }

/*

    @DataTableType
    public RegisterForm registerForm(Map<String, String> data) {
        return new LoginForm(
                data.get("email"),
                data.get("password")
        );
*/


}
