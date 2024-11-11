package org.example;

import org.apache.log4j.Logger;
import org.example.enums.FormInputs;
import org.example.pom.FormPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.example.utils.SeleniumDriver;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormTest {

    public static WebDriver driver;

    public static Logger logger = Logger.getLogger(FormTest.class);

    @BeforeClass
    public void BeforeClass() {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver-linux64/chromedriver");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();

        driver = SeleniumDriver.getRemoteDriver();
    }

    @Test
    public void FormFillingTest() throws InterruptedException {
        logger.info("START TEST");

        driver.get("https://demoqa.com/automation-practice-form");
        FormPage page = new FormPage(driver);

        page.closeAdv();

        page.setFirstName(FormInputs.FIRST_NAME.getValue());
        page.setLastName(FormInputs.LAST_NAME.getValue());
        page.setEmail(FormInputs.USER_EMAIL.getValue());
        page.selectMaleGender();
        page.setMobileNumber(FormInputs.PHONE_NUMBER.getValue());
        page.setDateOfBirth(FormInputs.DATE_OF_BIRTH.getValue());
        page.setSubject(FormInputs.SUBJECT_MATH.getValue());
        page.setSubject(FormInputs.SUBJECT_BIOLOGY.getValue());
        page.setHobby(FormInputs.SPORTS_HOBBY_ID.getValue());
        page.setHobby(FormInputs.MUSIC_HOBBY_ID.getValue());
//        page.setPicture(FormInputs.FILE_PATH.getValue());
        page.setAddress(FormInputs.ADDRESS.getValue());
        page.setState(FormInputs.STATE.getValue());
        page.setCity(FormInputs.CITY.getValue());
        page.submitForm();

        logger.info("START ASSERTS");

        this.assertValues(page.getFirstAndLastName(), FormInputs.FIRST_NAME.getValue() + " " + FormInputs.LAST_NAME.getValue());
        this.assertValues(page.getEmail(), FormInputs.USER_EMAIL.getValue());
        this.assertValues(page.getGender(), FormInputs.GENDER.getValue());
        this.assertValues(page.getMobileNumber(), FormInputs.PHONE_NUMBER.getValue());
        this.assertValues(
                page.getDateOfBirth(),
                LocalDate.parse(FormInputs.DATE_OF_BIRTH.getValue(), DateTimeFormatter.ofPattern("dd MMM yyyy"))
                        .format(DateTimeFormatter.ofPattern("dd MMMM,yyyy"))
        );
        this.assertValues(page.getSubjects(), FormInputs.SUBJECT_MATH.getValue() + ", " + FormInputs.SUBJECT_BIOLOGY.getValue());
        this.assertValues(page.getHobbies(), FormInputs.HOBBIES.getValue());
//        this.assertValues(page.getPicture(), Paths.get(FormInputs.FILE_PATH.getValue()).getFileName().toString());
        this.assertValues(page.getAddress(), FormInputs.ADDRESS.getValue());
        this.assertValues(page.getStateAndCity(), FormInputs.STATE.getValue() + " " + FormInputs.CITY.getValue());

        Thread.sleep(2000);
        logger.info("END TEST");
    }

    @AfterClass
    public void CloseDriver() {
        driver.quit();
    }

    private void assertValues(String actual, String expected) throws InterruptedException {
        Assert.assertEquals(actual, expected);
        Thread.sleep(1000);
    }

}
