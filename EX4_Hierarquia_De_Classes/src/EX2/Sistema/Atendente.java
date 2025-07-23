package EX2.Sistema;

public class Atendente extends Usuario {
    private double valorEmCaixa;

    public Atendente(String nome, String email, String senha){
        super(nome, email, senha, false);
        this.valorEmCaixa = 0;
    }

    public double getValorEmCaixa() {
        return valorEmCaixa;
    }

    public void receberPagamento(double valor){
        valorEmCaixa += valor;
    }

    public void fecharCaixa(){
        System.out.println("Caixa fechado em " + valorEmCaixa);
        valorEmCaixa = 0;
    }
}
