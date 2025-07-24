package EX3.Relogios;

enum Turno {
    PM,
    AM
}

public class RelogioAmericano extends Relogio {

    private Turno turno;

    public RelogioAmericano() {
        super();
        this.turno = Turno.AM;
    }

    @Override
    public void setHora(int hora) {

        super.setHora(hora > 12 ? hora - 12 : hora);
        setTurno(hora > 12 ? Turno.PM : Turno.AM);
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Turno getTurno() {
        return turno;
    }

    @Override
    public void setRelogio(Relogio newRelogio) {

        if (newRelogio instanceof RelogioAmericano relogio) {
            setHora(relogio.getHora());
            setTurno(relogio.getTurno());
        } else {
            int nowHora = newRelogio.getHora();
            setHora(nowHora > 12 ? nowHora - 12 : nowHora);
            setTurno(nowHora > 12 ? Turno.PM : Turno.AM);
        }

        setMinuto(newRelogio.getMinuto());
        setSegundo(newRelogio.getSegundo());
    }

    @Override
    public String toString() {
        return super.toString() + turno;
    }
}
