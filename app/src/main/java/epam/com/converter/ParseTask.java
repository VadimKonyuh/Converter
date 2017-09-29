package epam.com.converter;

import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by homepc on 28.09.2017.
 */
public class ParseTask extends AsyncTask<Void, Void, String> {


    public static String LOG_TAG = "my_log";
    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;
    String resultJson = "";
    Double value;
    String key;
    static HashMap<String, Double> map = new HashMap<>();



    @Override
    protected String doInBackground(Void... params) {
        // получаем данные с внешнего ресурса
        try {
            URL url = new URL("http://api.fixer.io/latest");

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            resultJson = buffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultJson;
    }

    @Override
    protected void onPostExecute(String strJson) {
        super.onPostExecute(strJson);
        // выводим целиком полученную json-строку
        Log.d(LOG_TAG, strJson);


        try {
            JSONObject rates = new JSONObject(strJson).getJSONObject("rates");
            /*
            double value = rates.getDouble("AUD");
            String StringValue = Double.toString(value);
            Log.d(LOG_TAG, StringValue);
            */
            Iterator<?> keys = rates.keys();
            while(keys.hasNext()) {
                String key = (String) keys.next();
                value = rates.getDouble(key);
                map.put(key, value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        for(Map.Entry<String, Double> e : map.entrySet()) {
            Log.d(LOG_TAG, e.getKey() + ", " + e.getValue());
        }
;

    }

    public HashMap<String, Double> getMap() {
        return map;
    }
}

