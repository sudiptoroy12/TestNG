import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver driver;
    @FindBy(className="login")
    WebElement linkLogin;
    @FindBy(id="email")
    WebElement txtEmail;
    @FindBy(id="passwd")
    WebElement txtPassword;
    @FindBy(id="SubmitLogin")
    WebElement btnSubmit;
    @FindBy(xpath = "//span[contains(text(),'Test User')]")
    WebElement lblUserName;

    @FindBy(xpath = "//li[contains(text(),'" + "')]")
    WebElement lblAuthError;
    @FindBy(xpath = "//li[contains(text(),'Invalid email address.')]")
    WebElement lblInvalidEmail;

    public Login(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String doLogin(String email,String password) throws InterruptedException {
        linkLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmit.click();
        return lblUserName.getText();
    }
    public String doLoginInvalidEmail(String email,String password) throws InterruptedException {
        linkLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmit.click();
        return lblInvalidEmail.getText();
    }
    public String doLoginInvalidPasswrd(String email,String password) throws InterruptedException {
        linkLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmit.click();
        return lblAuthError.getText();
    }
}
