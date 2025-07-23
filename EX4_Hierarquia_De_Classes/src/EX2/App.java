package EX2;

import EX2.Sistema.Atendente;
import EX2.Sistema.Gerente;
import EX2.Sistema.Vendedor;

public class App {

    public static void main(String[] args) {
        Gerente gerente = new Gerente("Nathan", "nathan@123.com", "123456");
        Vendedor vendedor = new Vendedor("Matheus", "ma@123.com", "123");
        Atendente atendente = new Atendente("Junior", "Junim@123.com", "123");

        gerente.login("123456");
        gerente.ConsultarVendas();
        gerente.alterarSenha("321321");
        gerente.logoff();
        
    }

}
