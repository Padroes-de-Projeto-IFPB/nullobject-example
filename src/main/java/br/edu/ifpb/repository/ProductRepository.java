package br.edu.ifpb.repository;

import br.edu.ifpb.domain.Product;
import br.edu.ifpb.domain.ProductNull;

import java.math.BigDecimal;

public class ProductRepository {

    public void save(Product product) {
        // Database connection
        // Query construction
        // Query execution...
        product.setId(5L);
    }

    public Product find(Long id) {
        Product product = new ProductNull();

        if (id == 5) {
            product = new Product();
            product.setId(5L);
            product.setPrice(BigDecimal.valueOf(2300L));
            product.setDesc("desc");
            product.setTitle("Hamburguer");
            product.setProductType(Product.ProductType.FOOD);
        }

        return product;
    }
}
