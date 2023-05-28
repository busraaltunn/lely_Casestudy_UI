package com.lely.pages;

import com.lely.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class searchButton {


    public searchButton(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath="//div[.=\"Search\"]")
    public WebElement searchIcon;

    @FindBy(xpath="//input[@id='global-search']")
    public WebElement searchArea;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement searchButton;

    @FindBy(xpath="//section[@class='page-section search-results']")
    public List<WebElement> searchResults ;





}
