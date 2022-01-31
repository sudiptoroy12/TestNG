
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoginTestRunner extends Setup {
    @Test
    public void doUserLogin() throws InterruptedException, IOException, ParseException {
        driver.get("http://automationpractice.com");
        Login login = new Login(driver);
        Utils utils=new Utils(driver);
        utils.readJSONArray(0);

        String username = login.doLogin(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(username.contains("sudip"));

    }
    @Test
    public void doUserLoginWithInvalidEmail() throws InterruptedException, IOException, ParseException {
        driver.get("http://automationpractice.com");
        Login login = new Login(driver);
        Utils utils=new Utils(driver);
        utils.readJSONArray(1);

        String errorMessage = login.doLoginInvalidEmail(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(errorMessage.contains("Invalid email address."));

    }
    @Test
    public void doUserLoginWithWrongPasswrd() throws InterruptedException, IOException, ParseException {
        driver.get("http://automationpractice.com");
        Login login = new Login(driver);
        Utils utils=new Utils(driver);
        utils.readJSONArray(2);

        String errorMessage = login.doLoginInvalidPasswrd(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(errorMessage.contains("Authentication failed."));

    }
}