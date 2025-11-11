
package org.example.findmygate.weatherdto;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "2025-11-10"
})
@Generated("jsonschema2pojo")
public class Forecast {

    @JsonProperty("2025-11-10")
    private org.example.findmygate.weatherdto._20251110 _20251110;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("2025-11-10")
    public org.example.findmygate.weatherdto._20251110 get20251110() {
        return _20251110;
    }

    @JsonProperty("2025-11-10")
    public void set20251110(org.example.findmygate.weatherdto._20251110 _20251110) {
        this._20251110 = _20251110;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
