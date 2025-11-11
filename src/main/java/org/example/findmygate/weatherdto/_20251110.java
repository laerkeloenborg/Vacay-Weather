
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
    "date",
    "date_epoch",
    "astro",
    "mintemp",
    "maxtemp",
    "avgtemp",
    "totalsnow",
    "sunhour",
    "uv_index",
    "air_quality"
})
@Generated("jsonschema2pojo")
public class _20251110 {

    @JsonProperty("date")
    private String date;
    @JsonProperty("date_epoch")
    private Integer dateEpoch;
    @JsonProperty("astro")
    private Astro astro;
    @JsonProperty("mintemp")
    private Integer mintemp;
    @JsonProperty("maxtemp")
    private Integer maxtemp;
    @JsonProperty("avgtemp")
    private Integer avgtemp;
    @JsonProperty("totalsnow")
    private Integer totalsnow;
    @JsonProperty("sunhour")
    private Integer sunhour;
    @JsonProperty("uv_index")
    private Integer uvIndex;
    @JsonProperty("air_quality")
    private AirQuality__1 airQuality;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("date_epoch")
    public Integer getDateEpoch() {
        return dateEpoch;
    }

    @JsonProperty("date_epoch")
    public void setDateEpoch(Integer dateEpoch) {
        this.dateEpoch = dateEpoch;
    }

    @JsonProperty("astro")
    public Astro getAstro() {
        return astro;
    }

    @JsonProperty("astro")
    public void setAstro(Astro astro) {
        this.astro = astro;
    }

    @JsonProperty("mintemp")
    public Integer getMintemp() {
        return mintemp;
    }

    @JsonProperty("mintemp")
    public void setMintemp(Integer mintemp) {
        this.mintemp = mintemp;
    }

    @JsonProperty("maxtemp")
    public Integer getMaxtemp() {
        return maxtemp;
    }

    @JsonProperty("maxtemp")
    public void setMaxtemp(Integer maxtemp) {
        this.maxtemp = maxtemp;
    }

    @JsonProperty("avgtemp")
    public Integer getAvgtemp() {
        return avgtemp;
    }

    @JsonProperty("avgtemp")
    public void setAvgtemp(Integer avgtemp) {
        this.avgtemp = avgtemp;
    }

    @JsonProperty("totalsnow")
    public Integer getTotalsnow() {
        return totalsnow;
    }

    @JsonProperty("totalsnow")
    public void setTotalsnow(Integer totalsnow) {
        this.totalsnow = totalsnow;
    }

    @JsonProperty("sunhour")
    public Integer getSunhour() {
        return sunhour;
    }

    @JsonProperty("sunhour")
    public void setSunhour(Integer sunhour) {
        this.sunhour = sunhour;
    }

    @JsonProperty("uv_index")
    public Integer getUvIndex() {
        return uvIndex;
    }

    @JsonProperty("uv_index")
    public void setUvIndex(Integer uvIndex) {
        this.uvIndex = uvIndex;
    }

    @JsonProperty("air_quality")
    public AirQuality__1 getAirQuality() {
        return airQuality;
    }

    @JsonProperty("air_quality")
    public void setAirQuality(AirQuality__1 airQuality) {
        this.airQuality = airQuality;
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
