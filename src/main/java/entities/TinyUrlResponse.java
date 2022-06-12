package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TinyUrlResponse {

    @JsonProperty("short_key")
    public String shortKey;

    @JsonProperty("http_host")
    public String httpHost;

    @JsonProperty("short_url")
    public  String shortUrl;

}
