import br.com.dio.desafio.domain.*;

import java.time.LocalDate;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Bootcamp bootcamp1 = new Bootcamp("java e .Net", "bootcamp de java e .Net");
        Dev dev = new Dev("Nathan");
        Dev dev2 = new Dev("Julia");

        bootcamp1.setConteudos(Set.of(
                new Curso("Curso Java", "Descricao do curso de java", 10),
                new Curso("Curso .Net", "Descricao do curso de .Net", 10),
                new Mentoria("Mentoria de Java", "Descricao da mentoria", LocalDate.now()),
                new Mentoria("Mentoria de .Net", "Descricao da .Net", LocalDate.now())
        ));

        dev.inscreverBootcamp(bootcamp1);
        dev2.inscreverBootcamp(bootcamp1);

        dev.progredir();

        System.out.println(dev);
        System.out.println(dev2);

    }
}

