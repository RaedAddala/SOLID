package com.directi.training.srp.exercise_refactored;

import java.util.List;

public interface ICarRepository {

    public void addToDb(final String id, final String model, final String brand);

    public Car getFromDb(final String carId);

    public List<Car> getAllFromDb();
}
