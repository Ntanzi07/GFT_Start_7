package ex1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conta conta1 = new Conta("Nathan", 500);
        int opc;
        do {
            System.out.println("================BANCO TOP================");
            System.out.println("Ola " + conta1.getNome());
            if (conta1.getSaldo() > 0)
                System.out.println("Saldo Atual: " + conta1.getSaldo());
            else
                System.out.println("Usando Cheque especial! Saldo Atual do cheque: " + conta1.getSaldoSpecial());
            System.out.println("Cheque Especial: " + conta1.getSpecialCheck());
            System.out.println("[1] Sacar");
            System.out.println("[2] Depositar");
            System.out.println("[3] Pagar Boleto");
            System.out.println("[0] Sair");
            System.out.print("Por favor escolha uma das opcoes: ");
            opc = scanner.nextInt();
            switch (opc) {
                case 1:
                    System.out.print("Digite o valor para Sacar: ");
                    conta1.sacarMoney(scanner.nextDouble());
                    break;
                case 2:
                    System.out.print("Digite o valor para Depositar: ");
                    conta1.depositar(scanner.nextDouble());
                    break;
                case 3:
                    System.out.print("Digite o valor para Pagar o boleto: ");
                    conta1.pagarBoleto(scanner.nextDouble());
                    break;
                default:
                    break;
            }
            System.out.println("\n\n");
        } while (opc != 0);
        scanner.close();
    }
}
