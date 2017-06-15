package com.example.klavdij.carfinder;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.google.gson.Gson;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;
import com.mindorks.placeholderview.annotations.swipe.SwipeView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import org.w3c.dom.Text;

import java.io.Serializable;

/**
 * Created by Klavdij on 04/06/2017.
 */

@Layout(R.layout.card_view)
public class TinderCard {

    @View(R.id.imageCarousel)
    private CarouselView imageCarousel;

    @View(R.id.nameAgeTxt)
    private TextView nameAgeTxt;

    @View(R.id.locationNameTxt)
    private TextView locationNameTxt;

    @View(R.id.car_mileage)
    private TextView carMileageTxt;

    @View(R.id.car_price)
    private TextView carPriceTxt;


    private Car mCar;
    private Context mContext;
    private SwipePlaceHolderView mSwipeView;

    public TinderCard(Context context, Car car, SwipePlaceHolderView swipeView) {
        mContext = context;
        mCar = car;
        mSwipeView = swipeView;
    }


    @Resolve
    private void onResolved(){
        ImageListener imageListener = new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                Glide.with(mContext).load(mCar.getImageUrls()[position]).centerCrop().into(imageView);
            }
        };
        imageCarousel.setImageListener(imageListener);
        imageCarousel.setPageCount(mCar.getImageUrls().length);
        imageCarousel.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent (mContext, CarViewActivity.class);
                intent.putExtra("car",mCar);
                mContext.startActivity(intent);
            }
        });
        nameAgeTxt.setText(mCar.getManufacturer()+" "+mCar.getModel()+ ", " + mCar.getYear());
        locationNameTxt.setText(mCar.getLocationName());
        carMileageTxt.setText(Integer.toString(mCar.getMileage())+ " KM");
        carPriceTxt.setText(Integer.toString(mCar.getPrice())+ " €");
    }

    @SwipeOut
    private void onSwipedOut(){
        Log.d("EVENT", "onSwipedOut");
        mSwipeView.addView(this);
    }

    @SwipeCancelState
    private void onSwipeCancelState(){
        Log.d("EVENT", "onSwipeCancelState");
    }

    @SwipeIn
    private void onSwipeIn(){
        Log.d("EVENT", "onSwipedIn");
        DataHolder.getInstance().addLikedCar(mCar);
    }

    @SwipeInState
    private void onSwipeInState(){
        Log.d("EVENT", "onSwipeInState");
    }

    @SwipeOutState
    private void onSwipeOutState(){
        Log.d("EVENT", "onSwipeOutState");
    }


    @Click(R.id.tinder_car_card)
    private void onClick() {
        Log.d("Click","PLS CLICK");
    }
}
