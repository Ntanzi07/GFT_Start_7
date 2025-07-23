package ex2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Carro carro1 = new Carro();
        Scanner scannerTop = new Scanner(System.in);

        int opc;
        do {
            System.out.println("================Seu Carro================");
            System.out.println(carro1.getIsCarRunning() ? "Carro Ligado" : "Carro Desligado");
            System.out.println("Velocidade: " + carro1.getVelocidade());
            System.out.println("Marcha: " + carro1.getMarcha());
            System.out.println("Roda: " + carro1.getGrauRoda());
            System.out.println("---------------------------------------");
            System.out.println("[1] Ligar carro");
            System.out.println("[2] Desligar carro");
            System.out.println("[3] Acelerar");
            System.out.println("[4] Desacelerar");
            System.out.println("[5] Virar Carro");
            System.out.println("[6] Trocar Marcha");
            System.out.println("[0] sair");
            System.out.print("Digite sua opcao: ");
            opc = scannerTop.nextInt();

            switch (opc) {
                case 1:
                    carro1.ligarCarro();
                    break;
                case 2:
                    carro1.desligarCarro();
                    break;
                case 3:
                    carro1.acelerar();
                    break;
                case 4:
                    carro1.desacelerar();
                    break;
                case 5:
                    System.out.println("\nVirar para: [-1] Esquerda - [0] Reto - [1] Direita");
                    System.out.print("Digite sua opcao: ");
                    int direcao = scannerTop.nextInt();
                    carro1.virarRoda(direcao);
                    break;
                case 6:
                    System.out.println("\nQual a nova Marcha\n[0] ponto morto\n[1] primeira\n[2] segunda\n[3] terceira\n[4] quarta\n[5] quinta\n[6] sexta");
                    System.out.print("Digite sua opcao: ");
                    int novaMarcha = scannerTop.nextInt();
                    carro1.trocarMarcha(novaMarcha);

                    break;
                default:
                    break;
            }
        } while (opc != 0);
        scannerTop.close();
    }
}
