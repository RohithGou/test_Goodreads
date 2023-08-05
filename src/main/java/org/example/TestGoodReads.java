package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class TestGoodReads {

    String homePageURL = "https://www.goodreads.com/";

    String signInButton = "//*[@id=\"signIn\"]/div/div/a";

    String signInWithEmailButton = "//*[@id=\"choices\"]/div/a[5]/button";

    String emailInputBox = "//*[@id=\"ap_email\"]";

    String passwordInputBox = "//*[@id=\"ap_password\"]";

    String signInSubmitButton = "//*[@id=\"signInSubmit\"]";

    String dismissButton = "//*[@id=\"bodycontainer\"]/div/div[2]/div/header/div[2]/div/div[5]/div/div[1]/button/img";

    String searchInHomePage = "//*[@id=\"bodycontainer\"]/div/div[2]/div/header/div[2]/div/div[2]/form/input[1]";

    String wantToReadButton = "//*[@id=\"1_book_14744694\"]/div[1]/form/button";

    String myBooksListURL = "https://www.goodreads.com/review/list/168592592?ref=nav_mybooks";

    String removeFromMyBooks = "/html/body/div[2]/div[3]/div[1]/div[1]/div[3]/div[2]/div[6]/table/tbody/tr/td[26]/div/div/a";

    String myProfile = "//*[@id=\"bodycontainer\"]/div[1]/div/header/div[2]/div/div[3]/ul/li[5]/div/a/span/img";

    String signOutButton = "//*[@id=\"bodycontainer\"]/div[1]/div/header/div[2]/div/div[3]/ul/li[5]/div/div/div/ul/li[13]/a";
    String userNameText = "rohithgoud200011@gmail.com";
    String passwordText = "Rohith@12345";

    String bookTitleText = "Python for Data Analysis";


    @Test
    public void VerifyGoodReads() throws InterruptedException {
//        System.setProperty("webdriver.http.factory","jdk-http-client");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get(homePageURL);
        Thread.sleep(3000);

        driver.findElement(By.xpath(signInButton)).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath(signInWithEmailButton)).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath(emailInputBox)).sendKeys(userNameText);
        driver.findElement(By.xpath(passwordInputBox)).sendKeys(passwordText);
        driver.findElement(By.xpath(signInSubmitButton)).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath(dismissButton)).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath(searchInHomePage)).sendKeys(bookTitleText);
        Thread.sleep(2000);
        new Actions(driver).keyDown(Keys.ENTER).perform();
        Thread.sleep(2000);

        driver.findElement(By.xpath(wantToReadButton)).click();
        Thread.sleep(2000);

//        driver.findElement(By.xpath(myBooksList)).click();
        driver.get(myBooksListURL);
        Thread.sleep(2000);

        driver.findElement(By.xpath(removeFromMyBooks)).click();
        Thread.sleep(2000);

        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        driver.findElement(By.xpath(myProfile)).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath(signOutButton)).click();
        Thread.sleep(2000);

        driver.close();
    }
}
