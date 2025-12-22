package com.github.nozama.services;

import com.github.nozama.dto.ProductDTO;
import com.github.nozama.entities.Product;
import com.github.nozama.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {


    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> result = repository.findById(id);
        Product product = result.get();
        ProductDTO dto = new ProductDTO(product);
        return dto;
    }

}
