package br.com.fiap.suna.exception;

public class SaldoInsuficienteException extends Exception {

    private static final long serialVersionUID = 1L;

    public SaldoInsuficienteException(String msg) {
        super(msg);
    }

    public SaldoInsuficienteException(double saldo) {
        System.out.println("Saldo Insuficiente, saldo disponível: R$" + saldo);
    }
}
