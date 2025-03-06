package br.com.fiap.suna.model;

import br.com.fiap.suna.exception.SaldoInsuficienteException;

import javax.persistence.*;
import java.util.Calendar;

public abstract class Conta {

    private int numero;
    private int agencia;
    private String titular;
    private Calendar dataAbertura;
    protected double saldo;

    //Construtor


    public Conta(int numero, int agencia, String titular, Calendar dataAbertura, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.titular = titular;
        this.dataAbertura = dataAbertura;
        this.saldo = saldo;
    }

    //Getters and Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Calendar getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Calendar dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract void retirar(double valor) throws SaldoInsuficienteException;
    public abstract void depositar(double valor);
}
