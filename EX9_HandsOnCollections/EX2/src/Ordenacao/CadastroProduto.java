package Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProduto {
    private final Set<Produto> produtoSet;

    public CadastroProduto() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(long codigo, String nome, double preco, int quantidade) {
        produtoSet.add(new Produto(codigo, nome, preco, quantidade));
    }

    public Set<Produto> exibirPorNome() {
        return new TreeSet<>(produtoSet);
    }

    public Set<Produto> exibirPorPreco() {
        Set<Produto> produtoPorPreco = new TreeSet<>(new CompararatorPorPreco());
        produtoPorPreco.addAll(produtoSet);
        return produtoPorPreco;
    }

    public static void main(String[] args) {
        CadastroProduto cadastroProduto = new CadastroProduto();
        cadastroProduto.adicionarProduto(1,"banana",8.99,5);
        cadastroProduto.adicionarProduto(2,"maca",14.55,2);
        cadastroProduto.adicionarProduto(3,"alface",15.99,3);
        cadastroProduto.adicionarProduto(4,"batata",2,10);
        cadastroProduto.adicionarProduto(5,"milho",10,7);

        cadastroProduto.exibirPorNome().forEach(System.out::println);
        System.out.println("==========================================");
        cadastroProduto.exibirPorPreco().forEach(System.out::println);
    }
}
