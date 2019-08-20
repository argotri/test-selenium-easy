package id.gosoft.test.steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import id.gosoft.test.pages.SeleniumEasyFormDemoPage;
import id.gosoft.test.pages.SeleniumEasyHomePage;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class SeleniumEasySimpleFormSteps extends ScenarioSteps {

    SeleniumEasyHomePage seleniumEasyPage;
    SeleniumEasyFormDemoPage seleniumEasyFormDemoPage;

    @Given("user open selenium easy page")
    public void openSeleniumEasyPage() {
        seleniumEasyPage.open();
    }

    @When("user click on button start practicing")
    public void userClickOnButtonStartPracticing() {
        seleniumEasyPage.btnStartPracticing.click();
    }

    @When("user click on simple form demo")
    public void userClickOnSimpleFormDemo() {
        seleniumEasyPage.btnSimpleFormDemo.waitUntilClickable().click();
    }

    @Then("input enter message is appear")
    public void inputEnterMessageIsAppear() {
        assertThat("Form is not loaded",
                seleniumEasyFormDemoPage.inputMessage.waitUntilVisible().isCurrentlyVisible(),
                Matchers.equalTo(true));
    }

    @When("user type {string} in text message")
    public void userTypeInTextMessage(String text) {
        seleniumEasyFormDemoPage.inputMessage.type(text);
    }

    @When("user click on button show message")
    public void userClickOnButtonShowMessage() {
        seleniumEasyFormDemoPage.btnShowMessage.click();
    }

    @Then("user shouldable to see text {string} in result")
    public void userShouldableToSeeTextInResult(String expectedText) {
        assertThat("Text is not same" , seleniumEasyFormDemoPage.getTextDisplay(), Matchers.equalTo(expectedText));
    }

    @When("user type {string} into text field a")
    public void userTypeIntoTextFieldA(String a) {
        seleniumEasyFormDemoPage.inputSum1.type(a);
    }

    @When("user type {string} into text field b")
    public void userTypeIntoTextFieldB(String b) {
        seleniumEasyFormDemoPage.inputSum2.type(b);
    }

    @When("user click on button get total")
    public void userClickOnButtonGetTotal() {
        seleniumEasyFormDemoPage.btnGetTotal.click();
    }

    @Then("user should see the result {string}")
    public void userShouldSeeTheResult(String sum) {
        assertThat("Sum is not same" , seleniumEasyFormDemoPage.getTextSummary(), Matchers.equalTo(sum));
    }

}
