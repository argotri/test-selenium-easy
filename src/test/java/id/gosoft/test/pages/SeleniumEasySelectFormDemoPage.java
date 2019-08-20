package id.gosoft.test.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SeleniumEasySelectFormDemoPage extends PageObject {

    /**
     * Selection Box
     */

    @FindBy(id = "select-demo")
    public WebElementFacade selectADay;

    @FindBy(className = "selected-value")
    public WebElementFacade txtSelectDay;

    /**
     * Multiple select
     */

    @FindBy(id = "multi-select")
    public WebElementFacade multipleSelectCountry;

    @FindBy(id = "printMe")
    public WebElementFacade btnPrintFirstSelected;

    @FindBy(id = "printAll")
    public WebElementFacade btnPrintAll;

    @FindBy(className = "getall-selected")
    public WebElementFacade txtMultipleSelect;

    public void selectOnMultiple(List<String> values) {
        Actions action = withAction().keyDown(Keys.CONTROL);
        int first=0;
        for (String value : values) {
            if(first>0){ // handle multiple select
                action
                        .moveToElement(find(By.xpath("//select[@id=\"multi-select\"]//option[@value=\"" + value + "\"]")))
                        .click();
            }else{ // handle if there are first click because in js the handle is on ctrl event so we can't use usual select by visible text
                multipleSelectCountry.selectByVisibleText(value);
                waitABit(1000);
            }
            first++;
        }
        action.keyUp(Keys.CONTROL)
                .build().perform();
    }

}
