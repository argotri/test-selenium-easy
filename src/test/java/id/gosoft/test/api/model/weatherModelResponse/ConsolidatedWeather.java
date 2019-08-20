
package id.gosoft.test.api.model.weatherModelResponse;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class ConsolidatedWeather {

    private double airPressure;
    private String applicableDate;
    private String created;
    private long humidity;
    private long id;
    private double maxTemp;
    private double minTemp;
    private long predictability;
    private double theTemp;
    private double visibility;
    private String weatherStateAbbr;
    private String weatherStateName;
    private double windDirection;
    private String windDirectionCompass;
    private double windSpeed;

}
