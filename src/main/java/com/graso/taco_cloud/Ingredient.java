package com.graso.taco_cloud;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Entity
public class Ingredient {
  public enum Type {
    WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
  }
  @Id
  private final String id;
  private final String name;
  private final Type type;

 

}