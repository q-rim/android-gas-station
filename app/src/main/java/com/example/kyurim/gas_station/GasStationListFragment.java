package com.example.kyurim.gas_station;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GasStationListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GasStationListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GasStationListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    public static final String INTENT_KEY= "IntentKEY-GasStationListFragment";
    private static final String TAG = "---GasStationListFrag";

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public GasStationListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GasStationListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GasStationListFragment newInstance(String param1, String param2) {
        GasStationListFragment fragment = new GasStationListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        RecyclerView gasStationRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_gas_station_list, container, false);
        final GasStation[] gasStations = {
            new GasStation("38.901371", "-77.265442", "3.55", "0 miles", "BP", "102 Maple Ave W"),
            new GasStation("38.898529", "-77.269012", "3.60", "0.3 miles", "Sunoco", "252 Maple Ave W"),
            new GasStation("38.906872", "-77.258530", "3.69", "0.5 miles", "Raceway", "395 Maple Ave W"),
            new GasStation("38.907661", "-77.257561", "3.79", "0.6 miles", "Citgo", "410 Maple Ave W"),
            new GasStation("38.893559", "-77.275398", "3.60", "0.8 miles", "Sunoco", "545 Maple Ave W")
        };

        final int gasArrLen = gasStations.length;

        // String arrary of Lat
        String[] latArr = new String[gasArrLen];
        for (int i = 0; i < gasArrLen; i++) {
            latArr[i] = gasStations[i].getLat();
        }

        // String arrary of Lng
        String[] lngArr = new String[gasArrLen];
        for (int i = 0; i < gasArrLen; i++) {
            lngArr[i] = gasStations[i].getLng();
        }

        // String array of Price
        final String[] priceArr = new String[gasArrLen];
        for (int i = 0; i < gasArrLen; i++) {
            priceArr[i] = gasStations[i].getPrice();
        }

        // String array of Distance
        String[] distArr = new String[gasArrLen];
        for (int i = 0; i < gasArrLen; i++) {
            distArr[i] = gasStations[i].getDist();
        }

        // String array of Station
        String[] stationArr = new String[gasArrLen];
        for (int i = 0; i < gasArrLen; i++) {
            stationArr[i] = gasStations[i].getStation();
        }

        // String array of Address
        String[] addressArr = new String[gasArrLen];
        for (int i = 0; i < gasArrLen; i++) {
            addressArr[i] = gasStations[i].getAddress();
        }

        GasStationViewAdapter adapter = new GasStationViewAdapter(priceArr, stationArr, addressArr, distArr);
        gasStationRecycler.setAdapter(adapter);

        // Display CardView using LinearLayout (vertical List)
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        gasStationRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new GasStationViewAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Log.i(TAG, "onClick():  position: " + position);
                Log.i(TAG, "price: " + priceArr[position]);

//                Intent intent = new Intent(getActivity(), GasStationDetailedActivity.class);
//                intent.putExtra(INTENT_KEY, gasStations[position]);
//                getActivity().startActivity(intent);
            }
        });

        return gasStationRecycler;

//        return inflater.inflate(R.layout.fragment_gas_station_list, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
