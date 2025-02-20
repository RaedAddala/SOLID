package com.directi.training.srp.exercise_refactored;

public class CarService implements ICarService {

    private final ICarRepository _carRepository;
    private final ICarNamingService _carNamingService;
    private final ICarComparatorService _carComparatorService;

    CarService(
            ICarRepository _carRepository,
            ICarNamingService _carNamingService,
            ICarComparatorService _carComparatorService) {
        this._carComparatorService = _carComparatorService;
        this._carNamingService = _carNamingService;
        this._carRepository = _carRepository;
    }

    public Car getCar(String carId) {
        return _carRepository.getFromDb(carId);
    }

    public String getCarsNames() {
        return _carNamingService.getCarsNames();
    }

    public Car getBestCar() {
        return _carComparatorService.getBestCar();
    }

}
