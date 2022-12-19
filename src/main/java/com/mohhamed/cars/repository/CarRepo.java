package com.mohhamed.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohhamed.cars.model.Car;

@Repository
public interface CarRepo extends JpaRepository<Car,Integer> {
    
}
