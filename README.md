# SOLID Principles

This repository is made in the context of a Software Architecture Course by [Dr. Lilia Sfaxi](https://insatunisia.github.io/TP-ArchLog/tp1/)

This is our lab  report. It was made by:

- Raed Addala [@RaedAddala](https://www.github.com/RaedAddala)
- Mohamed Aziz Ben Ghorbel [@AziizBg](https://www.github.com/AziizBg)
- Zied Maghraoui [@ZiedMaghraoui](https://www.github.com/ZiedMaghraoui)
- Mohamed Zouaghi [@zouaghista](https://www.github.com/zouaghista)

## SRP( Single Responsability Principle)

Following the SRP, we refactored the classes found in `./SRP/src/exercise` into `./SRP/src/exercise_refactored`.

We split `CarManager` class into `CarManager` and `CarRepository` where the later will handle CRUD operations to the Database (in-memory database).
Here is the old classes diagram UML:
<!--
@startuml oldSRPDiagram
class CarManager {
    + Car getFromDb(final String carId)
    + String getCarsNames()
    + Car getBestCar()
}
class Car{
    - final String _id
    - final String_model
    - final String _brand
- Car(final String id, final String model, final String brand)
- String getId()
- String getModel()
- String getBrand()
}
CarManager *-- Car
@enduml
-->
![oldSRPDiagram](./oldSRPDiagram.svg)

Here is the new classes diagram UML:

<div hidden>
@startuml newSRPDiagram

' Interfaces
interface ICarRepository {

- void addToDb(String id, String model, String brand)
- Car getFromDb(String carId)
- List<Car> getAllFromDb()
}

interface ICarService {

- Car getCar(String carId)
- String getCarsNames()
- Car getBestCar()
}

interface ICarNamingService {

- String getCarsNames()
}

interface ICarComparatorService {

- Car getBestCar()
}

' Classes
class Car {

- final String _id
- final String _model
- final String _brand

- Car(String id, String model, String brand)
- String getId()
- String getModel()
- String getBrand()
}

class CarManager {

- final ICarService _CarService

- CarManager()
- Car getCar(String carId)
- String getCarsNames()
- Car getBestCar()
}

class CarRepository {

- List<Car> _carsDb
- static CarRepository _instance
- CarRepository()

- static CarRepository getInstance()
- void addToDb(String id, String model, String brand)
- Car getFromDb(String carId)
- List<Car> getAllFromDb()
}

class CarService {

- final ICarRepository _carRepository
- final ICarNamingService _carNamingService
- final ICarComparatorService _carComparatorService

- CarService(ICarRepository, ICarNamingService, ICarComparatorService)
- Car getCar(String carId)
- String getCarsNames()
- Car getBestCar()
}

class CarNamingService {

- final ICarRepository _carRepository

- CarNamingService(ICarRepository carRepository)
- String getCarsNames()
}

class CarComparatorService {

- final ICarRepository _carRepository

- CarComparatorService(ICarRepository carRepository)
- Car getBestCar()
}

' Relationships
CarRepository ..|> ICarRepository
CarRepository "1" *-- "many" Car : contains >
CarRepository ..> Car : creates >

CarService ..|> ICarService
CarService --> ICarRepository : uses >
CarService --> ICarNamingService : uses >
CarService --> ICarComparatorService : uses >

CarNamingService ..|> ICarNamingService
CarNamingService --> ICarRepository : uses >

CarComparatorService ..|> ICarComparatorService
CarComparatorService --> ICarRepository : uses >

CarManager --> ICarService : uses >
CarManager ..> CarRepository : instantiates >
CarManager ..> CarNamingService : instantiates >
CarManager ..> CarComparatorService : instantiates >

note right of CarRepository: Singleton pattern

@enduml
<div>
![newSRPDiagram](./newSRPDiagram.svg)
