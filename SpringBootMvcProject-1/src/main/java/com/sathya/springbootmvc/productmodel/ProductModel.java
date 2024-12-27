package com.sathya.springbootmvc.productmodel;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
	@NotBlank(message = "Product name connect be blank")
	private String name;
	@NotBlank(message = "Brand cannot be blank")
	private String brand;
	@NotBlank(message = "made-in field cannot be blank")
	private String madeIn;
	@Positive(message = "price must be greaterthan Zero")
	private double price;
	@Min(value = 1 ,message = "quantity must be atleast one")
	private int quantity;
	@DecimalMax(value = "100.0",message = "discount rate cannot exceed 100")
	private double discountrate;
	@DecimalMax(value = "40.0" , message = "discount rate cannot exceed 40")
	private double taxprice;

	
}
