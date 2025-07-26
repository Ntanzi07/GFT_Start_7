package EX1;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resp;

        do {
            System.err.print("");
            System.err.print("\nDigite sua conta de adicao ou subtracao: ");
            resp = scanner.nextLine();
            String[] contas = resp.split(",");

            for (String conta : contas) {
                int somatoria = 0;
                String[] nums = conta.split("(?=[+-])");
                for (String num : nums) {
                    num.replace("+", "");
                    somatoria += Integer.valueOf(num);
                }
                System.out.println(conta + "=" + somatoria);
            }
        } while (!resp.isEmpty());
    }
}
