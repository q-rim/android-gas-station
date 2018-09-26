package com.example.kyurim.gas_station;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.kyurim.gas_station.utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;

public class FindGasActivity extends AppCompatActivity {

    static final String TAG = "---FindGasActivity";

    private TextView mUrlInTextView;
    private TextView mUrlOutTextView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_gas);

        // ToolBar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mUrlInTextView = (TextView) findViewById(R.id.url_in_text_view);
        mUrlOutTextView = (TextView) findViewById(R.id.url_out_text_view);

        makeSearchQuery();
    }

    private void makeSearchQuery() {
        double lat = 38.901222;
        double lon = -77.265259;

        mUrlInTextView.setText("Lat:  "+ lat + "\nLong:" + lon);
        URL searchUrl = NetworkUtils.buildUrl(lat, lon);
        new gasStationQueryTask().execute(searchUrl);
    }

    public class gasStationQueryTask extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {
            URL searchUrl = urls[0];
            String searchResults = null;
            try {
                searchResults = NetworkUtils.getResponseFromHttpUrl(searchUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return searchResults;
        }

        @Override
        protected void onPostExecute(String s) {
            if (s != null && !s.equals("")) {
                mUrlOutTextView.setText(s);
            }
        }
    }

    // Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate menu; Add items to AppBar
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // AppBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.live_help:
                Log.i(TAG, "LiveHelp Selected: " + item.getItemId());
                return true;
            case R.id.dropdown_extras:
                Log.i(TAG, "Extra Selected: " + item.getItemId());
                return true;
            case R.id.dropdown_help_center:
                Log.i(TAG, "Help Center Selected: " + item.getItemId());
                return true;
            case R.id.dropdown_feedback:
                Log.i(TAG, "Feedback Selected: " + item.getItemId());
                return true;
            case R.id.dropdown_report_bug:
                Log.i(TAG, "Report Bug Selected: " + item.getItemId());
                return true;
            case R.id.dropdown_legal:
                Log.i(TAG, "Legal Selected: " + item.getItemId());
                return true;
            default:
                Log.i(TAG, "Default Selected: " + item.getItemId());
                return super.onOptionsItemSelected(item);
        }
    }
}
