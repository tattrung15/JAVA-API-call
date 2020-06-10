package API;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CallAPIDemo {
    public static void main(String[] args) throws Exception {
        String link = "https://code.junookyo.xyz/api/ncov-moh/data.json";
        String inputLine;

        URL url = new URL(link);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

//        int responseCode = con.getResponseCode();
//        System.out.println("Sending 'GET' request to URL : " + url);
//        System.out.println("Response code: " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null){
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
        //{"success":true,"data":{"global":{"cases":"173051","deaths":"6664","recovered":"77783"},"vietnam":{"cases":"59","deaths":"0","recovered":"16"}}}
        Object jsObj = JSONValue.parse(response.toString());
        JSONObject json = (JSONObject) jsObj;
        JSONObject jsonData = (JSONObject) json.get("data");
        JSONObject jsonGlobal = (JSONObject) jsonData.get("global");
        System.out.println(jsonGlobal.toString());
        //{"recovered":"77783","cases":"173051","deaths":"6664"}
        System.out.println(jsonGlobal.get("cases"));
        //173051
    }
}
