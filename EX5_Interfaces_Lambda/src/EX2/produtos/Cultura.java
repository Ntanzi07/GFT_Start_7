package EX2.produtos;

public class Cultura implements Produtos {
    private String nome;
    private double valor;

    public Cultura(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public double valorImposto() {
        return valor * 0.04;
    }

    @Override
    public double novoValor() {
        return valor + valorImposto();
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                " |Valor: " + valor +
                " |Imposto: " + valorImposto() +
                " |Valor Total: " + novoValor();
    }
}
