package pagesObjects.home;

import lombok.Getter;
import managers.WebDrivenSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagesObjects.Page;

import java.time.Duration;
import java.util.regex.Pattern;

@Getter
public class HomePage extends Page {

    @FindBy(id = "style_avatar_wrapper__pEGIQ")
    private WebElement avatarIcon;
    @FindBy(css = ".MuiButtonBase-root.MuiTab-root.MuiTab-textColorPrimary.css-1ihvf6b:nth-of-type(2)")
    private WebElement registerBtn;
    @FindBy(css = ".MuiButtonBase-root.MuiTab-root.MuiTab-textColorPrimary.css-1ihvf6b:nth-of-type(1)")
    private WebElement loginBtn;
    @FindBy(id = "email_register")
    private WebElement emailInput;
    @FindBy(id = "password_register")
    private WebElement passInput;
    @FindBy(id = "confirm_password_register")
    private WebElement confPassInput;
    @FindBy(id = "btn_register")
    private WebElement subRegisterBtn;
    @FindBy(css = "#style_header_navBar__hdNqL p")
    private WebElement emailPlaceholder;
    @FindBy(css = "#style_content_form__i3W8L .style_messageError__mbzDa")
    private WebElement registerErrorPlaceholder;
    @FindBy(id = "email_login")
    private WebElement emailLogInput;
    @FindBy(id = "password_login")
    private WebElement passLogInput;
    @FindBy(id = "btn_login")
    private WebElement loginSbmtBtn;
    @FindBy(css = "#style_content_form__i3W8L .style_messageError__mbzDa")
    private WebElement loginErrorPlaceholder;
    @FindBy(css = ".style_btn_google__VJRHE")
    private WebElement googleBtn;

    @FindBy(xpath = "//*[@id=\"simple-popover\"]/div[3]/ul/li[7]")
    private WebElement logoutBtn;

    private WebDriver driver = WebDrivenSingleton.getInstance();
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));



    /*
    * Click On Section
    * */
    public void clickOnAvatarIcon(){
        super.clickOn(this.avatarIcon);
    }
    public void clickOnRegisterBtn(){
        super.clickOn(this.registerBtn);
    }
    public void clickOnSubRegisterBtn(){
        super.clickOn(this.subRegisterBtn);
    }

    public void clickOnLogSbmtBtn(){
        super.clickOn(this.loginSbmtBtn);
    }


    public void clickOnLoginBtn() {
        super.clickOn(this.loginBtn);
    }
    public void clickOnGoogleLogin(){
        super.clickOn(this.googleBtn);
    }

    public void clickOnLogoutBtn(){
        super.clickOn(this.logoutBtn);
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
    public void writeConfPassword(String pass){
        super.writeText(this.confPassInput, pass);
    }
    public void  writeEmailLogin(String email){
        super.writeText(this.emailLogInput, email);
    }
    public void  writePassLogin(String pass){
        super.writeText(this.passLogInput, pass);
    }



    public void openRegisterSection(String section) {
        this.clickOnAvatarIcon();
        switch (section){
            case "registration":
                super.waitVisibility(this.registerBtn);
                this.clickOnRegisterBtn();
                break;
            case "login":
                super.waitVisibility(this.loginBtn);
                this.clickOnLoginBtn();
                break;
        }
    }

    public void fillRegisterForm(String email, String pass, String confPass){
        this.writeEmail(email);
        this.writePassword(pass);
        this.writeConfPassword(confPass);
        this.clickOnSubRegisterBtn();
    }

    public void fillRegisterForm(String email, String pass){
        this.writeEmail(email);
        this.writePassword(pass);
        this.writeConfPassword(pass);
        this.clickOnSubRegisterBtn();
    }

    public void fillLoginForm(String email, String pass) throws InterruptedException {
        this.writeEmailLogin(email);
        this.writePassLogin(pass);
        this.clickOnLogSbmtBtn();
        Thread.sleep(3000);
    }
    public String getContentOfEmailPlaceholder(){
        return this.emailPlaceholder.getText();
    }
    public String getTextRegisterErrorEmailExisting(){
        return this.registerErrorPlaceholder.getText();
    }

    public String getTextLoginErrorPlaceholder(){
        return this.loginErrorPlaceholder.getText();
    }

    public boolean isLogged(){
        super.waitVisibility(this.emailPlaceholder);
        /***
         *  Expression reguliere pour identification d'une adresse mail
         */
        String emailRegex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(this.emailPlaceholder.getText()).find();
    }

    public  boolean isLogout(){
        return super.isElementAbsent(By.cssSelector("#style_header_navBar__hdNqL p"));
    }



}
