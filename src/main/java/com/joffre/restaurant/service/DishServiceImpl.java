package com.joffre.restaurant.service;

import com.joffre.restaurant.exception.ResourceNotFoundException;
import com.joffre.restaurant.model.Dish;
import com.joffre.restaurant.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService{
    
     private final DishRepository dishRepository;

      public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public Dish findById(Long id) {
        return dishRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dish not found with id " + id));
    }

    @Override
    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Dish update(Long id, Dish updatedDish) {

        Dish dish = findById(id);

        dish.setName(updatedDish.getName());
        dish.setDescription(updatedDish.getDescription());
        dish.setPrice(updatedDish.getPrice());
        dish.setCategory(updatedDish.getCategory());
        dish.setAvailable(updatedDish.getAvailable());

        return dishRepository.save(dish);
    }

    @Override
    public void delete(Long id) {
        dishRepository.deleteById(id);
    }
}
