package com.example.kyurim.gas_station;

import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class ExtrasActivity extends AppCompatActivity {

    final static String TAG = "---ExtraActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras);

        // ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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