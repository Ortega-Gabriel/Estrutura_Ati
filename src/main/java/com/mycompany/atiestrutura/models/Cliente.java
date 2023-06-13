package com.mycompany.atiestrutura.models;


public class Cliente {
    
    private int id;
    private String nome;
    private String dtNasc;
    private String cpf;

    public Cliente() {
    }

    public Cliente(int id, String nome, String dtNasc, String cpf) {
        this.id = id;
        this.nome = nome;
        this.dtNasc = dtNasc;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(String dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n"
                + "Nome: " + nome + "\n"
                + "Data Nascimento: " + dtNasc + "\n"
                + "CPF: " + cpf + "\n";
    }
    
    
}
