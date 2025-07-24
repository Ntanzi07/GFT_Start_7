package EX3.Relogios;

public class RelogioBrasileiro extends Relogio {

    @Override
    public void setRelogio(Relogio newRelogio) {

        if (newRelogio instanceof RelogioAmericano relogio) {
            int nowHora = relogio.getHora();
            setHora(relogio.getTurno() == Turno.AM ? nowHora : nowHora + 12);
        } else {
            setHora(newRelogio.getHora());
        }

        setMinuto(newRelogio.getMinuto());
        setSegundo(newRelogio.getSegundo());
    }
}
