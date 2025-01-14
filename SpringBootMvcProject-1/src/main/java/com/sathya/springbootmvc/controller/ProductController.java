package com.sathya.springbootmvc.controller;

import java.util.HashMap;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.springbootmvc.entity.ProductEntity;
import com.sathya.springbootmvc.productmodel.ProductModel;
import com.sathya.springbootmvc.service.ProductService;

import jakarta.validation.Valid;

@Controller
public class ProductController {
	
	  @Autowired
	  ProductService productService;
	 
      @GetMapping("/productform")
      public String getProductform(Model model)
      {
    	  ProductModel productModel=new ProductModel();
    	  productModel.setMadeIn("India");
    	  productModel.setQuantity(2);
    	  productModel.setDiscountrate(20.0);
    	  productModel.setTaxprice(18.0);
    	  model.addAttribute("productModel",productModel);
    	  return "add-product";
      }
      
      @PostMapping("/saveproduct")
      public String saveProduct(@Valid ProductModel productModel,BindingResult bindingResult,Model
    		  model)
      {
    	  HashMap<String, String> validationErrors=new HashMap<String, String>();
    	  
    	  if(bindingResult.hasErrors())
    	  {
    		  for(FieldError fieldError:bindingResult.getFieldErrors())
    		  {
    			  validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
    		  }
    		  model.addAttribute("validationErrors",validationErrors);
    		  return "add-product";
    	  }
    	  productService.saveProductDetails(productModel);
    	  return "redirect:/getallproducts";
      }
      
      @GetMapping("/getallproducts")
      public String getAllProducts(Model model)
      {
    	  List<ProductEntity> products=productService.getAllProducts();
    	  model.addAttribute("products",products);
    	  return "product-list";
      }
      
      @GetMapping("/searchproductform")
      public String getSearchForm()
      {
    	  return "search-product";
      }
      
      @PostMapping("/searchById")
      public String searchById(@RequestParam Long id,Model model)
      {
    	  ProductEntity product=productService.searchById(id);
    	  model.addAttribute("product",product);
    	  return "search-product";
      }
      
      @GetMapping("/delete/{id}")
      public String getdeleteProductById(@PathVariable("id") Long id)
      {
    	  productService.deleteProductById(id);
    	  return "redirect:/getallproducts";
      }
      
      
      @GetMapping("/edit/{id}")
      public String editProductForm(@PathVariable("id") Long id, Model model) 
      {
    	  ProductEntity product = productService.editByProductId(id); 
          model.addAttribute("product", product); 
          model.addAttribute("id",id);
          return "edit-product"; 
      }

     
      // POST method to save the edited product
     @PostMapping("/editproductsave/{id}")
      public String updateProduct(@PathVariable Long id, ProductModel productModel) 
      {
          productService.updateProduct(productModel,id);
          return "redirect:/getallproducts"; 
      }

          
}
