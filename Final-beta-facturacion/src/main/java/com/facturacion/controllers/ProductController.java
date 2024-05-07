package com.facturacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.models.entity.Product;
import com.facturacion.services.ProductService;

@CrossOrigin(origins = "http://localhost:5173") //Acceder desde react en local
@RestController
@RequestMapping("/productos")
public class ProductController {
    @Autowired
    private ProductService productService;
    
    // Crear nuevo Producto
    @PostMapping(value = "/crear", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    	productService.createProduct(product);
		return new ResponseEntity<>(product, HttpStatus.CREATED); // Codigo 201
	}
    
    // Actualizar Producto
    @PutMapping(value = "/{id}/editar", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
    	Product productUpdated = productService.updateProductById(id, product);
		if (productUpdated != null) {
			return new ResponseEntity<>(productUpdated, HttpStatus.OK); // Codigo 200
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Error 404
		}
	}
    
    // Obtener todos los productos
    @GetMapping (value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Product>> getAllProducts() {
		try {
			List<Product> products = productService.getAllProducts();
			return new ResponseEntity<>(products, HttpStatus.OK); // Codigo 200

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}

	}
    
    // Obtener Producto segun id
    @GetMapping(value = "/producto/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
		try {
			Product product = productService.getProductById(id);
			if (product != null) {
				return new ResponseEntity<>(product, HttpStatus.OK); // Codigo 200
			} else {
				return new ResponseEntity<>(product, HttpStatus.NOT_FOUND); // Codigo 404
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}

	}

    // Eliminar Producto segun id
    @DeleteMapping(value = "/{id}/eliminar")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer id) {
		boolean deletedProduct = productService.deleteProductById(id);
		if (deletedProduct) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Codigo 204
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Error 404
		}
	}
}