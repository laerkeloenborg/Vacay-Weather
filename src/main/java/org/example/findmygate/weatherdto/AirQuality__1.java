
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
    "co",
    "no2",
    "o3",
    "so2",
    "pm2_5",
    "pm10",
    "us-epa-index",
    "gb-defra-index"
})
@Generated("jsonschema2pojo")
public class AirQuality__1 {

    @JsonProperty("co")
    private String co;
    @JsonProperty("no2")
    private String no2;
    @JsonProperty("o3")
    private String o3;
    @JsonProperty("so2")
    private String so2;
    @JsonProperty("pm2_5")
    private String pm25;
    @JsonProperty("pm10")
    private String pm10;
    @JsonProperty("us-epa-index")
    private String usEpaIndex;
    @JsonProperty("gb-defra-index")
    private String gbDefraIndex;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("co")
    public String getCo() {
        return co;
    }

    @JsonProperty("co")
    public void setCo(String co) {
        this.co = co;
    }

    @JsonProperty("no2")
    public String getNo2() {
        return no2;
    }

    @JsonProperty("no2")
    public void setNo2(String no2) {
        this.no2 = no2;
    }

    @JsonProperty("o3")
    public String getO3() {
        return o3;
    }

    @JsonProperty("o3")
    public void setO3(String o3) {
        this.o3 = o3;
    }

    @JsonProperty("so2")
    public String getSo2() {
        return so2;
    }

    @JsonProperty("so2")
    public void setSo2(String so2) {
        this.so2 = so2;
    }

    @JsonProperty("pm2_5")
    public String getPm25() {
        return pm25;
    }

    @JsonProperty("pm2_5")
    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    @JsonProperty("pm10")
    public String getPm10() {
        return pm10;
    }

    @JsonProperty("pm10")
    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    @JsonProperty("us-epa-index")
    public String getUsEpaIndex() {
        return usEpaIndex;
    }

    @JsonProperty("us-epa-index")
    public void setUsEpaIndex(String usEpaIndex) {
        this.usEpaIndex = usEpaIndex;
    }

    @JsonProperty("gb-defra-index")
    public String getGbDefraIndex() {
        return gbDefraIndex;
    }

    @JsonProperty("gb-defra-index")
    public void setGbDefraIndex(String gbDefraIndex) {
        this.gbDefraIndex = gbDefraIndex;
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
