package id.gosoft.test.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("page:webdriver.base.url")
public class SeleniumEasyHomePage extends PageObject {

    @FindBy(id = "btn_basic_example")
    public WebElementFacade btnStartPracticing;

    @FindBy(xpath = "//div[@class=\"list-group\"]/a[@href=\"./basic-first-form-demo.html\"]")
    public WebElementFacade btnSimpleFormDemo;

    @FindBy(xpath = "//div[@class=\"list-group\"]/a[@href=\"./basic-select-dropdown-demo.html\"]")
    public WebElementFacade btnSelectDropdownList;

}
