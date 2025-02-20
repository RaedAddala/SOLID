package com.directi.training.srp.exercise_refactored;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements ICarRepository {

    private List<Car> _carsDb = new ArrayList<Car>();
    private static CarRepository _instance = null;

    private CarRepository() {
    }

    public static CarRepository getInstance() {
        if (_instance == null) {
            _instance = new CarRepository();
        }
        return _instance;
    }

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
