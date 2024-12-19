package org.zoi4erom.practic;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope("prototype")
@Getter
public class Cart {
        private final Map<Product, Integer> items = new HashMap<>();

        public void addProduct(Product product, int quantity) {
                items.merge(product, quantity, Integer::sum);
        }

        public void removeProduct(Product product) {
                items.remove(product);
        }

        public void clearCart() {
                items.clear();
        }
}
