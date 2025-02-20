package com.directi.training.srp.exercise_refactored;

public class CarManager {
    private final ICarService _CarService;

    public CarManager() {
        ICarRepository carRepository = CarRepository.getInstance();
        ICarNamingService carNamingService = new CarNamingService(carRepository);
        ICarComparatorService carComparatorService = new CarComparatorService(carRepository);
        this._CarService = new CarService(carRepository, carNamingService, carComparatorService);
    }

    public Car getCar(final String carId) {
        return _CarService.getCar(carId);
    }

    public String getCarsNames() {
        return _CarService.getCarsNames();

    }

    public Car getBestCar() {
        return _CarService.getBestCar();
    }
}
