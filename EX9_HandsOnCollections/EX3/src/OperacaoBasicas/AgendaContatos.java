package OperacaoBasicas;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AgendaContatos {
    private final Map<String, String> agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void add(String nome, String telefone) {
        agendaContatoMap.put(nome, telefone);
    }

    public void remove(String nome) {
        if (agendaContatoMap.isEmpty()) {
            System.out.println("Map Vazio");
            return;
        }

        agendaContatoMap.remove(nome);
    }

    public String pesquisarPorNome(String nome) {
        return agendaContatoMap.get(nome);
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();
        agendaContatos.add("Nathan", "15997228065");
        agendaContatos.add("Julia", "15997227055");
        agendaContatos.remove("nathan");
        System.out.println(agendaContatos.pesquisarPorNome("Julia"));
    }

}
