package com.example.retornosAPI.DTOs;

import com.example.retornosAPI.models.Category;
import jakarta.validation.constraints.*;

public class ProductDTO {

    @NotBlank(message = "O nome do produto é obrigatório.")
    @Size(min = 3, max = 100, message = "O nome do produto deve ter entre 3 e 100 caracteres.")
    private String name;

    @Size(max = 500, message = "A descrição pode ter no máximo 500 caracteres.")
    private String description;

    @NotNull(message = "O preço é obrigatório.")
    @PositiveOrZero(message = "O preço deve ser maior que 0.")
    private Double price;

    @NotNull(message = "A quantidade em estoque é obrigatória.")
    @PositiveOrZero(message = "A quantidade em estoque deve ser maior ou igual a 0.")
    private Integer stockQuantity;

    @NotNull(message = "A categoria é obrigatória.")
    private Category category;

    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}