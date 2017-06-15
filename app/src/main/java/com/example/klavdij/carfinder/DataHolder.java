package com.example.klavdij.carfinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Klavdij on 15/06/2017.
 */

class DataHolder {
    private static final DataHolder ourInstance = new DataHolder();

    static DataHolder getInstance() {
        return ourInstance;
    }

    private List<Car> likedCarList = new ArrayList<Car>();

    private DataHolder() {
    }

    public List<Car> getLikedCarList() {
        return likedCarList;
    }
    public void setLikedCarList(List<Car> carList) {
        likedCarList = carList;
    }

    public void addLikedCar (Car car) {
        likedCarList.add(car);
    }
}
