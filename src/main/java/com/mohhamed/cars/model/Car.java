package com.mohhamed.cars.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private String Brand;
 
 
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getBrand() {
    return Brand;
}
public void setBrand(String brand) {
    Brand = brand;
}

   

}
