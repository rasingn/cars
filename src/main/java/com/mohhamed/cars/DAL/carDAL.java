package com.mohhamed.cars.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mohhamed.cars.config.MySqLConnector;
import com.mohhamed.cars.model.Car;
import com.mysql.cj.xdevapi.PreparableStatement;

@Component
public class carDAL {

          
    public List<Car> getAllCar() {
        MySqLConnector con = new MySqLConnector();
        String q = "select * from car";
        // init list
        List<Car> carlist=new ArrayList<Car>();
        try {
            
            PreparedStatement pre = con.connect().prepareStatement(q);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                Car car = new Car();
                car.setId(result.getInt("id"));
                car.setBrand(result.getString("name"));
                //insert to list
                carlist.add(car);
            }
        } catch (Exception ex) {

        } finally {
            con.disconnect();
        }
        return carlist;

    }

    public Car getCar(int id) {
        MySqLConnector con = new MySqLConnector();
        String q = "select * from car where id = ? ";
        Car car = new Car();
        try {

            PreparedStatement pre = con.connect().prepareStatement(q);
            pre.setInt(1, id);
            ResultSet result = pre.executeQuery();
            result.next();
            System.out.println(result.getString("name"));
            car.setId(result.getInt("id"));
            car.setBrand(result.getString("name"));
        } catch (Exception ex) {

        } finally {
            con.disconnect();
        }
        return car;

    }

    public void insert(Car car){
        MySqLConnector con = new MySqLConnector();
        String q = "insert into car(name) values(?) ";
        try {

            PreparedStatement pre = con.connect().prepareStatement(q);
            pre.setString(1, car.getBrand());
            pre.execute();
            
        } catch (Exception ex) {

        } finally {
            con.disconnect();
        }
    }

    public void updateCar(Car car) {
        MySqLConnector con = new MySqLConnector();
        String q = "update car set name=? where id =?";
        try {

            PreparedStatement pre = con.connect().prepareStatement(q);
            pre.setString(1, car.getBrand());
            pre.setInt(2, car.getId());
           pre.execute();
           
        } catch (Exception ex) {

        } finally {
            con.disconnect();
        }
    

    }


    public void delete(int id){
        MySqLConnector con = new MySqLConnector();
        String q = "delete from car where id=?";
        try {

            PreparedStatement pre = con.connect().prepareStatement(q);
            pre.setInt(1, id);
            pre.execute();
            
        } catch (Exception ex) {

        } finally {
            con.disconnect();
        }
    }


}
