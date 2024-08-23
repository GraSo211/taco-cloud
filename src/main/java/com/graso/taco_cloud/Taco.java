

package com.graso.taco_cloud;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Table
public class Taco {
    @Id
    private Long id;

    private Date createdAt = new Date();
    @NotNull
    @Size(min=5,message="Name debe tener al menos 5 caracteres.")
    private String name;
    @NotNull
    @Size(min=1, message="Debes seleccionar al menos 1 ingrediente.")
    private List<IngredientRef> ingredients;
    
}
