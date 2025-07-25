package EX3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opc;
        do {
            System.out.println("Qual forma desseja calcular a area:");
            System.out.println("[1] Quadrado");
            System.out.println("[2] Triangulo");
            System.out.println("[3] Circulo");
            System.out.println("[0] sair");
            System.out.print("Digite sua escolha: ");
            opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    System.out.print("Digite o lado do seu quadrado: ");
                    double side = scanner.nextDouble();
                    Square square = new Square(side);
                    System.out.println("A area do sue quadrado: " + square.getArea());
                    break;
                case 2:
                    System.out.print("Digite a base do seu triangulo: ");
                    double base = scanner.nextDouble();
                    System.out.print("Digite a altura do seu triangulo: ");
                    double height = scanner.nextDouble();
                    Triangle triangle = new Triangle(height, base);
                    System.out.println("A area do sue triangulo: " + triangle.getArea());
                    break;
                case 3:
                    System.out.print("Digite o raio do seu circulo: ");
                    double radius = scanner.nextDouble();
                    Circle circle = new Circle(radius);
                    System.out.println("A area do sue Circulo: " + circle.getArea());
                    break;
                default:
                    break;
            }
        } while (opc != 0);

        scanner.close();
    }
}
