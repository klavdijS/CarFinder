package com.example.klavdij.carfinder;

import android.content.Context;
import android.content.res.AssetManager;
import android.provider.ContactsContract;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class Utils {

    private static final String TAG = "Utils";

    public static List<Car> loadProfiles(Context context, JSONArray array){

        try{
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            List<Car> carList = new ArrayList<>();
            for(int i=0;i<array.length();i++){
                Car car = gson.fromJson(array.getString(i), Car.class);
                carList.add(car);
            }
            return carList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
