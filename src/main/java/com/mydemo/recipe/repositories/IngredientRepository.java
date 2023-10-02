package com.mydemo.recipe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mydemo.recipe.models.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

}
