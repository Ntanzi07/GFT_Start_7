
import br.com.dio.persistence.FilePersistence;
import br.com.dio.persistence.IOFilePersistence;
import br.com.dio.persistence.NIOFilePersistence;

public class main {
    public static void main(String[] args) throws IOException {
        // Java.io
        // FilePersistence persistence = new IOFilePersistence("user.csv");
        // System.out.println("==================Escrevendo==================");
        // System.out.println(persistence.write("Nathan;nathan@gmail.com;03/07/2003;"));
        // System.out.println(persistence.write("Julia;julia@gmail.com;20/10/2004;"));
        // System.out.println(persistence.write("Maud;maud@gmail.com;04/11/2008;"));
        // System.out.println("==================Lendo==================");
        // System.out.println(persistence.findAll());
        // System.out.println("==================Lendo Apenas==================");
        // System.out.println(persistence.findBy("Nathan"));
        // System.out.println(persistence.findBy("julia"));
        // System.out.println(persistence.findBy("2008"));
        // System.out.println("==================Excluindo==================");
        // persistence.remove("2008");
        // System.out.println(persistence.findAll());
        // System.out.println("==================Alterando==================");
        // persistence.replace("2004", "Julia;julia@gmail.com;20/10/2003;");
        // System.out.println(persistence.findAll());

        // java.nio
        FilePersistence persistenceN = new NIOFilePersistence("user.csv");
        System.out.println("==================Escrevendo==================");
        System.out.println(persistenceN.write("Nathan;nathan@gmail.com;03/07/2003;"));
        System.out.println(persistenceN.write("Julia;julia@gmail.com;20/10/2004;"));
        System.out.println(persistenceN.write("Maud;maud@gmail.com;04/11/2008;"));
        System.out.println("==================Lendo==================");
        System.out.println(persistenceN.findAll());
        System.out.println("==================Lendo Apenas==================");
        System.out.println(persistenceN.findBy("Nathan"));
        System.out.println(persistenceN.findBy("julia"));
        System.out.println(persistenceN.findBy("2008"));
        System.out.println("==================Excluindo==================");
        persistenceN.remove("2008");
        System.out.println(persistenceN.findAll());
        System.out.println("==================Alterando==================");
        persistenceN.replace("2004", "Julia;julia@gmail.com;20/10/2003;");
        System.out.println(persistenceN.findAll());
    }
}
