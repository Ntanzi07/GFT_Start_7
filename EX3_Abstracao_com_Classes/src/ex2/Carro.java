package ex2;

public class Carro {
    private boolean isCarRunning; // ligado ou desligado
    private int velocidade; // velocidade
    private int grauRoda; // grau da roda -1 a 1
    private int marcha; // marcha
    private int[][] intervaloMarcha = {
            { 0, 0 },
            { 0, 30 },
            { 20, 50 },
            { 40, 70 },
            { 60, 90 },
            { 80, 110 },
            { 100, 120 },
    }; // intervalo das marchas

    public Carro() {
        this.isCarRunning = false;
        this.velocidade = 0;
        this.marcha = 0;
        this.grauRoda = 0;
    }

    public void ligarCarro() {
        isCarRunning = true;
    }

    public void desligarCarro() {
        if (this.marcha != 0 || this.velocidade != 0)
            System.out.println("O carro apenas pode desligar na marcha 0 e velocidade 0");
        else
            isCarRunning = false;
    }

    public void acelerar() {
        if (velocidade != intervaloMarcha[marcha][1])
            System.out.println("Velocidade: " + ++velocidade);
        else
            System.out.println("Carro na velocidade maxima da marcha!");
    }

    public void desacelerar() {
        if (velocidade != intervaloMarcha[marcha][0])
            System.out.println("Velocidade: " + --velocidade);
        else
            System.out.println("Carro na velocidade minima da marcha!");
    }

    public void trocarMarcha(int novaMarcha) {
        if (novaMarcha < 0 || novaMarcha > 6) {
            System.out.println("A Marcha deve estar entre 0 a 6");
            return;
        }

        if (velocidade < intervaloMarcha[novaMarcha][0] || velocidade > intervaloMarcha[novaMarcha][1]) {
            System.out.println("O carro nao pode pular marcha");
            return;
        }

        this.marcha = novaMarcha;
    }

    public void virarRoda(int lado) {
        if (lado < -1 || lado > 1) {
            System.out.println("O carro virar apenas para [-1] Esquerda [0] Reto ou [1] Direita ");
            return;
        }
        if (this.velocidade < 1 || this.velocidade > 40) {
            System.out.println("O carro precisa estrar entre 1 a 40 km/h para virar");
            return;
        }

        this.grauRoda = lado;
        switch (lado) {
            case -1:
                System.out.println("Virando para esquerda");
                break;
            case 0:
                System.out.println("Seguindo reto");
                break;
            case 1:
                System.out.println("Virando para direita");
                break;
        }

    }

    public String getGrauRoda() {
        switch (this.grauRoda) {
            case -1:
                return "Roda para Esquerda";
            case 0:
                return "Roda para frente";
            case 1:
                return "Roda para Direita";
            default:
                return "";
        }
    }

    public int getMarcha() {
        return marcha;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public boolean getIsCarRunning() {
        return isCarRunning;
    }
}
