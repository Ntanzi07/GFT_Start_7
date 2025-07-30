package OperacaoBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {

    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }

    public Set<Convidado> getConvidadoSet() {
        return convidadoSet;
    }

    public void adicionarConvidado(String nome, int codigoConvite) {
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigo(int codigoConvite) {
        if (!convidadoSet.removeIf(convidado -> convidado.getCodigoConvite() == codigoConvite))
            System.out.printf("O convidado numero %d nao existe para remover!!!\n", codigoConvite);
    }

    public int contarConvidados() {
        return convidadoSet.size();
    }

    public void exibirConvidados() {
        convidadoSet.forEach(System.out::println);
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();
        conjuntoConvidados.adicionarConvidado("Nathan", 1);
        conjuntoConvidados.adicionarConvidado("Julia", 2);
        conjuntoConvidados.adicionarConvidado("Maud", 3);
        conjuntoConvidados.adicionarConvidado("Adonis", 4);
        conjuntoConvidados.adicionarConvidado("Jean", 5);
        conjuntoConvidados.adicionarConvidado("Matheus", 5);
        System.out.println("Existem "+ conjuntoConvidados.contarConvidados() + " convidados");
        conjuntoConvidados.exibirConvidados();
        conjuntoConvidados.removerConvidadoPorCodigo(6);
        conjuntoConvidados.removerConvidadoPorCodigo(5);
        conjuntoConvidados.exibirConvidados();
    }
}
