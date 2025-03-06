package br.com.fiap.suna.model;

import br.com.fiap.suna.exception.SaldoInsuficienteException;

import java.util.Calendar;

public class ContaCorrente extends Conta{

    private TipoConta tipo;

    @Override
    public String toString() {
        return "Número da conta: " + getNumero() +
                " | Agência: " + getAgencia() +
                " | Titular: " + getTitular() +
                " | Saldo: R$" + getSaldo() +
                " | Tipo da conta: " + tipo;
    }

    //Construtores
    public ContaCorrente(int numero, int agencia, String titular, Calendar dataAbertura, double saldo, TipoConta tipo){
        super(numero, agencia, titular, dataAbertura, saldo);
        this.tipo = tipo;
    }

    //Getters and Setters

    public TipoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }

    //Métodos
    @Override
    public void retirar(double valor) throws SaldoInsuficienteException{
        if (tipo == TipoConta.COMUM && valor > saldo) {
            throw new SaldoInsuficienteException(saldo);
        }
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        if (valor == 0) {
            System.out.println("Não é possível depositar 0");
        }
        saldo += valor;
    }


}
