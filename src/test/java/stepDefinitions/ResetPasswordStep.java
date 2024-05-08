package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pagesObjects.resetPassword.ResetPassPage;

public class ResetPasswordStep {

    private final ResetPassPage resetPassPage = new ResetPassPage();

    @When("I fill in reset form with {string} and {string}")
    public void iFillInResetFormWithAnd(String email, String pass) {
        this.resetPassPage.fillResetPasswordForm(email, pass);
    }

    @Then("The password is reset  and I receive this confirmation alert {string}")
    public void thePasswordIsResetAndIReceiveThisConfirmationAlert(String message) {
        //Assert.assertTrue(this.resetPassPage.checkPasswordReset(message));
        this.resetPassPage.waitVisibility(this.resetPassPage.getPopupMessage());
    }

    @When("I fill in reset form with non-existent account {string} and {string}")
    public void iFillInResetFormWithNonExistentAccountAnd(String email, String pass) {
        this.resetPassPage.fillResetPasswordForm(email, pass);
    }

    @Then("The reset failed with the following error message {string}")
    public void theResetFailedWithTheFollowingErrorMessage(String message) {
        this.resetPassPage.waitVisibility(this.resetPassPage.getErrorMessageResetPass());
        Assert.assertTrue(this.resetPassPage.getResetErrorText().contains(message));
    }
}
