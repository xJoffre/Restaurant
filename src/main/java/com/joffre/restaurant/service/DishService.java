package com.joffre.restaurant.service;
import com.joffre.restaurant.model.Dish;
import java.util.List;

public interface DishService {

     List<Dish> findAll();

    Dish findById(Long id);

    Dish save(Dish dish);

    Dish update(Long id, Dish dish);

    void delete(Long id);
    
} 