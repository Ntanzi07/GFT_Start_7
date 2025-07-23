package EX2.Sistema;

public class Vendedor extends Usuario {
    private int quantVendas;

    public Vendedor(String nome, String email, String senha){
        super(nome, email, senha, false);
        this.quantVendas = 0;
    }

    public void efetuarVenda(){
        this.quantVendas++;
    }

    public void ConsultarVendas(){
        System.out.println("Vendas total: "+ quantVendas);
    }

}
