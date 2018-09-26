package com.example.kyurim.gas_station;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ExtrasActivity extends AppCompatActivity {

    static final String TAG = "---ExtraActivity";
    public static final String EXTRA_EXTRA_DETAIL_ID = "extraid";
    public static final String KEY1 = "ExtrasActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras);

        // ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CardView vehicleCareCardView = (CardView) findViewById(R.id.vehicle_care_card_view);
        vehicleCareCardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(TAG, "vehicle care");
            }
        });

        CardView findGasCardView = (CardView) findViewById(R.id.find_gas_card_view);
        findGasCardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(TAG, "find gas");
                Intent intent = new Intent(ExtrasActivity.this, FindGasActivity.class);
                intent.putExtra(KEY1, "TEST");
                startActivity(intent);
            }
        });

        CardView buyCarCardView = (CardView) findViewById(R.id.buy_car_card_view);
        buyCarCardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(TAG, "buy car");
            }
        });

        CardView destinationCardView = (CardView) findViewById(R.id.destination_card_view);
        destinationCardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(TAG, "destination");
            }
        });

        CardView findRideCardView = (CardView) findViewById(R.id.find_ride_card_view);
        findRideCardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(TAG, "find ride");
            }
        });

        CardView findParkingCardView = (CardView) findViewById(R.id.find_parking_card_view);
        findParkingCardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(TAG, "find parking");
            }
        });
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
