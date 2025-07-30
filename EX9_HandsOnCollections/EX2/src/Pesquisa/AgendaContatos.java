package Pesquisa;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void add(String nome, String numero) {
        contatoSet.add(new Contato(nome, numero));
    }

    public void remove(String nome) {
        if (!contatoSet.removeIf(contato -> contato.getNome().equalsIgnoreCase(nome)))
            System.out.println("Nao existe esse contato para remover!!");
    }

    public Set<Contato> buscaPorNome(String nome) {
        return contatoSet.stream()
                .filter(contato -> contato.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toSet());
    }

    public void atualizarContato(String nome, String numero, String novoNumero) {
        var contatosPorNome = buscaPorNome(nome);
        contatosPorNome.stream()
                .filter(contato -> contato.getNumero().equalsIgnoreCase(numero))
                .findFirst()
                .ifPresent(contato -> contato.setNumero(novoNumero));
    }

    public void exibirContatos() {
        contatoSet.forEach(System.out::println);
    }


    public static void main(String[] args) {
        final AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.add("Nathan", "15997228065");
        agendaContatos.add("Julia", "15997228065");
        agendaContatos.add("Julia", "15997226623");
        agendaContatos.add("Maud", "159923523443");
        agendaContatos.add("Nathan bolado", "345364634542");
        agendaContatos.add("Nathan", "345345312562");

        agendaContatos.buscaPorNome("nathan").forEach(System.out::println);
        agendaContatos.atualizarContato("nathan","345345312562","15997223232");
        agendaContatos.buscaPorNome("nathan").forEach(System.out::println);
    }
}
