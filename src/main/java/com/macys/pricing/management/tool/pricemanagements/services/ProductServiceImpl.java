package com.macys.pricing.management.tool.pricemanagements.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macys.pricing.management.tool.pricemanagements.entities.Product;
import com.macys.pricing.management.tool.pricemanagements.repositories.ProductRepository;

/**
 * Product service implement.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    
    @Override
    public Product updateProduct(Product product) {
    	Product productUpdate = productRepository.findOne(product.getId());
    	productUpdate.setAnalyticsInfo(product.getAnalyticsInfo());
    	productUpdate.setItemName(product.getItemName());
    	productUpdate.setItemNum(product.getItemNum());
    	productUpdate.setItemPrice(product.getItemPrice());
    	productUpdate.setLocation(product.getLocation());
    	productUpdate.setMerchantDecision(product.getMerchantDecision());
    	productUpdate.setVersion(product.getVersion());
        return productRepository.save(productUpdate);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.delete(id);
    }

}
