package id.gosoft.test.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;


public class SeleniumEasyFormDemoPage extends PageObject {

    /**
     * First Form
     */
    @FindBy(id = "user-message")
    public WebElementFacade inputMessage;

    @FindBy(xpath = "//form[@id=\"get-input\"]//button")
    public WebElementFacade btnShowMessage;
    /**
     * Second form
     */

    @FindBy(id = "sum1")
    public WebElementFacade inputSum1;
    @FindBy(id = "sum2")
    public WebElementFacade inputSum2;

    @FindBy(xpath = "//form[@id=\"gettotal\"]//button")
    public WebElementFacade btnGetTotal;

    public String getTextDisplay() {
        return find(By.id("display")).getText();
    }

    public String getTextSummary(){
        return find(By.id("displayvalue")).getText();
    }
}
