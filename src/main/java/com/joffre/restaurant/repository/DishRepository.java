package com.joffre.restaurant.repository;

import com.joffre.restaurant.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
    
}
