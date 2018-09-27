package com.example.kyurim.gas_station;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class GasStationViewAdapter extends RecyclerView.Adapter<GasStationViewAdapter.ViewHolder> {

    private static final String TAG = "---GasStationViewAdapter";

    private String[] lat;
    private String[] lng;
    private String[] price;
    private String[] dist;
    private String[] station;
    private String[] address;
    private Listener listener;

    // onclick for RecyclerView - RecyclerView does not come with built in onClick listener.  Must provide your own.
    interface Listener {
        void onClick(int position);
    }

    // Activities and Fragments will use this method to register as Listener.
    public void setListener(Listener listener) {
        this.listener = listener;                                                   // Register a listener.
    }

    public GasStationViewAdapter(String[] price, String[] dist, String[] station, String[] address) {       // Constructor
        this.price = price;
        this.dist = dist;
        this.station = station;
        this.address = address;
    }

    @Override
    public GasStationViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // onCreateViewHolder() method gets called when the RecyclerView needs to create a ViewHolder.

        CardView cardView = (CardView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_gas_stations, viewGroup, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull GasStationViewAdapter.ViewHolder holder, final int position) {
    // RecyclerView calls this method when it wants to use (or reuse) a ViewHolder for a new piece of data.
        CardView cardView = holder.cardView;

        // TextView - set Price
        TextView priceTextView = (TextView) cardView.findViewById(R.id.price_cv_textview);
        priceTextView.setText(price[position]);

        // TextView - set Station
        TextView stationTextView = (TextView) cardView.findViewById(R.id.gas_station_cv_textview);
        stationTextView.setText(station[position]);

        // TextView - set Address
        TextView addressTextView = (TextView) cardView.findViewById(R.id.address_cv_textview);
        addressTextView.setText(address[position]);

        // TextView - set Distance
        TextView distanceTextView = (TextView) cardView.findViewById(R.id.dist_cv_textview);
        distanceTextView.setText(dist[position]);

        // CardView Listener
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return price.length;       // number of items in RecyclerView - This is important!
    }

    // Card ViewHolder Inner Class
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Define View to be used for each data item.
        // ViewHolder defines what View or Views the RecyclerView should use for each data item given.

        private CardView cardView;
        public ViewHolder(CardView itemView) {
            super(itemView);
            cardView = itemView;
        }
    }
}
