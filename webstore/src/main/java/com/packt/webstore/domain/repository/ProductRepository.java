package com.packt.webstore.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.packt.webstore.domain.Product;

public interface ProductRepository {

	List <Product> getAllProducts();
	Product getProductById(String productID);
	List <Product> getProductsByCategory(String category);
	List <Product> getProductsByManufacturer(String category);
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterParams);
	Set<Product> getProductsByCategoryPriceManufacturer(String category,Map<String, List<String>> price, String manufacturer);
}
