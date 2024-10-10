package com.futurebank.client;

public class AccountHolder {
    // Atributos

    private String nome;
    private String cpf;
    private String profissao;

    //Construtor
    public AccountHolder(String nome, String cpf, String profissao){
        this.nome = nome;
        this.cpf = cpf;
        this.profissao = profissao;
    }

    //Metodos

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setProfissao(String profissao){
        this.profissao = profissao;
    }

    public String getProfissao(){
        return this.profissao;
    }




}
