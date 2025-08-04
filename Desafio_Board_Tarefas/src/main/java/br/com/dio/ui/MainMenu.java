package br.com.dio.ui;

import java.util.Scanner;

public class MainMenu {
    private final Scanner scanner = new Scanner(System.in);

    public void execute() {
        System.out.println("Bem vindo ao gerenciador de board!");
        var option = -1;
        while (true) {
            System.out.println("1 - Criar um novo board");
            System.out.println("2 - Selecionar um board existente");
            System.out.println("3 - Excluir um board");
            System.out.println("4 - Sair");
            System.out.println("Escolha sua opcao: ");
            option = scanner.nextInt();
            switch (option) {
                case 1 -> createBoard();
                case 2 -> selectBoard();
                case 3 -> deleteBoard();
                case 4 -> System.exit(0);
                default -> System.out.println("Essa opcao nao existe!!!");
            }
        }
    }

    private void createBoard() {

    }

    private void selectBoard() {

    }

    private void deleteBoard() {
        System.out.println("Informe o id do board que sera excluido");
        var id = scanner.nextLong();
    }
}
