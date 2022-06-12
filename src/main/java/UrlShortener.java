import com.fasterxml.jackson.databind.ObjectMapper;
import entities.TinyUrlResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.URLEncoder;

public class UrlShortener {
    public  final String domain;
    public final OkHttpClient okHttpClient;

    public UrlShortener(String domain, OkHttpClient okHttpClient) {
        this.domain=domain;
        this.okHttpClient=okHttpClient;
    }

    public  String addUrlLongUrlParams(String longUrl){
        return this.domain+"?name="+
                URLEncoder.encode(longUrl)
                +"&opaque=1";
    }

    public  TinyUrlResponse makeUrlShortenCall(String longUrl) throws IOException {

        // Create request object
        Request request = new Request.Builder()
                .url(this.addUrlLongUrlParams(longUrl))
                .addHeader("accept","application/json")
                .build();
        //make http get request
        Response response = this.okHttpClient.newCall(request).execute();

        String jsonData=response.body().string();
        ObjectMapper om = new ObjectMapper();


        return om.readValue(jsonData, TinyUrlResponse.class);




    }


}
