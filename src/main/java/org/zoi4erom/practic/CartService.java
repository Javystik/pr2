package org.zoi4erom.practic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
        private ProductRepository productRepository;

        @Autowired
        public void setProductRepository(ProductRepository productRepository) {
                this.productRepository = productRepository;
        }

        public void addToCart(Cart cart, int productId, int quantity) {
                productRepository.getProductById(productId).ifPresent(product -> cart.addProduct(product, quantity));
        }

        public void removeFromCart(Cart cart, int productId) {
                productRepository.getProductById(productId).ifPresent(cart::removeProduct);
        }
}
