package com.directi.training.srp.exercise_refactored;

public class CarComparatorService implements ICarComparatorService {
    private final ICarRepository _carRepository;

    public CarComparatorService(ICarRepository carRepository) {
        this._carRepository = carRepository;
    }

    public Car getBestCar() {

        Car bestCar = null;
        for (Car car : _carRepository.getAllFromDb()) {
            if (bestCar == null || car.getModel().compareTo(bestCar.getModel()) > 0) {
                bestCar = car;
            }
        }
        return bestCar;
    };
}
