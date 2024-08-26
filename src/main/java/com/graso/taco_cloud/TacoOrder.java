package com.graso.taco_cloud;

/*import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Table
public class TacoOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;

    private Date placedAt;

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
}*/
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
@Entity
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date placedAt = new Date();
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
    @Digits(integer = 3, fraction = 0, message = "CVV no valido")
    private String ccCVV;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
