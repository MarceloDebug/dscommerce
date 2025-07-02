package com.marcelodebug.dscommerce.services;

import com.marcelodebug.dscommerce.dto.ProductDTO;
import com.marcelodebug.dscommerce.entities.Product;
import com.marcelodebug.dscommerce.repositories.ProductRepository;
import com.marcelodebug.dscommerce.services.exceptions.DatabaseException;
import com.marcelodebug.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")
        );
        return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> products= productRepository.findAll(pageable);
        return products.map(ProductDTO::new);
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto){
        Product product = new Product();
        copyToEntity(dto, product);

        product = productRepository.save(product);
        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto){
        Product entity = productRepository.getReferenceById(id);
        copyToEntity(dto, entity);

        entity = productRepository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!productRepository.existsById(id)){
            throw new DatabaseException("Recurso não encontrado");
        }
        try {
            productRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
                throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyToEntity(ProductDTO dto, Product product) {
        product.setDescription(dto.getDescription());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setImgUrl(dto.getImgUrl());
    }


}
