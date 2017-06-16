package com.example.klavdij.carfinder;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Klavdij on 04/06/2017.
 */

public class LocationFragment extends Fragment implements OnMapReadyCallback {

    MapView mapView;
    private GoogleMap mGoogleMap;
    View mView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        mView = inflater.inflate(R.layout.location_fragment_layout, container, false);

        return mView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (MapView) mView.findViewById(R.id.mapView);
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady (GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        mGoogleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(46.056946, 14.505751)).zoom(8).build();


        //setup all markers for our liked cars!

        List<Car> carList = DataHolder.getInstance().getLikedCarList();
        for (int i = 0; i < carList.size(); i++) {
            Car currentCar = carList.get(i);
            LatLng position = new LatLng(Double.parseDouble(currentCar.getLocationLattitude()), Double.parseDouble(currentCar.getLocationLongitude()));
            MarkerOptions markerOptions = new MarkerOptions().position(position).title(currentCar.getManufacturer()+" "+currentCar.getModel()+", "+ currentCar.getLocationName());
            googleMap.addMarker(markerOptions);
        }
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
