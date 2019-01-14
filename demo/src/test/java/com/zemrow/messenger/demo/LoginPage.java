package com.zemrow.messenger.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Окно входа в систему
 *
 * @author Alexandr Polyakov on 2019.01.06
 */
public class LoginPage extends AbstractPage {

    private static final String DIALOG_PATH = "//table[contains(@class,'login')]";

    public boolean isShow() throws Exception {
        return waitElement(By.xpath(DIALOG_PATH)).isDisplayed();
    }

    public void login(String username, String password) throws Exception {
        waitElement(By.xpath(DIALOG_PATH + "//input[@name='username']")).sendKeys(username);
        waitElement(By.xpath(DIALOG_PATH + "//input[@name='password']")).sendKeys(password);
        waitElement(By.xpath(DIALOG_PATH + "//input[@type='submit']")).click();
    }

    public RegistrationPage goRegistrationPage() throws Exception {
        waitElement(By.xpath(DIALOG_PATH + "//input[@name='toRegistration']")).click();
        return new RegistrationPage(driver);
    }

//================================ AUTO GENERATE ==============================

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
