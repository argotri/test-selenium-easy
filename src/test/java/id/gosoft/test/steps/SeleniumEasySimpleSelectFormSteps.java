package id.gosoft.test.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import id.gosoft.test.pages.SeleniumEasyFormDemoPage;
import id.gosoft.test.pages.SeleniumEasyHomePage;
import id.gosoft.test.pages.SeleniumEasySelectFormDemoPage;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;
import org.openqa.selenium.Keys;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class SeleniumEasySimpleSelectFormSteps extends ScenarioSteps {

    SeleniumEasyHomePage seleniumEasyHomePage;
    SeleniumEasySelectFormDemoPage seleniumEasySelectFormDemoPage;

    @And("user click on select drop down list button")
    public void userClickOnSelectDropDownListButton() {
        seleniumEasyHomePage.btnSelectDropdownList.click();
    }

    @Then("select should be avaiable")
    public void selectShouldBeAvaiable() {
        assertThat("Select is not visible" ,
                seleniumEasySelectFormDemoPage.selectADay.waitUntilVisible().isCurrentlyVisible(),
                Matchers.equalTo(true));
    }

    @When("user select on {string}")
    public void userSelectOn(String selection) {
        seleniumEasySelectFormDemoPage.selectADay.selectByVisibleText(selection);
    }

    @Then("user should see {string}")
    public void userShouldSee(String selection) {
        assertThat("String is not same"
                ,seleniumEasySelectFormDemoPage.txtSelectDay.getText().toLowerCase()
                ,Matchers.containsString(selection.toLowerCase()));
    }

    @When("user select on multiple select {string}")
    public void userSelectOnMultipleSelect(String selection) {
        seleniumEasySelectFormDemoPage.selectOnMultiple(Arrays.asList(selection.split(",")));
    }

    @When("user click on first Selected")
    public void userClickOnFirstSelected() {
        seleniumEasySelectFormDemoPage.btnPrintFirstSelected.click();
    }

    @When("user click on all Selected")
    public void userClickOnAllSelected() {
        seleniumEasySelectFormDemoPage.btnPrintAll.click();
    }

    @Then("user should see {string} on multiple select")
    public void userShouldSeeOnMultipleSelect(String states) {
        // check if every state is in the text
        for(String state : Arrays.asList(states.split(",")))
        assertThat("Selection is not right"
                , seleniumEasySelectFormDemoPage.txtMultipleSelect.getText().toLowerCase()
                , Matchers.containsString(state.toLowerCase()));

    }

    @When("user deselect all country")
    public void userDeselectAllCountry() {
        seleniumEasySelectFormDemoPage.multipleSelectCountry.deselectAll();
    }

}
