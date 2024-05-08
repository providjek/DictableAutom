package stepDefinitions;

import enums.EndpointEnums;
import io.cucumber.java.en.Given;
import managers.WebDrivenSingleton;
import org.openqa.selenium.WebDriver;
import pagesObjects.home.HomePage;

public class PageNavigationSteps {
    private final HomePage homePage = new HomePage();
    protected WebDriver driver = WebDrivenSingleton.getInstance();

    @Given("^I am on the ([^\"]*) section$")
    public void iAmOnTheSection(String section) {
        this.homePage.openRegisterSection(section);
    }

    @Given("^I am on the ([^\"]*) page$")
    public void iAmOnThePasswordPage(EndpointEnums endpoint) {
        WebDrivenSingleton.navigateTo(endpoint.getEndpoint());
    }
}
