package com.example.klavdij.carfinder;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Klavdij on 04/06/2017.
 */

public class AdFragment extends Fragment {

    protected RecyclerView recyclerView;
    protected RecyclerView.LayoutManager layoutManager;
    protected CarAdapter carAdapter;
    private Context mContext;
    List<Car> carList = new ArrayList<Car>();

    private static final String requestUrl = "http://klavdij.gstarman.com/carData.json";
    private static AsyncHttpClient client = new AsyncHttpClient();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View rootView = inflater.inflate(R.layout.ads_fragment_layout,container,false);

        mContext = getActivity().getApplicationContext();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.ads_recycler_view);

        layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(new CarAdapter(mContext,carList));

        carList = DataHolder.getInstance().getLikedCarList();

        carAdapter = new CarAdapter(mContext,carList);
        recyclerView.setAdapter(carAdapter);

        return rootView;
    }

}
