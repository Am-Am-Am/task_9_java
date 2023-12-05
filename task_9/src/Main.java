import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.*;

import static java.util.stream.Collectors.partitioningBy;

public class Main {
    public static void main(String[] args) {
        IntStream randomIntegers = new Random().ints(1000, 10, 10000);

        List<Integer> collectedNumbers = randomIntegers
                .boxed()
                .toList();
        System.out.println("Сбор в коллекцию " + collectedNumbers);

        long primeCount = collectedNumbers.stream()
                .filter(Main::isPrime)
                .count();
        System.out.println("Количество простых чисел: " + primeCount);

        OptionalInt maxNumber = collectedNumbers.stream()
                .mapToInt(Integer::intValue)
                .max();
        System.out.println("Максимальное число: " + maxNumber.getAsInt());


        Map<Boolean, List<Integer>> evenOddMap = collectedNumbers.stream()
                .collect(partitioningBy(n -> n % 2 == 0));
        System.out.println("Четные числа: " + evenOddMap.get(true));
        System.out.println("Нечетные числа: " + evenOddMap.get(false));


        //2 задание
        List<String> words = Arrays.asList("apple", "banana", "orange", "mango", "pear", "grape");

        // Преобразование элементов в верхний регистр
        List<String> upperCaseWords = words.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Слова в верхнем регистре: " + upperCaseWords);

        // Фильтрация слов по длине
        List<String> longWords = words.stream()
                .filter(word -> word.length() > 5)
                .toList();
        System.out.println("Слова длиной больше 5: " + longWords);

        // Ограничение количества слов
        List<String> limitedWords = words.stream()
                .limit(3)
                .toList();
        System.out.println("Ограниченное количество слов: " + limitedWords);


        }
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    }