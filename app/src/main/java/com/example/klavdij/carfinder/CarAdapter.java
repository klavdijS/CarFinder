package com.example.klavdij.carfinder;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Klavdij on 07/06/2017.
 */

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    private List<Car> cars;
    private Context context;

    public CarAdapter (Context context, List<Car> cars) {
        this.context = context;
        this.cars = cars;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ad_row_layout,parent,false);
        CarViewHolder cvh = new CarViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, final int position) {
        holder.bind(cars.get(position));
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class CarViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView carName;
        TextView carPrice;
        TextView carLocation;
        ImageView carImage;

        public CarViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.card_list_car);
            carName = (TextView) itemView.findViewById(R.id.car_name);
            carPrice = (TextView) itemView.findViewById(R.id.car_price_card);
            carImage = (ImageView) itemView.findViewById(R.id.car_photo);
            carLocation = (TextView) itemView.findViewById(R.id.car_location);
        }


        public void bind(final Car car) {
            carName.setText(car.getManufacturer()+" "+car.getModel());
            carPrice.setText(Integer.toString(car.getPrice())+" €");
            carLocation.setText(car.getLocationName());
            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent (context, CarViewActivity.class);
                    intent.putExtra("car",car);
                    context.startActivity(intent);
                }
            });
            Glide.with(context).load(car.getImageUrls()[0]).centerCrop().into(carImage);
        }
    }
}
