package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.forms.UserForm;
import models.object.User;
import org.testng.Assert;
import pagesObjects.profiles.ProfilesPage;

import java.util.List;
import java.util.Map;

public class ProileManageStep {

    private final ProfilesPage profilesPage = new ProfilesPage();

    @When("I update my personal informations")
    public void iUpdateMyPersonalInformations( UserForm buildUserForm) {

        this.profilesPage.fillProfilForm(buildUserForm);
        System.out.println(buildUserForm);
    }

    @DataTableType
    public UserForm buildUserForm(Map<String, String> data) throws IllegalAccessException {
         UserForm userForm= new UserForm();
         userForm.buildFromDatableCucumber(data);
         return userForm;
    }


    @Then("I can see the message {string} confirming the update")
    public void iCanSeeTheMessageConfirmingTheUpdate(String message) {
        this.profilesPage.waitVisibility(this.profilesPage.getPopupUpdate());
        Assert.assertTrue(this.profilesPage.getPopupUpdate().getText().contains(message));
    }

    @When("I change my old password {string} with the new one {string}")
    public void iChangeMyOldPasswordWithTheNewOne(String oldPass, String newPass) {
        this.profilesPage.fillUpdatePass(newPass, oldPass);

    }
}
