import com.fasterxml.jackson.databind.ObjectMapper;
import entities.TinyUrlResponse;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
//import com.squareup.okhttp.FormEncodingBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
public class HelloWorld {

    public static String addUrlLongUrlParams(String domain,String longUrl){

        return domain+"?name="+
                URLEncoder.encode(longUrl)
                +"&opaque=1";

    }



    public static void main(String args[]){
        System.out.println("hello ");


        String domain="http://tiny.some.com/submit/url";
        String longUrl="https://www.javatpoint.com/spring-tutorial-dependency-injection-by-constructor";


        UrlShortener urlShortenerClient = new UrlShortener(domain,new OkHttpClient());
        try{
            TinyUrlResponse responseJsonObject=urlShortenerClient.makeUrlShortenCall(longUrl);
            System.out.println("Short url is "+responseJsonObject.shortUrl);

        }
        catch(Exception e){
            e.printStackTrace();

        }




    }



}
