package com.mohhamed.cars.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mohhamed.cars.model.Car;
import com.mohhamed.cars.repository.CarRepo;
import com.mysql.cj.xdevapi.PreparableStatement;

@Component
public class carDAL {

    @Autowired
    CarRepo repo;     
    public List<Car> getAllCar() {
       return repo.findAll();

    }

    public Optional<Car> getCar(int id) {
      Optional<Car> car= repo.findById(id);
      return car;
    }

    public void insert(Car car){
        repo.save(car);
    }

    public void updateCar(Car car) {
        repo.save(car);
    }


    public void delete(int id){
         repo.deleteById(id);
    }


}
