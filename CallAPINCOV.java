package API;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class CallAPINCOV {
    public static void main(String[] args) throws Exception{
        ArrayList<Country> countries = new ArrayList<>();
        String link = "https://apincov.herokuapp.com/countries";
        URL url = new URL(link);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        String inLine;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer response = new StringBuffer();

        while ((inLine = bufferedReader.readLine()) != null){
            response.append(inLine);
        }

        Object obj = (Object) JSONValue.parse(response.toString());
        JSONArray data = (JSONArray) obj;

        for (int i = 0; i < data.size(); i++) {
            JSONObject object = (JSONObject) data.get(i);
            Country country = new Country(object.get("Country_Region"), object.get("Confirmed"),
                    object.get("Deaths"), object.get("Recovered"));
            countries.add(country);
        }

        for (Country c : countries) {
            System.out.println(c);
        }
    }
}
