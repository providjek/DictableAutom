package pagesObjects.profiles;

import io.cucumber.datatable.DataTable;
import lombok.Getter;
import managers.WebDrivenSingleton;
import models.forms.UserForm;
import models.object.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagesObjects.Page;

import java.time.Duration;
import java.util.List;
import java.util.Map;

@Getter
public class ProfilesPage extends Page {

    @FindBy(id = "lastName")
    private WebElement lName;
    @FindBy(id = "firstName")
    private WebElement fName;
    @FindBy(id = "address")
    private WebElement address;
    @FindBy(id = "phone")
    private WebElement phone;
    @FindBy(id = "addressFacturation")
    private  WebElement addressFacturation;
    @FindBy(id = "addressLivraison")
    private WebElement addressLivraison;
    @FindBy(id = "civility")
    private  WebElement civility;
    @FindBy(css = ".style_btn2__0wrea")
    private WebElement updateBtn;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div/div[2]/div/div[2]/div[1]/div/form/button")
    private WebElement updatePassBtn;
    @FindBy(css = ".ant-notification-notice-message")
    private WebElement popupUpdate;
    @FindBy(css = "#menu- li:nth-of-type(1)")
    private WebElement mrChooseCivility;
    @FindBy(css = "#menu- li:nth-of-type(2)")
    private WebElement mrsChooseCivility;

    @FindBy(id = "menu-")
    private WebElement menuCivility;
    @FindBy(css = "#filled-adornment-password")
    private List<WebElement> inputPassOldAndNew;






    private WebDriver driver = WebDrivenSingleton.getInstance();
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));



    /*
    * Click On Section
    * */

    public void clickOnCivility(){
        super.clickOn(this.civility);
    }

    public void clickOnMrChoose(){
        super.clickOn(this.mrChooseCivility);
    }

    public void clickOnMrsChoose(){
        super.clickOn(this.mrsChooseCivility);
    }






    public void writeOnfName(String name){
        super.writeText(this.fName, name);
    }
    public void writeOnlName(String lName){
        super.writeText(this.lName, lName);
    }
    public  void writeOnAddres(String address){
        super.writeText(this.address, address);
    }
    public  void writeOnPhone(String phone){
        super.writeText(this.phone, phone);
    }
    public  void writeOnAddressFacturation(String facAddress){
        super.writeText(this.addressFacturation, facAddress);
    }
    public  void writeOnAddressDelivery(String delivAdd){
        super.writeText(this.addressLivraison, delivAdd);
    }



    /****
     *
     * Write Section in input WebElement
     */




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

    public void fillProfilForm(UserForm userForm)  {
        /*Map<String, String> dataList = dataTable.asMaps(String.class, String.class).get(0);
        UserForm userForm = new UserForm();
        userForm.buildFromDatableCucumber(dataList);*/
        this.writeOnlName(userForm.getLName());
        this.writeOnfName(userForm.getFName());
        this.writeOnAddres(userForm.getAddress());
        this.writeOnAddressFacturation(userForm.getBilingAddres());
        this.writeOnAddressDelivery(userForm.getDeliveryAddres());
        this.writeOnPhone(userForm.getPhone());
        this.chooseCivility(userForm.getTitle());
        super.clickOn(this.updateBtn);

    }

    public void  fillUpdatePass(String newPass, String oldPass ){
        super.writeText(this.inputPassOldAndNew.get(0), oldPass);
        super.writeText(this.inputPassOldAndNew.get(1), newPass);

        super.clickOn(this.updatePassBtn);

    }
    public void chooseCivility(String civility){
        this.clickOnCivility();
        if (civility=="Monsieur"){
            this.clickOnMrChoose();
        }else{
            this.clickOnMrsChoose();
        }
    }

}
