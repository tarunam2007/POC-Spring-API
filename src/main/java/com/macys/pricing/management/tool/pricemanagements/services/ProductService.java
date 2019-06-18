package com.macys.pricing.management.tool.pricemanagements.services;

import com.macys.pricing.management.tool.pricemanagements.entities.Product;

public interface ProductService {

    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);

	Product updateProduct(Product product);

}
