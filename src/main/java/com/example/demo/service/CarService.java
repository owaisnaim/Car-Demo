package com.example.demo.service;

import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    public Car saveCar(Car car){
        return carRepository.save(car);
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public Car getCarById(Integer id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car updateCar(Car car) {
        Car newCar = getCarById(car.getCarId());
        newCar.setName(car.getName());
        return carRepository.save(newCar);
    }

    public Car deleteCar(Integer id) {
        Car deletedCar= getCarById(id);
        carRepository.deleteById(id);
        return deletedCar;
    }
}
