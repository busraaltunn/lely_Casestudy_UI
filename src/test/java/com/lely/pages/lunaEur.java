package com.lely.pages;

import com.lely.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class lunaEur {

    public lunaEur(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath="//span[@id='select2-id_q-container']")
    public WebElement dropdownButtonButNotDropdown;

    @FindBy(xpath="//a[@id='cookienotice-button-accept']")
    public WebElement acceptCookies;

    @FindBy(xpath="//li[.='Luna EUR']")
    public WebElement lunaEurText;

    @FindBy(xpath = "(//section[@class='result-item'])[1]")
    public WebElement lunaEur1;

    @FindBy(xpath = "(//section[@class='result-item'])[2]")
    public WebElement lunaEur2;

    @FindBy(xpath = "//a[@href='https://www.lelynet.com/_layouts/15/document/TechDocHandler.aspx?name=D-S006VT_-.pdf&mode=view']")
    public WebElement viewThisDocument1;

    @FindBy(xpath = "//a[@href='https://www.lelynet.com/_layouts/15/document/TechDocHandler.aspx?name=D-S032VT_-.pdf&mode=view']")
    public WebElement viewThisDocument2;

    @FindBy(xpath = "(//a[@class='button button-secondary icon-pdf'])[1]")
    public WebElement download1;

    @FindBy(xpath = "(//a[@class='button button-secondary icon-pdf'])[2]")
    public WebElement download2;


    public static boolean verifyDocumentDownloaded(String downloadUrl) {
        String downloadedFile = System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"test"+File.separator+"resources"+File.separator+"downloads"+File.separator+"D-S006VT_-.pdf";
        File file = new File(downloadedFile);
        return file.exists();
    }








}
