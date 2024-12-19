package org.zoi4erom.practic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.zoi4erom.practic")
public class Main {

        public static void main(String[] args) {
                ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

                // Отримуємо бін ProductRepository
                ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);

                System.out.println("~~~~~~~~~~~~~ Товари в репозиторії ~~~~~~~~~~~~~");
                productRepository.getProducts().forEach(System.out::println);

                // Отримуємо бін CartService
                CartService cartService = context.getBean(CartService.class);

                // Створюємо новий кошик
                Cart cart = context.getBean(Cart.class);

                System.out.println("\n~~~~~~~~~~~~~ Додаємо товари в кошик ~~~~~~~~~~~~~");
                cartService.addToCart(cart, 1, 2); // Додаємо 2 одиниці товару з id 1
                cartService.addToCart(cart, 3, 1); // Додаємо 1 одиницю товару з id 3

                System.out.println("Кошик після додавання товарів:");
                cart.getItems().forEach((product, quantity) ->
                        System.out.println(product + ", Кількість: " + quantity)
                );

                System.out.println("\n~~~~~~~~~~~~~ Видаляємо товар із кошика ~~~~~~~~~~~~~");
                cartService.removeFromCart(cart, 1); // Видаляємо товар з id 1
                System.out.println("Кошик після видалення товару:");
                cart.getItems().forEach((product, quantity) ->
                        System.out.println(product + ", Кількість: " + quantity)
                );

                System.out.println("\n~~~~~~~~~~~~~ Очищаємо кошик ~~~~~~~~~~~~~");
                cart.clearCart();
                System.out.println(cart.getItems().isEmpty() ? "Кошик порожній" : "У кошику є товари");
        }
}
