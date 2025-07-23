package ex1;

public class Conta {
    private String nome;
    private double saldo;
    private double saldoSpecial;
    private double specialCheck;

    public Conta(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;

        if (saldo <= 500)
            this.specialCheck = 50;
        else
            this.specialCheck = saldo * 0.5;

        this.saldoSpecial = this.specialCheck;
    }

    public void depositar(double quantidade) {
        if (this.saldoSpecial < this.specialCheck) {
            pagarBoleto(quantidade);
        } else {
            this.saldo += quantidade;
            System.out.println("Valor deposito na conta!\nNovo total conta: " + this.saldo);
        }

    }

    public void pagarBoleto(double quantidade) {
        this.saldoSpecial += quantidade;
        if (this.saldoSpecial > this.specialCheck) {
            double restoPagamento = this.saldoSpecial - this.specialCheck;
            this.saldoSpecial = this.specialCheck;
            depositar(restoPagamento);
        }
        System.out.println("Pagamento do saldo especial\nNovo total saldo especial: " + this.saldoSpecial);
    }

    private double pagamentoDebito(double quantidade) {
        System.out.println("Pagamento no debito de " + quantidade);
        return this.saldo -= quantidade;
    }

    private double pagamentoCredito(double quantidade) {
        System.out.println("Pagamento no Credito de " + quantidade);

        if (quantidade <= saldoSpecial)
            return this.saldoSpecial -= quantidade;

        return this.saldoSpecial -= quantidade + specialCheck * 0.2;
    }

    public double sacarMoney(double quantidade) {
        if (this.saldo >= quantidade)
            return pagamentoDebito(quantidade);
        else {
            quantidade -= this.saldo;
            pagamentoDebito(this.saldo);
            return pagamentoCredito(quantidade);
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public double getSaldoSpecial() {
        return saldoSpecial;
    }

    public double getSpecialCheck() {
        return specialCheck;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
