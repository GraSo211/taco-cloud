package com.graso.taco_cloud;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class TacoOrder {

    @NotBlank(message = "Delivery name es requerido.")
    private String deliveryName;
    @NotBlank(message = "Delivery street es requerido.")
    private String deliveryStreet;
    @NotBlank(message = "Delivery City es requerido.")
    private String deliveryCity;
    @NotBlank(message = "Delivery State es requerido.")
    private String deliveryState;
    @NotBlank(message = "Delivery Zip es requerido.")
    private String deliveryZip;

    @CreditCardNumber(message = "Number Credit Card no valido.")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
            message = "Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer=3, fraction=0, message="CVV no valido")
    private String ccCVV;
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
