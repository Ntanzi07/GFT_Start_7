import java.io.IOException;

import br.com.dio.persistence.FilePersistence;
import br.com.dio.persistence.IOFilePersistence;

public class main {
    public static void main(String[] args) throws IOException {
        FilePersistence persistence = new IOFilePersistence("user.csv");
        System.out.println("==================Escrevendo==================");
        System.out.println(persistence.write("Nathan;nathan@gmail.com;03/07/2003;"));
        System.out.println(persistence.write("Julia;julia@gmail.com;20/10/2004;"));
        System.out.println(persistence.write("Maud;maud@gmail.com;04/11/2008;"));
        System.out.println("==================Lendo==================");
        System.out.println(persistence.findAll());
        System.out.println("==================Lendo Apenas==================");
        System.out.println(persistence.findBy("Nathan"));
        System.out.println(persistence.findBy("julia"));
        System.out.println(persistence.findBy("2008"));
        System.out.println("==================Excluindo==================");
        persistence.remove("2008");
        System.out.println(persistence.findAll());
        System.out.println("==================Alterando==================");
        persistence.replace("2004", "Julia;julia@gmail.com;20/10/2003;");
        System.out.println(persistence.findAll());

    }
}
