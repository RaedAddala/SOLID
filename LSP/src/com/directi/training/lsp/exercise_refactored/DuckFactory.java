package com.directi.training.lsp.exercise_refactored;

public class DuckFactory {
    public static IDuck getNormalDuck(){
        return new Duck();
    }

    public static IDuck getElectronicDuck(){
        ElectronicDuck duck = new ElectronicDuck();
        duck.turnOn();
        return duck;
    }
}
