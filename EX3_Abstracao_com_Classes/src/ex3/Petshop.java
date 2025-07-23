package ex3;

public class Petshop {

    private double nivelAgua;
    private double nivelShampoo;
    private Pet petOn;
    private boolean maquinaLimpa;

    public Petshop() {
        nivelAgua = 30;
        nivelShampoo = 10;
        maquinaLimpa = true;
    }

    public void darBanho() {
        if (!isPetOn()) {
            System.out.println("Nao tem pet na maquina!!");
            return;
        }

        if (!isMaquinaLimpa()) {
            System.out.println("A maquina esta suja!!");
            return;
        }

        if (this.nivelAgua < 10 || this.nivelShampoo < 2) {
            System.out.println("Nivel de agua ou shampoo muito baixos");
            return;
        }

        this.nivelAgua -= 10;
        this.nivelShampoo -= 2;
        petOn.setLimpo(true);
    }

    public void abastecerAgua() {
        if (nivelAgua < 30) {
            nivelAgua += 2;
            if (nivelAgua > 30)
                nivelAgua = 30;
        } else
            System.out.println("Nivel maximo de Agua");

    }

    public void abastecerShampoo() {
        if (nivelShampoo < 10) {
            nivelShampoo += 2;
            if (nivelShampoo > 10)
                nivelAgua = 10;
        } else
            System.out.println("Nivel maximo de shampoo");

    }

    public double getNivelAgua() {
        return nivelAgua;
    }

    public double getNivelShampoo() {
        return nivelShampoo;
    }

    public boolean isMaquinaLimpa() {
        return maquinaLimpa;
    }

    public boolean isPetOn() {
        return petOn != null;
    }

    public void retirarPet() {
        if (!isPetOn()) {
            System.out.println("Nao tem pet na maquina!!");
            return;
        }

        if (!petOn.isLimpo())
            this.maquinaLimpa = false;

        this.petOn = null;
    }

    public void colocarPet(Pet petzinho) {
        if (isPetOn()) {
            System.out.println("Ja tem pet na maquina!!");
            return;
        }

        petOn = petzinho;
    }

    public void limparMaquina() {
        if (this.nivelAgua < 3 || this.nivelShampoo < 1) {
            System.out.println("Nivel de agua ou shampoo muito baixos");
            return;
        }
        this.nivelAgua -= 3;
        this.nivelShampoo--;
        this.maquinaLimpa = true;
    }
}
