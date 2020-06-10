package API;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class CallAPIProduct {
    public static void main(String[] args) throws IOException {
        ArrayList<Product> list = new ArrayList<>();
        String link = "http://hdk-shop.herokuapp.com/api/products";
        URL url = new URL(link);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        String inLine;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer response = new StringBuffer();

        while ((inLine = bufferedReader.readLine()) != null){
            response.append(inLine);
        }

        Object obj = (Object) JSONValue.parse(response.toString());
        JSONObject products = (JSONObject) obj;
        JSONArray data = (JSONArray) products.get("products");

        for (int i = 0; i < data.size(); i++) {
            JSONObject object = (JSONObject) data.get(i);
            Product product = new Product(object.get("_id"), object.get("name"), object.get("description"),
                                            object.get("price"), object.get("total"));
            list.add(product);
        }

        for (Product p : list) {
            System.out.println(list);
        }

    }
}
