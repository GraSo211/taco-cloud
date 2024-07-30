

package com.graso.taco_cloud;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Taco {
    @NotNull
    @Size(min=5,message="Name debe tener al menos 5 caracteres.")
    private String name;
    @NotNull
    @Size(min=1, message="Debes seleccionar al menos 1 ingrediente.")
    private List<Ingredient> ingredients;
    
}
