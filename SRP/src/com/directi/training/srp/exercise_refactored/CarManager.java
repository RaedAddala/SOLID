package com.directi.training.srp.exercise_refactored;

public class CarManager {
    private final CarRepository _carRepository;

    public CarManager(final CarRepository _carRepository) {
        this._carRepository = _carRepository;
    }

    public Car getCar(final String carId) {
        return _carRepository.getFromDb(carId);
    }

    public String getCarsNames() {
        StringBuilder sb = new StringBuilder();
        for (Car car : _carRepository.getAllFromDb()) {
            sb.append(car.getBrand());
            sb.append(" ");
            sb.append(car.getModel());
            sb.append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    public Car getBestCar() {
        Car bestCar = null;
        for (Car car : _carRepository.getAllFromDb()) {
            if (bestCar == null || car.getModel().compareTo(bestCar.getModel()) > 0) {
                bestCar = car;
            }
        }
        return bestCar;
    }
}
