package com.orangeHRMPages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base_Page
{
    public static WebDriver driver;
    public static WebDriverWait wait;
    public Properties properties;

    public Base_Page()
    {
        String fPath="C://Users//ELCOT//IdeaProjects//Selenium_Maven//src//main//java//com//orangeHRMPages//Input_Data";
        properties=new Properties();
        try
        {
            FileInputStream fileInput=new FileInputStream(fPath);
            properties.load(fileInput);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }

    public void navigateToApplication()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.get(properties.getProperty("url"));
    }

    public void writeText(String text, WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }
    public void clickButton(WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void quit()
    {
        driver.quit();
    }
    public void captureScreenshot(String fileName)
    {
        try
        {
            TakesScreenshot screenshot=(TakesScreenshot) driver;
            File src=screenshot.getScreenshotAs(OutputType.FILE);
            File file=new File("./Screenshots/"+fileName+".png");
            FileHandler.copy(src,file);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }

    }
}
