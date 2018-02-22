package ilo.ilo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.lang.Exception;
import android.os.AsyncTask;

import org.json.JSONObject;

public class HttpGETRequest extends AsyncTask<String, Void, JSONObject>{

    @Override
    protected JSONObject doInBackground(String... params){

        String stringUrl = params[0];

        JSONObject json;
        try {
            json = JSONReader.readJsonFromUrl(stringUrl);
        } catch(Exception e) {
            json = null;
        }
        return json;
    }
    protected void onPostExecute(JSONObject result){
        super.onPostExecute(result);
    }


}
