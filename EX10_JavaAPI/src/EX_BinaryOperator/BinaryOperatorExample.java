package EX_BinaryOperator;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    public static void main(String[] args) {

        List<Integer> listaNum = Arrays.asList(1, 2, 3, 4, 5, 6);

        BinaryOperator<Integer> somar = (num1, num2) -> num1 + num2;

        int resultdado = listaNum.stream().reduce(0, Integer::sum);

        System.out.println(resultdado);
    }
}
