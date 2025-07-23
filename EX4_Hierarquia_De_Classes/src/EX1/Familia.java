package EX1;

public class Familia extends Ingresso {
    private int quantidade;

    public Familia(String nomeFilme, double valor, TipoAudio tipoAudio, int quantidade) {
        super(nomeFilme, valor * quantidade, tipoAudio);
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nQuantidade: " + this.quantidade;
    }
}
