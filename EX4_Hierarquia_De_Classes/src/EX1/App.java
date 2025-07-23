package EX1;

public class App {
    public static void main(String[] args) {
        final double valorIngresso = 50;

        Ingresso incresso = new Ingresso("Super Top", valorIngresso, TipoAudio.DUBLADO);
        Meia incressoKid = new Meia("Kids+kids", valorIngresso, TipoAudio.DUBLADO);
        Familia incressoFamilia = new Familia("Para Toda Familia!", valorIngresso, TipoAudio.LEGENDADO, 4);
        
        System.out.print("");
        System.out.println(incresso);
        System.out.println("-----------------------");
        System.out.println(incressoKid);
        System.out.println("-----------------------");
        System.out.println(incressoFamilia);
    }
}
