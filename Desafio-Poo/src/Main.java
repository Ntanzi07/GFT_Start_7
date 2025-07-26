import br.com.dio.desafio.domain.Curso;
import br.com.dio.desafio.domain.Mentoria;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Curso curso = new Curso("Curso Java", 10, "Descricao do curso de java");
        System.out.println(curso);

        Mentoria mentoria = new Mentoria("Mentoria de Java","Descricao da mentoria", LocalDate.now());
        System.out.println(mentoria);
    }
}

