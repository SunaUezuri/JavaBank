package br.com.fiap.suna.main;

import br.com.fiap.suna.exception.SaldoInsuficienteException;
import br.com.fiap.suna.model.ContaCorrente;
import br.com.fiap.suna.model.TipoConta;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class View {
    public static void main(String[] args) {
        //Criando uma conta corrente
        Calendar data = new GregorianCalendar(2021, Calendar.JANUARY, 10);
        ContaCorrente cc = new ContaCorrente(1000, 1234, "José", data, 10000, TipoConta.COMUM);

        //Chamar o método para saque/retirada
        try {
            cc.retirar(1000);
            System.out.println("Saldo retirado com sucesso! Saldo restante: " + cc.getSaldo());
        } catch (SaldoInsuficienteException e) {
            System.err.println(e.getMessage());
        }

        //Criando a lista de contas
        List<ContaCorrente> lista = new ArrayList<ContaCorrente>();

        //Adicionando contas a lista
        lista.add(cc);
        lista.add(new ContaCorrente(2578, 3548, "Rafaela", data, 100, TipoConta.COMUM));
        lista.add(new ContaCorrente(2167, 4782, "Maria", Calendar.getInstance(), 30000, TipoConta.PREMIUM));

        //Imprimindo todas as contas
        System.out.println("Contas encontrados: \n");
        for (ContaCorrente c : lista){
            System.out.println(c);
        }
    }
}
