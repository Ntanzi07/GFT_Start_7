package EX_Predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("java", "kotlin", "python", "javascript", "c", "go", "ruby");

        Predicate<String> maisDeCincoCaracters = palavra -> palavra.length() > 5;

        System.out.println("================== Palavras < 5 ==================");
        palavras.stream()
                .filter(maisDeCincoCaracters)
                .forEach(System.out::println);

        System.out.println("================== Palavras < 3 ==================");
        palavras.stream()
                .filter(palavra -> palavra.length() < 3)
                .forEach(System.out::println);

    }
}
