package EX2.Sistema;

public abstract class Usuario {
    private String nome;
    private String email;
    private String senha;
    private final boolean ADM;
    private boolean logado;

    public Usuario(String nome, String email, String senha, boolean isADM) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ADM = isADM;
        this.logado = false;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        if (!isLogado()) {
            System.out.println("nescessario login para alterar Email!");
            return;
        }
        this.email = email;
    }

    public void alterarNome(String nome) {
        if (!isLogado()) {
            System.out.println("nescessario login para alterar nome!");
            return;
        }
        this.nome = nome;
    }

    public void alterarSenha(String senha) {
        if (!isLogado()) {
            System.out.println("nescessario login para alterar senha!");
            return;
        }
        this.senha = senha;
    }

    public boolean isLogado() {
        return logado;
    }

    public boolean isADM() {
        return ADM;
    }

    public void login(String senha) {
        if (isLogado()) {
            System.out.println("ja esta logado!!");
            return;
        }
        if (this.senha != senha) {
            System.out.println("Senha incorreta!!");
            return;
        }

        System.out.println("Logado!!");
        this.logado = true;
    }

    public void logoff() {
        if (!isLogado()) {
            System.out.println("voce nao esta logado!!");
            return;
        }

        System.out.println("Saindo...");
        this.logado = false;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "Email: " + email +
                "Tipo Usuario: " + (isADM() ? "Administrador" : "Padrao");
    }
}
