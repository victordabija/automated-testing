package org.example.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class FormPage {

    private final WebDriver driver;
    private final JavascriptExecutor javascriptExecutor;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        this.javascriptExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String firstName) {
        WebElement field = driver.findElement(By.id("firstName"));
        Type(field, firstName);
    }

    public String getFirstAndLastName() {
        WebElement field = driver.findElement(By.xpath("//tbody/tr[1]/td[2]"));
        return field.getText();
    }

    public void setLastName(String lastName) {
        WebElement field = driver.findElement(By.id("lastName"));
        Type(field, lastName);
    }

    public void setEmail(String email) {
        WebElement field = driver.findElement(By.id("userEmail"));
        Type(field, email);
    }

    public String getEmail() {
        WebElement field = driver.findElement(By.xpath("//tbody/tr[2]/td[2]"));
        return field.getText();
    }

    public void selectMaleGender() {
        WebElement field = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        field.click();
    }

    public String getGender() {
        WebElement field = driver.findElement(By.xpath("//tbody/tr[3]/td[2]"));
        return field.getText();
    }

    public void setMobileNumber(String mobileNumber) {
        WebElement field = driver.findElement(By.id("userNumber"));
        Type(field, mobileNumber);
    }

    public String getMobileNumber() {
        WebElement field = driver.findElement(By.xpath("//tbody/tr[4]/td[2]"));
        return field.getText();
    }

    public void setDateOfBirth(String dateOfBirth) {
        WebElement field = driver.findElement(By.id("dateOfBirthInput"));
        field.click();

        javascriptExecutor.executeScript("arguments[0].value = '';", field);

        field.sendKeys(dateOfBirth);
        field.sendKeys(Keys.ENTER);
    }

    public String getDateOfBirth() {
        WebElement field = driver.findElement(By.xpath("//tbody/tr[5]/td[2]"));
        return field.getText();
    }

    public void setSubject(String subject) {
        WebElement field = driver.findElement(By.id("subjectsInput"));

        field.click();

        Type(field, subject);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".subjects-auto-complete__menu-list")));

        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", field);
        WebElement firstSuggestion = driver.findElement(By.cssSelector(".subjects-auto-complete__option"));
        firstSuggestion.click();
    }

    public String getSubjects(){
        WebElement field = driver.findElement(By.xpath("//tbody/tr[6]/td[2]"));
        return field.getText();
    }

    public void setHobby(String hobbyId) {
        WebElement field = driver.findElement(By.cssSelector("label[for='" + hobbyId + "']"));
        field.click();
    }

    public String getHobbies(){
        WebElement field = driver.findElement(By.xpath("//tbody/tr[7]/td[2]"));
        return field.getText();
    }

    public void setPicture(String filePath) {
        WebElement field = driver.findElement(By.id("uploadPicture"));
        Type(field, filePath);
    }

    public String getPicture() {
        WebElement field = driver.findElement(By.xpath("//tbody/tr[8]/td[2]"));
        return field.getText();
    }

    public void setAddress(String address) {
        WebElement field = driver.findElement(By.id("currentAddress"));
        Type(field, address);
    }

    public String getAddress() {
        WebElement field = driver.findElement(By.xpath("//tbody/tr[9]/td[2]"));
        return field.getText();
    }

    public void setState(String state) {
        WebElement field = driver.findElement(By.id("react-select-3-input"));
        TypeAndEnter(field, state);
    }

    public void setCity(String city) {
        WebElement field = driver.findElement(By.id("react-select-4-input"));
        TypeAndEnter(field, city);
    }

    public String getStateAndCity() {
        WebElement field = driver.findElement(By.xpath("//tbody/tr[10]/td[2]"));
        return field.getText();
    }

    public void submitForm() {
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
    }

    private void Type(WebElement field, String text) {
        field.sendKeys(text);
    }

    private void TypeAndEnter(WebElement field, String text) {
        field.sendKeys(text);
        field.sendKeys(Keys.ENTER);
    }
}