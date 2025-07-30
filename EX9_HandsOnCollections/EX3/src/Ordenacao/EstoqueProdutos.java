package Ordenacao;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> produtoMap;

    public EstoqueProdutos() {
        this.produtoMap = new HashMap<>();
    }

    public void add(Long key, String nome, double preco, int quantidade) {
        produtoMap.put(key, new Produto(nome, preco, quantidade));
    }

    public void exibirALL() {
        produtoMap.values().forEach(System.out::println);
    }

    public double valorTotalEstoque() {
        return produtoMap.values().stream()
                .mapToDouble(Produto::valorTotal)
                .sum();
    }

    public Produto obeterProdutoMaisCaro() {
        return produtoMap.values().stream()
                .max(Comparator.comparing(Produto::getPreco))
                .orElse(null);
    }

    public Produto obeterProdutoMaisBarato() {
        return produtoMap.values().stream()
                .min(Comparator.comparing(Produto::getPreco))
                .orElse(null);
    }

    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        estoqueProdutos.add(1L, "banana", 8.99, 5);
        estoqueProdutos.add(2L, "batata", 10, 2);
        estoqueProdutos.add(3L, "limao", 5, 10);
        estoqueProdutos.add(4L, "pao", 2.99, 8);

        estoqueProdutos.exibirALL();
        System.out.println("Valor total do estoque: "+estoqueProdutos.valorTotalEstoque());
        System.out.println("Produdo mais caro: "+estoqueProdutos.obeterProdutoMaisCaro());
        System.out.println("Produto mais barato: "+estoqueProdutos.obeterProdutoMaisBarato());
    }
}
