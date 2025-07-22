import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scannerDec = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);

        // Escreva um código que receba o nome e o ano de nascimento de alguém e imprima
        // na tela a seguinte mensagem: "Olá 'Fulano' você tem 'X' anos"

        System.out.println("===============EX1===============");
        System.out.print("Escreva seu nome: ");
        String nome = scannerString.nextLine();
        System.out.print("Escreva seu ano de nascimento: ");
        int anoNasc = scannerDec.nextInt();
        int idade = LocalDate.now().getYear() - anoNasc;
        System.out.println("Olá " + nome + " você tem " + idade + " anos");

        // Escreva um código que receba o tamanho do lado de um quadrado, calcule sua
        // área e exiba na tela --> fórmula: área=lado X lado

        System.out.println("\n===============EX2===============");
        System.out.print("Informe o tamanho de um dos lados do quadrado (metros): ");
        double lado = scannerDec.nextDouble();
        double totalAreaQuadrado = Math.pow(lado, 2);
        System.out.println("A area total do seu quadrado: " + totalAreaQuadrado + "m");

        // Escreva um código que receba a base e a alturade um retângulo, calcule sua
        // área e exiba na tela --> fórmula: área=base X altura

        System.out.println("\n===============EX3===============");
        System.out.print("Informe o tamanho da base do retangulo (metros): ");
        double base = scannerDec.nextDouble();
        System.out.print("Informe o tamanho da altura do retangulo (metros): ");
        double altura = scannerDec.nextDouble();
        double totalAreaRetangulo = base * altura;
        System.out.println("A area total do seu retangulo: " + totalAreaRetangulo + "m");
        
        // Escreva um código que receba o nome e a idade de 2 pessoas e imprima a
        // diferença de idade entre elas
        
        System.out.println("\n===============EX4===============");
        System.out.print("Escreva o nome da pessoa 1: ");
        String nome1 = scannerString.nextLine();
        System.out.print("Escreva a idade da pessoa 1: ");
        int idade1 = scannerDec.nextInt();
        System.out.print("Escreva o nome da pessoa 2: ");
        String nome2 = scannerString.nextLine();
        System.out.print("Escreva a idade da pessoa 2: ");
        int idade2 = scannerDec.nextInt();
        int diferencaIdade = Math.abs(idade1 - idade2);
        System.out.println("A diferenca de idade entre " + nome1 + " e " + nome2 + " e de " + diferencaIdade + " anos");

        scannerString.close();
        scannerDec.close();
    }
}
