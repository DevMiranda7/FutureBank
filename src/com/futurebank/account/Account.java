package com.futurebank.account;

import com.futurebank.client.AccountHolder;

import java.util.Random;

public class Account {
    //Atributos
    private int agencia;
    private int numero;
    private double saldo;
    private AccountHolder titular;

    //Gerar numeros aleatorios para agência e número da conta
    Random numeros = new Random();
    //Construtor
    public Account(){
        this.agencia = numeros.nextInt(9999)+1010;
        this.numero  = numeros.nextInt(9888)+2012;
        System.out.println("Sua Agência: " + this.agencia);
        System.out.println("Número da sua conta: " + this.numero);
    }
// metodos

    public void setTitular(AccountHolder nomeAccountHolder){

        this.titular = nomeAccountHolder;
    }
    public AccountHolder getTitular(){
        return this.titular;
    }

    public int getAgencia(){
        return this.agencia;
    }

    public int getNumero(){
        return this.numero;
    }

    public void Depositar(double valor){
        if(valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        }
        else{
            System.out.println("Não foi possível realizar o depósito ");
        }
    }

    public void Sacar(double valor){
        if (valor > 0){
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        }
        else{
            System.out.println("Não foi possível realizar o saque!");
        }
    }

    public double Extrato(){
        return this.saldo;
    }













}
