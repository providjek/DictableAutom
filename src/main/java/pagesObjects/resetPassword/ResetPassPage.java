package pagesObjects.resetPassword;

import lombok.Getter;
import managers.WebDrivenSingleton;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagesObjects.Page;

import java.time.Duration;

@Getter
public class ResetPassPage extends Page {


    @FindBy(id = "email_reset_pass")
    private WebElement emailInput;
    @FindBy(id = "reset_password")
    private WebElement passInput;
    @FindBy(id = "btn_reset_password")
    private WebElement resetBtn;
    @FindBy(css = ".style_messageError__LxTAG")
    private WebElement errorMessageResetPass;

    @FindBy(css = "#style_container_P9Oh0 p")
    private WebElement popupMessage;

    private WebDriver driver = WebDrivenSingleton.getInstance();
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));



    /*
    * Click On Section
    * */

    public void clickOnresetBtn(){
        super.clickOn(this.resetBtn);
    }


    /****
     *
     * Write Section in input WebElement
     */

    public void writeEmail(String email){
        super.writeText(this.emailInput, email);
    }
    public void writePassword(String pass){
        super.writeText(this.passInput, pass);
    }


    public void fillResetPasswordForm(String email, String pass){
        this.writeEmail(email);
        this.writePassword(pass);
        this.clickOnresetBtn();
    }

    //Récupérer le texte de l'alerte
    public boolean checkPasswordReset(String message){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        if (alertText.contains(message)) {
            return true;
        } else {
            return false;
        }
    }

    public String getResetErrorText(){
        return this.errorMessageResetPass.getText();
    }

}
