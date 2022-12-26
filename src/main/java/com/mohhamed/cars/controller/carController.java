package com.mohhamed.cars.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mohhamed.cars.DAL.carDAL;
import com.mohhamed.cars.model.Car;

@RestController
@RequestMapping(value = "/")
public class carController {

    @Autowired
    carDAL dal;

    @GetMapping(value = "/")
    public List<Car> index() {

        return dal.getAllCar();

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> view(@PathVariable int id) {
        Optional<Car> car = dal.getCar(id);
        return   car.isPresent()? new ResponseEntity<Car>(car.get(), HttpStatus.OK):ResponseEntity.notFound().build();
        
    }

    @PostMapping(value = "/")
    public Car store(@RequestBody Car car) {
        dal.insert(car);

        return car;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (dal.isExist(id)) {
            dal.delete(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping(value = "/")
    public ResponseEntity<?> update(@RequestBody Car car) {
        if (dal.isExist(car.getId())){
            dal.updateCar(car);
            return new ResponseEntity<Car>( dal.getCar(car.getId()).get(),HttpStatus.OK);
         
        }
        else{
           return ResponseEntity.notFound().build();
        }
    }

}
