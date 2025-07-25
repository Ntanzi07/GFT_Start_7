package EX2;

import EX2.produtos.Alimentacao;
import EX2.produtos.Cultura;
import EX2.produtos.Saude;
import EX2.produtos.Vestuario;

public class App {
    public static void main(String[] args) {
        Alimentacao alimentacao = new Alimentacao("Banana",34.44);
        Vestuario veste = new Vestuario("Camisa", 35);
        Cultura livro = new Cultura("livroTop", 44);
        Saude saude = new Saude("remedio", 100);

        System.out.println(alimentacao);
        System.out.println(veste);
        System.out.println(livro);
        System.out.println(saude);

    }
}
