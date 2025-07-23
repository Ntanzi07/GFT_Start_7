package EX1;

enum TipoAudio {
    DUBLADO,
    LEGENDADO
}

public class Ingresso {
    private String nomeFilme;
    private double valor;
    private TipoAudio tipoAudio;

    public Ingresso(String nomeFilme, double valor, TipoAudio tipoAudio) {
        this.nomeFilme = nomeFilme;
        this.valor = valor;
        this.tipoAudio = tipoAudio;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public TipoAudio getTipoAudio() {
        return tipoAudio;
    }

    public double getValor() {
        return valor;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public void setTipoAudio(TipoAudio tipoAudio) {
        this.tipoAudio = tipoAudio;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.getClass() +
                "\nNome do filme: " + this.nomeFilme +
                "\nTipo de audio: " + this.tipoAudio +
                "\nValor: " + this.valor + "R$";
    }
}
