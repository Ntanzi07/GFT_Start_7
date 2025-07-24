package EX3;

import EX3.Relogios.RelogioAmericano;
import EX3.Relogios.RelogioBrasileiro;

public class App {
    public static void main(String[] args) {
        RelogioAmericano watch = new RelogioAmericano();
        RelogioBrasileiro relogio = new RelogioBrasileiro();

        System.out.println("");
        relogio.setHora(14);
        relogio.setMinuto(30);
        relogio.setSegundo(12);

        watch.setHora(6);
        watch.setMinuto(20);
        watch.setSegundo(34);

        System.out.println(relogio);
        System.out.println(watch);
        System.out.println("====================");
        watch.setRelogio(relogio);
        System.out.println(relogio);
        System.out.println(watch);

    }
}
