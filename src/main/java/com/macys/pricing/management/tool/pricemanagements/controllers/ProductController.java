package com.macys.pricing.management.tool.pricemanagements.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.macys.pricing.management.tool.pricemanagements.entities.Product;
import com.macys.pricing.management.tool.pricemanagements.services.ProductService;

/**
 * Product controller.
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/items")
public class ProductController {

	Logger logger = Logger.getLogger(ProductController.class);
	
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    /**
     * List all products.
     *
     * @param model
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/{location}/", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> list(Model model) {
    	List<Product> productItems = (List<Product>) productService.listAllProducts();
    	ResponseEntity<List<Product>> responseEntity = new ResponseEntity<List<Product>>(productItems, HttpStatus.OK);
    	logger.info("Fetched all the products from H2 DB successful");
        return responseEntity;
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @CrossOrigin
    @RequestMapping("/{location}/fetch/{id}")
    public ResponseEntity<Product> showProduct(@PathVariable Integer id, Model model) {
    	Product product = productService.getProductById(id);
    	ResponseEntity<Product> response = new ResponseEntity<Product>(product, HttpStatus.OK);
    	logger.info("Fetching the item for item number " + product.getId());
        return response;
    }

    
    /**
     * Save product to database.
     *
     * @param product
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/{location}/save", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        logger.info("Saved the item details for the ID " + product.getId());
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(value = "/{location}/update", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        logger.info("Saved the item details for the ID " + product.getId());
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }
    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @CrossOrigin
    @RequestMapping("/{location}/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        productService.deleteProduct(id);
        logger.info("Deleted item details for the ID " + id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
