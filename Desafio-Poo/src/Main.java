import br.com.dio.desafio.domain.Conteudo;
import br.com.dio.desafio.domain.Curso;
import br.com.dio.desafio.domain.Mentoria;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Conteudo curso = new Curso("Curso Java", "Descricao do curso de java", 10);
        System.out.println(curso);

        Conteudo mentoria = new Mentoria("Mentoria de Java","Descricao da mentoria", LocalDate.now());
        System.out.println(mentoria);
    }
}

