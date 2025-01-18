import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NumberOperations {

    public static void main(String[] args) {
        List<Object> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20.5);
        numbers.add(30);
        numbers.add(40.7);
        numbers.add(50);
        numbers.add(60.3);
        numbers.add(70);
        numbers.add(80.1);
        numbers.add(90);
        numbers.add(100.9);
        numbers.add(-32);
        numbers.add(0.005);

        System.out.println("Всі числа:");
        System.out.println(joinWithComma(numbers));

        System.out.println("Цілі числа:");
        List<Long> integersAsLongs = new ArrayList<>();
        for (Object number : numbers) {
            if (number instanceof Number) {
                integersAsLongs.add(((Number) number).longValue());
            }
        }
        System.out.println(joinWithComma(integersAsLongs));

        System.out.println("Дробних чисел з 2-ма знаками після коми:");
        List<String> formattedDoubles = new ArrayList<>();
        for (Object number : numbers) {
            if (number instanceof Number) {
                formattedDoubles.add(String.format("%.2f", ((Number) number).doubleValue()));
            }
        }
        System.out.println(String.join(", ", formattedDoubles));

        List<Integer> integers = new ArrayList<>();
        List<Double> doubles = new ArrayList<>();

        for (Object number : numbers) {
            if (number instanceof Integer) {
                integers.add((Integer) number);
            } else if (number instanceof Double) {
                doubles.add((Double) number);
            }
        }

        System.out.println("Список цілих чисел:");
        System.out.println(joinWithComma(integers));

        System.out.println("Список дробних чисел:");
        System.out.println(joinWithComma(doubles));

        System.out.println("Чисела у форматі BigDecimal:");
        List<BigDecimal> bigDecimals = new ArrayList<>();
        for (Object number : numbers) {
            if (number instanceof Number) {
                bigDecimals.add(new BigDecimal(number.toString()));
            }
        }
        System.out.println(joinWithComma(bigDecimals));
    }

    private static String joinWithComma(List<?> list) {
        return "[" + String.join(", ", list.stream().map(Object::toString).toArray(String[]::new)) + "]";
    }

}

