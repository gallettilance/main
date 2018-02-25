package ilo.ilo;


import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;
import javax.net.ssl.HttpsURLConnection;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;

public class HttpPOSTRequest extends AsyncTask<String, Void, String> {

    private static final String REQUEST_METHOD = "POST";
    private static final int READ_TIMEOUT = 1000000;
    private static final int CONNECTION_TIMEOUT = 1000000;

    @Override
    protected String doInBackground(String... params){

        String stringUrl = params[0];
        String firstName = params[1];
        String lastName = params[2];
        String email = params[3];
        String password = params[4];
        int yearOfBirth = Integer.parseInt(params[5]);


        JSONObject myjson = new JSONObject();

        try {

            myjson.put("user_first_name", firstName);
            myjson.put("user_last_name", lastName);
            myjson.put("user_email", email);
            myjson.put("user_password", password);
            myjson.put("user_year_birth", yearOfBirth);

            URL url = new URL(stringUrl+getPostDataString(myjson));
            HttpsURLConnection connection =(HttpsURLConnection) url.openConnection();

            connection.setRequestMethod(REQUEST_METHOD);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setConnectTimeout(CONNECTION_TIMEOUT);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setDoInput(true);

            String body = myjson.toString();
            OutputStream outputStream = new BufferedOutputStream(connection.getOutputStream());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "utf-8"));
            writer.write(body);
            writer.flush();
            writer.close();
            outputStream.close();

            connection.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            connection.disconnect();
            return response.toString();
        }

        catch(Exception e) {
            return "Exception: " + e.getMessage();
        }
    }

    private String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;
        Iterator<String> itr = params.keys();

        while(itr.hasNext()){
            String key= itr.next();
            Object value = params.get(key);

            if (first) {
                first = false;
                result.append("?");
            } else {
                result.append("&");
            }

            result.append(key);
            result.append("=");
            result.append(value.toString());
        }

        return result.toString();
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Log.e("Result", result);
    }
}