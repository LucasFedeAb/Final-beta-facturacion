package com.facturacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.facturacion.controllers.dto.ProductDTO;
import com.facturacion.models.entity.Product;
import com.facturacion.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public Product getProductById(Integer id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public ProductDTO getProductDTOById(Integer id) {
	    Product product = productRepository.findById(id).orElse(null);
	    if (product != null) {
	        return new ProductDTO(product);
	    } else {
	        return null;
	    }
	}

    public Product createProduct(Product product) {
    	if(product.getPrice() <= 0) {
    		throw new RuntimeException("El precio debe ser mayor a $0.");
    	} else if (product.getStock() <= 0) {
    		throw new RuntimeException("El stock debe ser mayor a 0.");
    	}
        return productRepository.save(product);
    }

    public Product updateProductById(Integer id, Product product) {
    	try {
			if (productRepository.existsById(id)) {
				product.setId(id);
				return productRepository.save(product);
			}
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
    	return null;
    }
    
    public Product updateProduct(Product product) {
    	return productRepository.save(product);
    }
    
    public boolean deleteProductById(Integer id) {
		try {
			productRepository.deleteById(id);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}
    
}

