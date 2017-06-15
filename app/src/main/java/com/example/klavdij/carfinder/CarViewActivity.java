package com.example.klavdij.carfinder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import org.w3c.dom.Text;

public class CarViewActivity extends AppCompatActivity {

    Car mCar;
    Context mContext;

    //View elements from acitivty
    CarouselView carouselView;
    TextView carTitle;
    TextView carYear;
    TextView carLocation;
    TextView firstRegistration;
    TextView mileage;
    TextView used;
    TextView engineType;
    TextView enginePower;
    TextView engineHorsePower;
    TextView isManual;
    TextView priceLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_view);
        Toolbar toolbar = (Toolbar)findViewById(R.id.car_view_toolbar);
        mContext = getApplicationContext();
        mCar = (Car) getIntent().getSerializableExtra("car");

        //Setup view elements
        carTitle = (TextView) findViewById(R.id.carTitle);
        carTitle.setText(mCar.getManufacturer()+ " "+ mCar.getModel());
        carYear = (TextView) findViewById(R.id.carYear);
        carYear.setText(", "+Integer.toString(mCar.getYear()));
        carLocation = (TextView) findViewById(R.id.carLocation);
        carLocation.setText(mCar.getLocationName());

        firstRegistration = (TextView)findViewById(R.id.firstRegistrationValue);
        firstRegistration.setText(mCar.getFirstRegistration());
        mileage = (TextView) findViewById(R.id.mileageValue);
        mileage.setText(Integer.toString(mCar.getMileage())+ " KM");
        used = (TextView) findViewById(R.id.usedLabel);
        if (mCar.isUsed()) {
            used.setText("Used");
        } else {
            used.setText("New");
        }
        engineType = (TextView) findViewById(R.id.engineTypeLabel);
        engineType.setText(mCar.getEngineType()+ ", "+Integer.toString(mCar.getEngineVolume())+ " ccm");
        enginePower = (TextView) findViewById(R.id.enginePower);
        enginePower.setText(Integer.toString(mCar.getPower())+ " kW");
        engineHorsePower = (TextView) findViewById(R.id.engineHorsePower);
        engineHorsePower.setText(Integer.toString(mCar.getHorsePower())+ " HP");
        isManual = (TextView) findViewById(R.id.manualLabel);
        if (mCar.isManual()) {
            isManual.setText("Manual");
        } else {
            isManual.setText("Automatic");
        }
        priceLabel = (TextView) findViewById(R.id.priceLabelValue);
        priceLabel.setText(Integer.toString(mCar.getPrice())+ " €");
        //Setup toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(mCar.getManufacturer()+" "+mCar.getModel()+ ", "+mCar.getYear());

        //Setup carousel

        carouselView = (CarouselView) findViewById(R.id.carouselView_carView);
        carouselView.setPageCount(mCar.getImageUrls().length);
        carouselView.setImageListener(imageListener);


    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            Glide.with(mContext).load(mCar.getImageUrls()[position]).centerCrop().into(imageView);
        }
    };

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
