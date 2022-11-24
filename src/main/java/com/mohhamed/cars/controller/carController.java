package com.mohhamed.cars.controller;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "/")
    public ModelAndView index() {
        // init modelAndView
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        // init DAl/object/data
        carDAL dal = new carDAL();
        mv.addObject("carsList", dal.getAllCar());
        return mv;
    }

    @RequestMapping(value = "/{id}")
    public ModelAndView view(@PathVariable int id) {
        carDAL dal = new carDAL();
        ModelAndView mv = new ModelAndView();
        mv.addObject("MyCar", dal.getCar(id));
        mv.setViewName("view");
        return mv;
    }

    @RequestMapping(value = "/add")
    public String store(Car car) {

        carDAL dal = new carDAL();
        dal.insert(car);
        return "redirect:/";

    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id) {
        System.out.println(id);
        carDAL dal = new carDAL();
        dal.delete(id);
        return "redirect:/"; 
    }

}
