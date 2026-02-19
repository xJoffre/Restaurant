package com.joffre.restaurant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Dish>> getAll() {
        return ResponseEntity.ok(dishService.findAll());
    }

    @PostMapping
    public ResponseEntity<Dish> create(@RequestBody Dish dish) {
        Dish saved = dishService.save(dish);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> getById(@PathVariable Long id) {
        return ResponseEntity.ok(dishService.findById(id));
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
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        dishService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
