package ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scannerTop = new Scanner(System.in);

        Petshop petshop = new Petshop();
        List<Pet> listaDePets = new ArrayList<>();
        listaDePets.add(new Pet("Toby"));
        listaDePets.add(new Pet("Toto"));
        listaDePets.add(new Pet("Cristal"));

        int opc;
        do {
            System.out.println("================Seu PetShop================");
            System.out.println("Fila:");
            for (Pet petzim : listaDePets) {
                System.out.println(petzim.toString());
            }
            System.out.println("---------------------------------------");
            System.out.println("Nivel agua: " + petshop.getNivelAgua());
            System.out.println("Nivel Shampoo: " + petshop.getNivelShampoo());
            System.out.println("Estado da Maquina: " + (petshop.isMaquinaLimpa() ? "limpa" : "suja"));
            System.out.println("Ocupada: " + (petshop.isPetOn() ? "Sim": "Nao"));
            System.out.println("---------------------------------------");
            System.out.println("[1] Dar Banho");
            System.out.println("[2] Abastecer agua");
            System.out.println("[3] Abastecer Shampoo");
            System.out.println("[4] Colocar Pet");
            System.out.println("[5] Tirar Pet");
            System.out.println("[6] Limpar Maquina");
            System.out.println("[0] Sair");
            System.out.print("Digite sua opcao: ");
            opc = scannerTop.nextInt();

            switch (opc) {
                case 1:
                    petshop.darBanho();
                    break;
                case 2:
                    petshop.abastecerAgua();
                    break;
                case 3:
                    petshop.abastecerShampoo();
                    break;
                case 4:
                int escolha;
                do {
                        System.out.println("\nEscolha qual colocar primeiro:");
                        for(int i = 0; i < listaDePets.size(); i++){
                            System.out.printf("[%d] %s\n",i, listaDePets.get(i).getNome());
                        }
                        System.out.println("Digite sua escolha:");
                        escolha = scannerTop.nextInt();
                    } while (escolha >= listaDePets.size() || escolha < 0);
                    petshop.colocarPet(listaDePets.get(escolha));
                    break;
                case 5:
                    petshop.retirarPet();
                    break;
                case 6:
                    petshop.limparMaquina();
                    break;

                default:
                    break;
            }
        } while (opc != 0);
        scannerTop.close();
    }
}
