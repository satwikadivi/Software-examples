package com.sathya.springbootmvc.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.springbootmvc.entity.ProductEntity;
import com.sathya.springbootmvc.productmodel.ProductModel;
import com.sathya.springbootmvc.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public void saveProductDetails(ProductModel productModel)
	{
		double discountprice;
		discountprice = productModel.getPrice()*productModel.getDiscountrate()/100;
		
		double offerprice;
		offerprice = productModel.getPrice() - discountprice;
		
		double finalprice;
		finalprice = productModel.getTaxprice() + offerprice;
		
		double stockvalue;
		stockvalue = productModel.getQuantity()*offerprice+ productModel.getTaxprice()/100;
		
		
		ProductEntity productEntity=new ProductEntity();
		productEntity.setName(productModel.getName());
		productEntity.setBrand(productModel.getBrand());
		productEntity.setMadeIn(productModel.getMadeIn());
		productEntity.setPrice(productModel.getPrice());
		productEntity.setQuantity(productModel.getQuantity());
		productEntity.setDiscountrate(productModel.getDiscountrate());
		productEntity.setTaxprice(productModel.getTaxprice());
	    productEntity.setDiscountprice(discountprice);
	    productEntity.setOfferprice(offerprice);
	    productEntity.setFinalprice(finalprice);
	    productEntity.setStockvalue(stockvalue);
		
	    productRepository.save(productEntity);
	}
	
	public List<ProductEntity> getAllProducts()
    {
    	List<ProductEntity> products = productRepository.findAll();
    	return products;
    }

	public ProductEntity searchById(Long id)
	{
		Optional<ProductEntity> optionalData =productRepository.findById(id);
		if(optionalData.isPresent())
		{
			ProductEntity product=optionalData.get();
			return product;
		}
		else
		{
		    return null;
		}
	}

	public void deleteProductById(Long id) 
	{
		productRepository.deleteById(id);
		
	}

	public ProductEntity editByProductId(Long id) {
		// TODO Auto-generated method stub
		Optional<ProductEntity> optional=productRepository.findById(id);
		if(optional.isPresent())
		{
			ProductEntity entity=optional.get();
			ProductModel productModel=new ProductModel();
			productModel.setName(entity.getName());
			productModel.setBrand(entity.getBrand());
			productModel.setMadeIn(entity.getMadeIn());
			productModel.setPrice(entity.getPrice());
			productModel.setQuantity(entity.getQuantity());
			productModel.setDiscountrate(entity.getDiscountrate());
			productModel.setTaxprice(entity.getTaxprice());
		
		    return entity;
	    }
		else
		{
			return null;
		}
	}
	
	
	public void updateProduct(ProductModel productModel, Long id) {
		// TODO Auto-generated method stub
		Optional<ProductEntity> optionalData=productRepository.findById(id);
		if(optionalData.isPresent())
		{
		ProductEntity entity=optionalData.get();
		 
		entity.setName(productModel.getName());
		entity.setBrand(productModel.getBrand());
		entity.setMadeIn(productModel.getMadeIn());
		entity.setPrice(productModel.getPrice());
		entity.setQuantity(productModel.getQuantity());
		entity.setDiscountrate(productModel.getDiscountrate());
		entity.setTaxprice(productModel.getTaxprice());
		
		double discountprice;
		discountprice = productModel.getPrice()*productModel.getDiscountrate()/100;
		
		double offerprice;
		offerprice = productModel.getPrice() - discountprice;
		
		double finalprice;
		finalprice = productModel.getTaxprice() + offerprice;
		
		double stockvalue;
		stockvalue = productModel.getQuantity()*offerprice+ productModel.getTaxprice()/100;
		
		entity.setDiscountprice(discountprice);
	    entity.setOfferprice(offerprice);
	    entity.setFinalprice(finalprice);
	    entity.setStockvalue(stockvalue);
		
		productRepository.save(entity);	
		}
	}

	

}
