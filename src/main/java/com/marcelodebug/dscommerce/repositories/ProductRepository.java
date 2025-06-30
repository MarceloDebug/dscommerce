package com.marcelodebug.dscommerce.repositories;

import com.marcelodebug.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
