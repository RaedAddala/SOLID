package com.directi.training.srp.exercise_refactored;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private List<Car> _carsDb = new ArrayList<Car>();

    public void addToDb(final String id, final String model, final String brand) {
        _carsDb.add(new Car(id, model, brand));
    }

    public Car getFromDb(final String carId) {
        for (Car car : _carsDb) {
            if (car.getId().equals(carId)) {
                return car;
            }
        }
        return null;
    }

    public List<Car> getAllFromDb() {
        return _carsDb;
    }
}
