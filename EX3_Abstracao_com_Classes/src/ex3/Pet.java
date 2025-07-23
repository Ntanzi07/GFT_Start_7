package ex3;

public class Pet {
    private String nome;
    private boolean limpo;

    public Pet(String nome) {
        this.nome = nome;
        this.limpo = false;
    }

    public String getNome() {
        return nome;
    }

    public boolean isLimpo() {
        return limpo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLimpo(boolean limpo) {
        this.limpo = limpo;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Nome:" + this.nome + "; Estado: " + (isLimpo() ? "limpo" : "sujo");
    }
}
