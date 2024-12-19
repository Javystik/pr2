package org.zoi4erom.practic;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
        private final List<Product> products;

        public ProductRepository() {
                products = new ArrayList<>();
                products.add(new Product(1, "Product A", 100));
                products.add(new Product(2, "Product B", 200));
                products.add(new Product(3, "Product C", 300));
                products.add(new Product(4, "Product D", 400));
                products.add(new Product(5, "Product E", 500));
        }

        public List<Product> getProducts() {
                return products;
        }

        public Optional<Product> getProductById(int id) {
                return products.stream().filter(product -> product.getId() == id).findFirst();
        }
}
