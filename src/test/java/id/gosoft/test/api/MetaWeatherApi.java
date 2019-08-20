package id.gosoft.test.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.SystemEnvironmentVariables;


import java.util.ArrayList;
import java.util.List;

import static id.gosoft.test.api.Constant.META_WEATHER_API_BASE_URL;
import static net.serenitybdd.rest.SerenityRest.given;

public class MetaWeatherApi {
    EnvironmentSpecificConfiguration environmentSpecificConfiguration;

    public MetaWeatherApi() {
        environmentSpecificConfiguration = EnvironmentSpecificConfiguration.from(SystemEnvironmentVariables.createEnvironmentVariables());
    }
    private RequestSpecification prepareRequest(){
        return given()
                .baseUri(environmentSpecificConfiguration.getProperty(META_WEATHER_API_BASE_URL))
                .header("Content-Type","application/json").log().all();
    }

    @Step
    public Response getWoidByQuery(String city) {
        return prepareRequest().get("search/?query=" + city);
    }

    @Step
    public List<Response> getWeatherByWoid(List<Integer> woeids){
        List<Response> responses = new ArrayList<>();
        woeids.forEach(woeid -> {
            Response respon = prepareRequest().get("/" + woeid);
            respon.getBody().prettyPrint();
            responses.add(respon);
        });
        return responses;
    }
    @Step
    public Response getWeatherByWoid(Integer woeid){
        return prepareRequest().get("/" + woeid);
    }
}

