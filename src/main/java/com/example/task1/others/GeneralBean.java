package com.example.task1.others;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GeneralBean {
    @Autowired
    private List<Car> cars;

    public Car getCar() {
        return car;
    }

    @Autowired
    private Car car;

    public void printCars() {
        for (Car car : cars) {
            System.out.println(car.getCar());
        }
    }
}