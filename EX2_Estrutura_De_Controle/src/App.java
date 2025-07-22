import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    Scanner scannerDesc = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);

    // Escreva um código onde o usuário entra com um número e seja gerada a tabuada
    // de 1 até 10 desse número;

    System.out.println("===============EX1===============");
    System.out.print("Digite um numero para a tabuada: ");
    double numTabuada = scannerDesc.nextDouble();
    for (int i = 1; i <= 10; i++) {
      double resultado = numTabuada * i;
      System.out.printf("%.2f x %d = %.2f\n", numTabuada, i, resultado);
    }

    // Escreva um código onde o usuário entra com sua altura e peso, seja feito o
    // calculo do seu IMC(IMC = peso/(altura * altura)) e seja exibida a mensagem de
    // acordo com o resultado:
    // Se for menor ou igual a 18,5 "Abaixo do peso";
    // se for entre 18,6 e 24,9 "Peso ideal";
    // Se for entre 25,0 e 29,9 "Levemente acima do peso";
    // Se for entre 30,0 e 34,9 "Obesidade Grau I";
    // Se for entre 35,0 e 39,9 "Obesidade Grau II (Severa)";
    // Se for maior ou igual a 40,0 "Obesidade III (Mórbida)";

    System.out.println("===============EX2===============");
    System.out.print("Digite seu peso (kg): ");
    double peso = scannerDesc.nextDouble();
    System.out.print("Digite seu altura (m): ");
    double altura = scannerDesc.nextDouble();
    double imc = peso / Math.pow(altura, 2);
    System.out.printf("Seu IMC: %.2f\n", imc);
    if (imc <= 18.5)
      System.out.println("--> Abaixo do peso");
    else if (imc < 25)
      System.out.println("--> Peso ideal");
    else if (imc < 30)
      System.out.println("--> Levemente acima do peso");
    else if (imc < 35)
      System.out.println("--> Obesidade Grau I");
    else if (imc < 40)
      System.out.println("--> Obesidade Grau II (Severa)");
    else
      System.out.println("--> Obesidade III (Mórbida)");

    // Escreva um código que o usuário entre com um primeiro número, um segundo
    // número maior que o primeiro e escolhe entre a opção par e impar, com isso o
    // código deve informar todos os números pares ou ímpares (de acordo com a
    // seleção inicial) no intervalo de números informados, incluindo os números
    // informados e em ordem decrescente;

    System.out.println("===============EX3===============");
    System.out.print("Digite um numero inteiro: ");
    int num1 = scannerDesc.nextInt();

    int num2;
    do {
      System.out.print("Digite um segundo numero inteiro maior que o primeiro: ");
      num2 = scannerDesc.nextInt();
    } while (num1 >= num2);

    int opc;
    do {
      System.out.print("[1] par \n[2] impar\n Sua opcao: ");
      opc = scannerDesc.nextInt();
    } while (opc < 1 || opc > 2);

    if (opc == 1) {
      for (int i = num2; i >= num1; i--)
        if ((i % 2) == 0)
          System.out.println(i);
    } else {
      for (int i = num2; i >= num1; i--)
        if ((i % 2) != 0)
          System.out.println(i);
    }

    // Escreva um código onde o usuário informa um número inicial, posteriormente
    // irá informar outros N números, a execução do código irá continuar até que o
    // número informado dividido pelo primeiro número tenha resto diferente de 0 na
    // divisão, números menores que o primeiro número devem ser ignorados

    System.out.println("===============EX4===============");
    int numDivisor;
    do {
      System.out.print("Digite um numero inicial diferente de 0: ");
      numDivisor = scannerDesc.nextInt();
    } while (numDivisor == 0);

    int numDividendo;
    do {
      System.out.print("Digite um numero para ser o dividendo: ");
      numDividendo = scannerDesc.nextInt();
      if (numDividendo < 0)
        System.out.println("numero negativo nao pode !!");
      else
        System.out.printf("%d / %d = %.2f\n", numDividendo, numDivisor, (double) numDividendo / numDivisor);
    } while (numDividendo < 0 || (numDividendo % numDivisor) != 0);
    System.out.println("Resultado com resto 0!!");
    scannerDesc.close();
    scannerString.close();
  }
}
