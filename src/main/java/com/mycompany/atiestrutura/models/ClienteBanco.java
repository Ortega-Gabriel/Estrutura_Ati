package com.mycompany.atiestrutura.models;

public class ClienteBanco {
    private static final int IdadePrioritaria = 65;
    
    private String nomeCliente;
    private int anoNasc;
    
    public ClienteBanco(String nome, int anoNasc){
        this.nomeCliente = nomeCliente;
        this.anoNasc = anoNasc;
    }
    
    public boolean isPriori(){
        int idade = calcularIdade();
        return idade >= IdadePrioritaria;
    }
    
    private int calcularIdade(){
        int anoAtual = java.time.Year.now().getValue();
        return anoAtual - anoNasc;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getAnoNasc() {
        return anoNasc;
    }

    public void setAnoNasc(int anoNasc) {
        this.anoNasc = anoNasc;
    }
    

    @Override
    public String toString() {
        return "Nome Cliente: "+ nomeCliente;
    }
    
    
}
