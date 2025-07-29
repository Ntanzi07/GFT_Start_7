package Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoa{
    private final List<Pessoa> pessoaList;

    public OrdenacaoPessoa() {
        this.pessoaList = new ArrayList<>();
    }

    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void adicionarPessoa(String nome, int idade, double altura){
        pessoaList.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade(){
        List<Pessoa> pessoaPorIdade = new ArrayList<>(pessoaList);
        Collections.sort(pessoaPorIdade);
        return pessoaPorIdade;
    }
    public List<Pessoa> ordenarPorAltura(){
        List<Pessoa> pessoaPorAltura = new ArrayList<>(pessoaList);
        pessoaPorAltura.sort(new ComparatorPorAltura());
        return pessoaPorAltura;
    }


    public static void main(String[] args) {
        var listaPessoas = new OrdenacaoPessoa();
        listaPessoas.adicionarPessoa("Nathan",22,1.8);
        listaPessoas.adicionarPessoa("Julia",21,1.73);
        listaPessoas.adicionarPessoa("Maud",16,1.55);
        listaPessoas.adicionarPessoa("Joao",18,1.6);
        listaPessoas.adicionarPessoa("Matheus",27,1.75);

        listaPessoas.getPessoaList().forEach(System.out::println);
        System.out.println("==============================================");
        listaPessoas.ordenarPorIdade().forEach(System.out::println);
        System.out.println("==============================================");
        listaPessoas.ordenarPorAltura().forEach(System.out::println);
    }
}
