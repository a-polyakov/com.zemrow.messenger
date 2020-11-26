package com.zemrow.messenger.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

/**
 * Основная страница приложения
 *
 * @author Alexandr Polyakov on 2019.01.06
 */
public class HomePage extends AbstractPage {

    public LoginPage goLoginPage() {
        // TODO если пользователь уже залогинен, выйти
        return new LoginPage(driver, robot);
    }

    public void userMenuExitSelect() throws InterruptedException {
        waitElement(By.xpath("//div[contains(@class,'user_info_menu_dialog')]//li[text()='Выход']")).click();
    }

    public void userMenuOpen() throws InterruptedException {
        waitElement(By.xpath("//td[@class='user_info_menu']")).click();
    }

    public void checkUsername(String username) throws InterruptedException {
        waitElement(By.xpath("//td[@class='user_info_name' and text()='" + username + "']"));
    }

    public void moveToUserInfoName() throws AWTException {
        moveToElement("//td[@class='user_info_name']");
    }

    public void moveToChatTab() throws AWTException {
        moveToElement("//td[contains(@class,'chat_tab')]");
    }

//================================ AUTO GENERATE ==============================

    public HomePage(WebDriver driver, Robot robot) {
        super(driver, robot);
    }
}
