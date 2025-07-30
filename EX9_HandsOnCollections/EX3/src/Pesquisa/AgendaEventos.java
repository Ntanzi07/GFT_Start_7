package Pesquisa;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventoMap;

    public AgendaEventos() {
        this.eventoMap = new HashMap<>();
    }

    public void add(LocalDate data, String nome, String descricao) {
        eventoMap.put(data, new Evento(nome, descricao));
    }

    public void showAll() {
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventoMap);
        eventosTreeMap.values().forEach(System.out::println);
    }

    public void obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventoMap);

        eventosTreeMap.entrySet().stream()
                .filter(entry -> entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual))
                .findFirst()
                .ifPresent(entry -> {
                    System.out.println("O proximo evento: " + entry.getValue() + " acontecera na data " + entry.getKey().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                });
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();
        agendaEventos.add(LocalDate.of(2025, Month.JULY, 15), "Evento TopJava", "evento de java");
        agendaEventos.add(LocalDate.of(2025, Month.AUGUST, 15), "Evento TopJava 2", "evento de java 2");
        agendaEventos.add(LocalDate.of(2025, Month.SEPTEMBER, 15), "Evento TopJava 3", "evento de java 3");

        agendaEventos.showAll();

        agendaEventos.obterProximoEvento();
    }
}
