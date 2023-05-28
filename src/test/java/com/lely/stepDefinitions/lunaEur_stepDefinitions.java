package com.lely.stepDefinitions;

import com.lely.pages.lunaEur;
import com.lely.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Set;

public class lunaEur_stepDefinitions {

    lunaEur lunaEurPage = new lunaEur();
    String parentWindowHandle;
    //String mainHandle;
    //WebDriverWait wait=new WebDriverWait(Driver.getDriver(),3);

    @Given("user is on the technical document page")
    public void user_is_on_the_technical_document_page() {
        Driver.getDriver().get("https://www.lely.com/techdocs/");

        lunaEurPage.acceptCookies.click();
    }

    @When("Users can select “LUNA EUR” from the dropdown and verify that the catalogs can be seen")
    public void users_can_select_luna_eur_from_the_dropdown_and_verify_that_the_catalogs_can_be_seen() {
        //wait.until(ExpectedConditions.elementToBeClickable(lunaEurPage.dropdownButtonButNotDropdown));
        lunaEurPage.dropdownButtonButNotDropdown.click();
        lunaEurPage.lunaEurText.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(lunaEurPage.lunaEur2).perform();
        //lunaEurPage.lunaEur1.isDisplayed();
        //lunaEurPage.lunaEur2.isDisplayed();
        if (lunaEurPage.lunaEur1.isDisplayed()) {
            System.out.println("Document is visible");
        } else {
            System.out.println("Document is not visible");
        }
    }

    @When("Users can view the document and verify that it is opened on a new tab")
    public void users_can_view_the_document_and_verify_that_it_is_opened_on_a_new_tab() {

        String parentWindowHandle = Driver.getDriver().getWindowHandle();
        lunaEurPage.viewThisDocument1.click();

        Set<String> windowHandles = Driver.getDriver().getWindowHandles();

        // Switch to the new tab/window
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                Driver.getDriver().switchTo().window(windowHandle);
                break;
            }
        }

        // Verify that the document is opened on a new tab
        String currentUrl = Driver.getDriver().getCurrentUrl();

        if (currentUrl.contains(".pdf")) {
            System.out.println("Document is opened on a new tab.");
        } else {
            System.out.println("Document is not opened on a new tab.");
        }


/*
        String mainHandle=Driver.getDriver().getWindowHandle();

        System.out.println("mainHandle = " + mainHandle);

        lunaEurPage.viewThisDocument1.click();

        for(String each: Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(each);
        }

 */

        /*
        lunaEurPage.viewThisDocument1.click();

        Set<String> windowHandles = Driver.getDriver().getWindowHandles();


        for (String windowHandle : windowHandles) {
            Driver.getDriver().switchTo().window(windowHandle);
        }
*/
        /*
        String currentUrl = Driver.getDriver().getCurrentUrl();


        if (currentUrl.contains(".pdf")) {
            System.out.println("PDF opened correctly");
        } else {
            System.out.println("The PDF could not be opened or an incorrect page was opened");
        }

         */


        /*
        String mainHandle=Driver.getDriver().getWindowHandle();

        System.out.println("mainHandle = " + mainHandle);

        lunaEurPage.viewThisDocument1.click();

        for(String each: Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current title while switchig window: "+ Driver.getDriver().getTitle());
        }

        String expectedTitleAfterClick= "D-S006.0911VT.fm";
        String actualTitle= Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitleAfterClick, actualTitle);

*/
    }

    @When("Users can  return to the previous tab and download the document")
    public void users_can_return_to_the_previous_tab_and_download_the_document() throws InterruptedException {


        //Driver.getDriver().switchTo().window(windowHandles.iterator().next());
        Driver.getDriver().switchTo().window(parentWindowHandle);
        lunaEurPage.download1.click();
        Thread.sleep(7000);

    }

    @Then("Users should verify that it is downloaded")
    public void users_should_verify_that_it_is_downloaded() {
        /*
        String downloadPath="/Users/t/Downloads/D-S006VT_-.pdf";

        String fileName = "D-S006VT_-.pdf"; // Replace with the actual file name
        String filePath = downloadPath + File.separator + fileName;
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("Yes, file is dowloaded ");
        } else {
            System.out.println("File cannot be downloaded");
        }
    }
    */
        String downloadUrl = lunaEurPage.viewThisDocument1.getAttribute("href");

        boolean isDownloaded = lunaEurPage.verifyDocumentDownloaded(downloadUrl);
        if (isDownloaded) {
            System.out.println("Document is downloaded.");
        } else {
            System.out.println("Document is not downloaded.");
        }


    }
}

