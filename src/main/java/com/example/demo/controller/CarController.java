package com.example.demo.controller;

import com.example.demo.entity.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public Car addCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @GetMapping("/cars")
    public List<Car> cars() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable Integer id) {
        return carService.getCarById(id);
    }

    @PutMapping("/update")
    public Car updateCar(@RequestBody Car car) {
        return carService.updateCar(car);
    }

    @DeleteMapping("/delete/{id}")
    public Car deleteCar(@PathVariable Integer id) {
        return carService.deleteCar(id);
    }
}
