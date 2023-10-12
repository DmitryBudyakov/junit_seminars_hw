package seminars.first.homework.shop;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        // Допишите реализацию метода самостоятельно
        if (products == null || products.isEmpty()){
            System.out.println("Список пустой");
            return null;
        }
        Product temp = new Product();
        for (int i = 0; i < products.size(); i++) {
            for (int j = i + 1; j < products.size(); j++) {
                if (products.get(j).getCost() < products.get(i).getCost()) {
                    temp = products.get(i);
                    products.set(i, products.get(j));
                    products.set(j, temp);
                }
            }
        }
        return products;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        // Допишите реализацию метода самостоятельно
        // 3-1. Проверяем на Null и Empty:
        assertThat(products).isNotNull();
        assertThat(products).isNotEmpty();

        if (products == null || products.isEmpty()) {
            System.out.println("Список товаров пустой");
            return null;
        }
        // 3-2. Проверяем на отрицательное значение цены и на переполнение Integer (число тоже будет < 0)
        // для 1-го эл-та списка:
        assertThat(products.get(0).getCost()).isNotNegative();

        Integer maxCost = products.get(0).getCost();
        int maxIndex = 0;
        for (int i = 1; i < products.size(); i++) {
            if (products.get(i).getCost() > maxCost) {
                // 3-3. Проверяем на отрицательное значение и переполнение Integer для остальных эл-тов:
                assertThat(products.get(i).getCost()).isNotNegative();
                maxCost = products.get(i).getCost();
                maxIndex = i;
            }
        }
        return products.get(maxIndex);
    }

}