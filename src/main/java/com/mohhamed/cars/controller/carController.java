package com.mohhamed.cars.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mohhamed.cars.DAL.carDAL;
import com.mohhamed.cars.model.Car;

@Controller
@RequestMapping(value = "/")
public class carController {


    @Autowired
    carDAL dal ;

    @RequestMapping(value = "/")
    public ModelAndView index() {
        // init modelAndView
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        // init DAl/object/data
        mv.addObject("carsList", dal.getAllCar());
        return mv;
    }

    @RequestMapping(value = "/{id}")
    public ModelAndView view(@PathVariable int id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("MyCar", dal.getCar(id));
        mv.setViewName("view");
        return mv;
    }

    @RequestMapping(value = "/add")
    public String store(Car car) {
        dal.insert(car);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id) {
        dal.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView edit(@PathVariable int id){
        ModelAndView m =new ModelAndView();
        Car car=dal.getCar(id);
       if(car.getId()==0){
        m.setViewName("index");
        m.addObject("carsList", dal.getAllCar());
       }else{
           m.setViewName("edit");
           m.addObject("car", car );
       }
    
    return m;
    }
    @RequestMapping(value = "/update")
    public String update(Car car){
    dal.updateCar(car);
    return "redirect:/";
    }

}
