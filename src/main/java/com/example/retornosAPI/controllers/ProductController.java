package com.example.retornosAPI.controllers;

import com.example.retornosAPI.DTOs.ProductDTO;
import com.example.retornosAPI.models.Product;
import com.example.retornosAPI.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductDTO productDTO) {

        Product product = new Product(
                null, // ID gerado automaticamente
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getPrice(),
                productDTO.getStockQuantity(),
                productDTO.getCategory()
        );
        return ResponseEntity.ok(service.createProduct(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductDTO productDTO
    ) {
        System.out.println("Received ProductDTO: " + productDTO);
        try {
            Product updatedProduct = new Product(
                    id,
                    productDTO.getName(),
                    productDTO.getDescription(),
                    productDTO.getPrice(),
                    productDTO.getStockQuantity(),
                    productDTO.getCategory()
            );

            Product result = service.updateProduct(id, updatedProduct);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}