package com.zemrow.messenger.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Общие методы для работы со страницей
 *
 * @author Alexandr Polyakov on 2019.01.06
 */
public abstract class AbstractPage {
    public WebDriver driver;
    public Robot robot;

    public AbstractPage(WebDriver driver, Robot robot) {
        this.driver = driver;
        this.robot = robot;
    }

    /**
     * Метод ожидает появление элемента на странице
     *
     * @param by селектор идентифицирующий элемент
     * @return элемент
     * @throws InterruptedException если элемент не был найден в течении 1 минуты
     */
    public WebElement waitElement(By by) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }

    /**
     * Метод ожидает появление элемента на странице + проверяет что он не перекрыт другими элементами
     *
     * @param by селектор идентифицирующий элемент
     * @return элемент
     * @throws InterruptedException если элемент не был найден в течении 1 минуты
     */
    public WebElement waitClickableElement(By by) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }


    /**
     * Метод ожидает скрытия элемента со страницы
     *
     * @param by селектор идентифицирующий элемент
     * @throws InterruptedException если элемент не был скрыт в течении 2-х минут
     */
    public void waitInvisibilityElement(By by) throws InterruptedException {
        System.out.print("Wait ");
        WebDriverWait wait = new WebDriverWait(driver, 120);
        long time = System.currentTimeMillis();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        time = System.currentTimeMillis() - time;
        System.out.println(time + "ms for hide element:" + by);
    }

    /**
     * Method allow you to switch between browser tabs
     */
    public void switchTab(int tab) {
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(tab));
    }

    public void closeTab() {
        driver.findElement(By.xpath("//body")).sendKeys(Keys.CONTROL + "w");
    }

    public void switchLastTab() {
        String lastTab = null;
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            lastTab = iterator.next();
        }
        driver.switchTo().window(lastTab);
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    protected void moveToElement(String xpath) throws AWTException {
//        new Actions(driver).moveToElement(driver.findElement(By.xpath(xpath))).perform();
        if (robot != null) {
            Point coordinates = driver.findElement(By.xpath(xpath)).getLocation();
            robot.mouseMove(coordinates.getX() + 10, coordinates.getY() + 120);
        }
    }
}
