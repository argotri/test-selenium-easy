package id.gosoft.test.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import id.gosoft.test.api.MetaWeatherApi;
import id.gosoft.test.api.model.searchModelResponse.City;
import id.gosoft.test.api.model.weatherModelResponse.WeatherDetail;
import io.restassured.mapper.TypeRef;
import io.restassured.response.Response;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WeatherApiSteps extends ScenarioSteps {

    MetaWeatherApi metaWeatherApi;
    Response responseCity;
    List<Response> responseWeathers;
    Response singleResponseWeather;

    @Given("user preparing for request")
    public void userPreparingForRequest() {
        metaWeatherApi = new MetaWeatherApi();
    }

    @When("user get woeid from city {string}")
    public void userGetWoeidFromCity(String city) {
        responseCity = metaWeatherApi.getWoidByQuery(city);
    }

    @Then("response code should be {int} in city response")
    public void responseCodeShouldBeInCityResponse(Integer statusCode) {
        assertThat("Status code is not same " , responseCity.getStatusCode() , equalTo(statusCode));
    }

    @Then("{int} city is found in response")
    public void cityIsFoundInResponse(Integer citySize) {
        assertThat("size is not same " ,
                responseCity.getBody().as(new TypeRef<List<City>>() {}).size(),
                Matchers.equalTo(citySize));
    }

    @Then("one of them is {string}")
    public void oneOfThemIs(String expected) {
            List<String> listOfCities =responseCity.getBody().as(new TypeRef<List<City>>() {}).stream().map(City::getTitle).collect(Collectors.toList());
            assertThat("City " + expected + " is not found " ,
                    listOfCities,
                    hasItem(equalToIgnoringCase(expected))
            );
    }

    @When("user hit get api location with id from previous steps")
    public void userHitGetApiLocationWithIdFromPreviousSteps() {
        List<City> cities = responseCity.getBody().as(new TypeRef<List<City>>() {
        });
        List<Integer> woeids = cities.stream().map(City::getWoeid).collect(Collectors.toList());
        responseWeathers = metaWeatherApi.getWeatherByWoid(woeids);
    }

    @Then("response code should be {int} in weather responses")
    public void responseCodeShouldBeInWeatherResponses(Integer responseCode) {
        List<Integer> responseCodes = responseWeathers.stream().map(response -> response.getStatusCode()).collect(Collectors.toList());
        assertThat("response code is not same" , responseCodes,everyItem(equalTo(responseCode)));
    }

    @Then("title in the response is {string}")
    public void titleInTheResponseIs(String titles) {
        if(!titles.isEmpty()){ // handle if do some negative test
            List<WeatherDetail> actualWeather = responseWeathers.stream().map(response -> response.as(WeatherDetail.class)).collect(Collectors.toList());
            List<String> actualTitle = actualWeather.stream().map(WeatherDetail::getTitle).collect(Collectors.toList());
            assertThat("There are city that miss1ing" , actualTitle,containsInAnyOrder(titles.split(",")));
        }
    }

    @When("user hit on get detail weather with woeid {int}")
    public void userHitOnGetDetailWeatherWithWoeid(int woeid) {
        singleResponseWeather =metaWeatherApi.getWeatherByWoid(woeid);
    }

    @Then("response code should be {int} in weather response")
    public void responseCodeShouldBeInWeatherResponse(int statusCode) {
        assertThat("response code is not same " , singleResponseWeather.getStatusCode() , equalTo(statusCode));
    }
}
