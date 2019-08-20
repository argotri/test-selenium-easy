
package id.gosoft.test.api.model.weatherModelResponse;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Source {

    private long crawlRate;
    private String slug;
    private String title;
    private String url;

}
