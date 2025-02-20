package com.directi.training.srp.exercise_refactored;

public interface ICarService {
    public Car getCar(final String carId);
    public String getCarsNames();
    public Car getBestCar();
}
