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

//    // Menu
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
            case R.id.action_create_order:
                Log.i(TAG, "Option clicked - case: " + item.getItemId());
                return true;
            case R.id.live_help:
                Log.i(TAG, "Option clicked - case: " + item.getItemId());
                return true;
            default:
                Log.i(TAG, "Option clicked - case: " + item.getItemId());
                return super.onOptionsItemSelected(item);
        }
    }
}
