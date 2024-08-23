
package com.graso.taco_cloud;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface IngredientRepository extends CrudRepository<Ingredient,String>{
    /* 
    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);

    */
}
