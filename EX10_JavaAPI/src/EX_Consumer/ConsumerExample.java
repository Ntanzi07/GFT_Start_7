package EX_Consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        //Construindo Consumer fora
        Consumer<Integer> imprimirNumerosPar = numero -> {
            if (numero % 2 == 0) System.out.println(numero);
        };
        numeros.forEach(imprimirNumerosPar);

        System.out.println("=================");

        //Construindo Consumer dentro
        numeros.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer numero) {
                if (numero % 2 != 0) System.out.println(numero);
            }
        });

        System.out.println("=================");

        //Usando lambda
        numeros.forEach(numero -> {
            if (numero % 2 != 0) System.out.println(numero);
        });
    }
}
