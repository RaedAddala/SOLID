package com.directi.training.srp.exercise_refactored;

public class CarNamingService implements ICarNamingService {
    private final ICarRepository _carRepository;

    public CarNamingService(ICarRepository carRepository) {
        this._carRepository = carRepository;
    }

    public String getCarsNames() {
        StringBuilder sb = new StringBuilder();
        for (Car car : _carRepository.getAllFromDb()) {
            sb.append(car.getBrand());
            sb.append(" ");
            sb.append(car.getModel());
            sb.append(", ");
        }
        return sb.length() > 2 ? sb.substring(0, sb.length() - 2) : "";
    };
}
