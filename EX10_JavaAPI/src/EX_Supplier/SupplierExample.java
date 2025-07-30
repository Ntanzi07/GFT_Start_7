package EX_Supplier;

import java.util.stream.Stream;

public class SupplierExample {
    public static void main(String[] args) {

        var listaDeHello = Stream.generate(() -> "Hello World!!").limit(5).toList();

        listaDeHello.forEach(System.out::println);
    }
}
