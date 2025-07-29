package Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private final List<Livro> livrosList;

    public CatalogoLivros() {
        this.livrosList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int ano) {
        livrosList.add(new Livro(titulo, autor, ano));
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        return livrosList.stream()
                .filter(livro -> livro.getAutor().equalsIgnoreCase(autor))
                .toList();
    }

    public List<Livro> pesquisarPorIntervaloDeAno(int anoInicial, int anoFinal) {
        return livrosList.stream()
                .filter(livro -> anoInicial <= livro.getAnoPublicacao() && livro.getAnoPublicacao() <= anoFinal)
                .toList();
    }

    public Livro pesquisarPorTitulo(String titulo) {
        return livrosList.stream()
                .filter(livro -> livro.getTitulo().equals(titulo))
                .findFirst().orElse(null);
    }

    public static void main(String[] args) {
        var listaLivros = new CatalogoLivros();

        listaLivros.adicionarLivro("Arvore morta", "Nathan", 2020);
        listaLivros.adicionarLivro("Bom dia Flor do dia", "Nathan", 2021);
        listaLivros.adicionarLivro("Olhos do bem", "Julia", 2013);
        listaLivros.adicionarLivro("Paraiso", "Maud", 2023);
        listaLivros.adicionarLivro("Programacao Java 1", "Matheu", 1990);
        listaLivros.adicionarLivro("Bom dia Flor do dia 2", "Nathan", 2023);

        System.out.println(listaLivros);
        System.out.println("================ Buscando por Nathan =================");
        listaLivros.pesquisarPorAutor("nathan").forEach(System.out::println);
        System.out.println("================ Buscando por livros entre 2020 e 2025 ==================");
        listaLivros.pesquisarPorIntervaloDeAno(2020, 2025).forEach(System.out::println);
        System.out.println("=============== Buscando Bom dia Flor do dia ==================");
        System.out.println(listaLivros.pesquisarPorTitulo("Bom dia Flor do dia"));
        System.out.println("=============== Buscando Bom dia Flor do dia 2 ==================");
        System.out.println(listaLivros.pesquisarPorTitulo("Bom dia Flor do dia 2"));
        System.out.println("=============== Buscando Bom dia Flor do dia 3 ==================");
        System.out.println(listaLivros.pesquisarPorTitulo("Bom dia Flor do dia 3"));



    }
}
