package com.zemrow.messenger.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Окно регистрации пользователя
 *
 * @author Alexandr Polyakov on 2019.01.06
 */
public class RegistrationPage extends AbstractPage {

    private static final String DIALOG_PATH = "//table[contains(@class,'registration')]";

    public void registration(String username, String password) throws Exception {
        waitElement(By.xpath(DIALOG_PATH + "//input[@name='username']")).sendKeys(username);
        waitElement(By.xpath(DIALOG_PATH + "//input[@name='password']")).sendKeys(password);
        waitElement(By.xpath(DIALOG_PATH + "//input[@name='confirmPassword']")).sendKeys(password);
        waitElement(By.xpath(DIALOG_PATH + "//input[@type='submit']")).click();
    }

//================================ AUTO GENERATE ==============================

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
}