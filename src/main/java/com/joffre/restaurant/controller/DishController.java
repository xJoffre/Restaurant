package com.joffre.restaurant.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.joffre.restaurant.model.Dish;
import com.joffre.restaurant.service.DishService;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")

public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    public List<Dish> getAllDishes() {
        return dishService.findAll();
    }

    @PostMapping
    public Dish createDish(@RequestBody Dish dish) {
        return dishService.save(dish);
    }

    @GetMapping("/{id}")
    public Dish getDishById(@PathVariable Long id) {
        return dishService.findById(id);
    }

    @PutMapping("/{id}")
    public Dish updateDish(@PathVariable Long id, @RequestBody Dish updatedDish) {

        Dish dish = dishService.findById(id);

        dish.setName(updatedDish.getName());
        dish.setDescription(updatedDish.getDescription());
        dish.setPrice(updatedDish.getPrice());
        dish.setCategory(updatedDish.getCategory());
        dish.setAvailable(updatedDish.getAvailable());

        return dishService.save(dish);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        dishService.delete(id);
    }

}
