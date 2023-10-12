package seminars.first.homework.calculator;

import static org.assertj.core.api.Assertions.assertThat;

public class Calculator {
    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    // Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и проверить его, используя AssertJ
    // Примерная сигнатура и тело метода:
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        // purchaseAmount - сумма покупки
        // discountAmount - размер скидки

        // 1. Проверка purchaseAmount:
        // на неотрицательное число
        assertThat(purchaseAmount).isGreaterThanOrEqualTo(0);
        // 2. Проверка discountAmount:
        assertThat(discountAmount)
                .isGreaterThanOrEqualTo(0)  // на неотрицательное число
                .isLessThanOrEqualTo(100);  // что оно не больше 100 (исходя из того, что скидка дана в процентах)

        if (purchaseAmount < 0 || discountAmount < 0 || discountAmount > 100) {
            throw new ArithmeticException("Недопустимые аргументы");
        }

        // Метод должен возвращать сумму покупки со скидкой
        return purchaseAmount - purchaseAmount * discountAmount / 100;
    }
}