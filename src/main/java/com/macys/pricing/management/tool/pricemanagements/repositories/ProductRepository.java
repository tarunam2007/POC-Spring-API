package com.macys.pricing.management.tool.pricemanagements.repositories;

import org.springframework.data.repository.CrudRepository;

import com.macys.pricing.management.tool.pricemanagements.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
