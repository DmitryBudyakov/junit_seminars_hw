package seminars.first.homework.shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/*
    *Задание 2. (необязательное) *
    Мы хотим улучшить функциональность нашего интернет-магазина.
    Ваша задача - добавить два новых метода в класс Shop:
        Метод sortProductsByPrice(), который сортирует список продуктов по стоимости.
        Метод getMostExpensiveProduct(), который возвращает самый дорогой продукт.
    Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов
    (правильное количество продуктов, верное содержимое корзины).
    Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
    Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
    Используйте класс Product для создания экземпляров продуктов и класс Shop для написания методов сортировки и тестов.
 */
public class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов,
   верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */
    public static void main(String[] args) {

        Shop shop = new Shop();
        List<Product> products = new ArrayList<>();
        String[] productsNames = {"Book", "House", "Coffee", "Sandwich", "Whiskey"};
        Integer[] productsCosts = {100, 1_000_000_000, 500, 50, 1500};
        Product prod1 = new Product();
        Product prod2 = new Product();
        Product prod3 = new Product();
        Product prod4 = new Product();
        Product prod5 = new Product();
        Product[] productsArray = {prod1, prod2, prod3, prod4, prod5};

        for (int i = 0; i < productsNames.length; i++) {
            productsArray[i].setCost(productsCosts[i]);
            productsArray[i].setTitle(productsNames[i]);
        }

        products = Arrays.asList(productsArray);
        System.out.println("Исходный список товаров:");
        showProducts(products);

        shop.setProducts(products);

        // 1. Тесты, чтобы проверить, что магазин хранит верный список продуктов
        // (правильное количество продуктов, верное содержимое корзины).
        // - правильное количество:
        assertThat(shop.getProducts()).hasSize(products.size());
        // - верное содержимое:
        for (int i = 0; i < products.size(); i++) {
            assertThat(shop.getProducts().get(i).getTitle()).isEqualTo(products.get(i).getTitle());
            assertThat(shop.getProducts().get(i).getCost()).isEqualTo(products.get(i).getCost());
        }

        System.out.println();
        System.out.println("Самый дорогой продукт:");
        showProduct(shop.getMostExpensiveProduct());
        // 2. Проверяем, что метод возвращает самый дорогой продукт:
        assertThat(shop.getMostExpensiveProduct().getCost()).isEqualTo(prod2.getCost());
        // 3. Дополнительные тесты см. внутри метода getMostExpensiveProduct() в классе Shop

        System.out.println();
        System.out.println("Отсортированный список:");
        showProducts(shop.sortProductsByPrice());
        // 4. Проверяем правильность сортировки:
        assertThat(shop.getProducts()).containsSequence(prod4, prod1, prod3, prod5, prod2);

    }

    /*
        Вспомогательный метод для вывода всех продуктов списка в консоль
     */
    public static void showProducts(List<Product> products) {
        for (Product product : products) {
            showProduct(product);
        }
    }

    /*
        Вспомогательный метод для вывода одного продукта в консоль
     */
    public static void showProduct(Product product) {
        System.out.println("Product title: " + product.getTitle() + ", cost: " + product.getCost());
    }

}