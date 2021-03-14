package com.oobd.oobd_spring.controllers;

import com.oobd.oobd_spring.models.Order;
import com.oobd.oobd_spring.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        Iterable<Order> orders = orderRepository.findAll();
        return "greeting";
    }

}
