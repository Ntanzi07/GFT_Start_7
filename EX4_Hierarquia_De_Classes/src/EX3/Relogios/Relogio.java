package EX3.Relogios;

public abstract class Relogio {
    private int hora;
    private int minuto;
    private int segundo;

    public Relogio(){
        this.hora = 0;
        this.minuto = 0;
        this.segundo = 0;
    }

    public abstract void setRelogio(Relogio newRelogio);

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setHora(int hora) {
        if (hora < 0 || hora >= 24)
            System.out.println("As horas vão de 0 a 25");
        else
            this.hora = hora;
    }

    public void setMinuto(int minuto) {
        if (hora < 0 || hora >= 60)
            System.out.println("O minutos vão de 0 a 60");
        else
            this.minuto = minuto;
    }

    public void setSegundo(int segundo) {
        if (hora < 0 || hora >= 60)
            System.out.println("Os segundos vão de 0 a 60");
        else
            this.segundo = segundo;
    }

    @Override
    public String toString() {
        return hora + ":" + minuto + ":" + segundo;
    }

}
