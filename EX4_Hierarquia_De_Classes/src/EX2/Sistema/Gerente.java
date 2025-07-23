package EX2.Sistema;

public class Gerente extends Usuario{

    public Gerente(String nome, String email, String senha){
        super(nome, email, senha, true);
    }

    public void GerarRelatório(){
        System.out.println("gerando Relatorio...");
    }
    
    public void ConsultarVendas(){
        System.out.println("gerando consulta de vendas...");
    }
}
