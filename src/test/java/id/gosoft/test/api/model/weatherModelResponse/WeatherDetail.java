
package id.gosoft.test.api.model.weatherModelResponse;

import java.util.List;
import lombok.Data;

@Data
public class WeatherDetail {

    private List<ConsolidatedWeather> consolidatedWeather;
    private String lattLong;
    private String locationType;
    private Parent parent;
    private List<Source> sources;
    private String sunRise;
    private String sunSet;
    private String time;
    private String timezone;
    private String timezoneName;
    private String title;
    private long woeid;

}
