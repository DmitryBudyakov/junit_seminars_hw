package seminars.first.homework.calculator;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    public static void main(String[] args) {

        /* ДЗ
        Задание 1.
        В классе Calculator создайте метод calculateDiscount,
        который принимает сумму покупки и процент скидки и возвращает сумму с учетом скидки.
        Ваша задача - проверить этот метод с использованием библиотеки AssertJ.
        Если метод calculateDiscount получает недопустимые аргументы, он должен выбрасывать исключение
        ArithmeticException.
        Не забудьте написать тесты для проверки этого поведения.
        */
        double purchaseAmount = 1000;
        int discountAmount = 25;

        System.out.println(Calculator.calculatingDiscount(purchaseAmount, discountAmount));

    }
}