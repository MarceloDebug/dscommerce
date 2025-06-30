package com.marcelodebug.dscommerce.services;

import com.marcelodebug.dscommerce.dto.ProductDTO;
import com.marcelodebug.dscommerce.entities.Product;
import com.marcelodebug.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = productRepository.findById(id).get();
        return new ProductDTO(product);
    }
}
