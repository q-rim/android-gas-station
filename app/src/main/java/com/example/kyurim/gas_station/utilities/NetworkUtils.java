package com.example.kyurim.gas_station.utilities;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {

    final static String TAG = "---NetworkUtils";
    final static String BASE_URL = "http://devapi.mygasfeed.com/stations/radius/";
    final static String BASE_URL_TAIL = "/1/reg/distance/rfej9napna.json";
    final static String div = "/";

    public static URL buildUrl(double lat, double lon) {
        String uri = BASE_URL + lat + div + lon + BASE_URL_TAIL;
        Log.i(TAG, uri);
        URL url = null;
        try {
            url = new URL(uri);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
