package com.example.klavdij.carfinder;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Klavdij on 04/06/2017.
 */

public class CardFragment extends Fragment {

    private SwipePlaceHolderView mSwipeView;
    private Context mContext;
    private static final String requestUrl = "http://klavdij.gstarman.com/carData.json";
    private static AsyncHttpClient client = new AsyncHttpClient();

    FloatingActionButton acceptButton;
    FloatingActionButton rejectButton;


    @Override
    public void onStart() {
        super.onStart();
        final View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Test klik","Klikllik");
            }
        };
        client.get(requestUrl, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.d("JSON", String.valueOf(response));
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                // Pull out the first event on the public timeline
                JSONObject firstEvent = null;
                try {
                    firstEvent = (JSONObject) timeline.get(0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Context context = getActivity().getApplicationContext();

                for(Car car : Utils.loadProfiles(context,timeline)) {
                    TinderCard tinderCard  = new TinderCard(mContext, car, mSwipeView);
                    mSwipeView.addView(tinderCard);
                }
                
            }
        });
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.card_fragment_layout,container,false);
        mSwipeView = (SwipePlaceHolderView)rootView.findViewById(R.id.swipeView);
        mContext = getActivity().getApplicationContext();

        acceptButton = (FloatingActionButton) rootView.findViewById(R.id.acceptBtn);
        rejectButton = (FloatingActionButton) rootView.findViewById(R.id.rejectBtn);

        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.swipe_out_msg_view));


        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(true);
            }
        });

        rejectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(false);
            }
        });

        return rootView;
    }
}
