package com.test.pages;

import com.test.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;

public class StandardUserDataPage extends BasePage {

    public StandardUserDataPage(WebDriver driver) {
        super(driver);

    }
    public String standardUserUsername(){
        return ConfigReader.get("user.standard.username");
    }
    public String standardUserPassword(){
        return ConfigReader.get("all.users.password");
    }
}
