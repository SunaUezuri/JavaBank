package br.com.fiap.suna.model;

import br.com.fiap.suna.exception.SaldoInsuficienteException;

import java.util.Calendar;

public class ContaPoupanca extends Conta implements ContaInvestimento{

    private float taxa;

    public static final float RENDIMENTO = 0.05f;

    //ToString
    @Override
    public String toString() {
        return "Número da conta: " + getNumero() +
                " | Agência: " + getAgencia() +
                " | Titular: " + getTitular() +
                " | Saldo: R$" + getSaldo() +
                " | Taxa: " + taxa;
    }

    //Construtor
    public ContaPoupanca(int numero, int agencia, String titular, Calendar dataAbertura, double saldo, float taxa) {
        super(numero, agencia, titular, dataAbertura, saldo);
        this.taxa = taxa;
    }

    //Getters and Setters
    public float getTaxa() {
        return taxa;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    //Métodos personalizados
    @Override
    public void retirar(double valor) throws SaldoInsuficienteException {
        if (saldo < valor + taxa) {
            throw new SaldoInsuficienteException(saldo);
        }
        saldo -= valor + taxa;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public double calculaInvestimento() {
        return saldo * RENDIMENTO;
    }
}
