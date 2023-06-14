package com.mycompany.atiestrutura.models;

public class FilaCliente {
    private ClienteBanco[] clientes;
    private int tam;
    private int inicio;
    private int fim;
    private int qtdItens;
    
    public FilaCliente(int tam){
        tam = 100;
        clientes = new ClienteBanco[tam];
        inicio = 0;
        fim = -1;
        qtdItens = 0;
    }
    
    public void enqueue(ClienteBanco cliente){
        if(fim == tam - 1){
            fim = -1;
        }
        
        clientes[++fim] = cliente;
        qtdItens++;
    }
   
    
    
    public ClienteBanco dequeue(){
        ClienteBanco aux = clientes[inicio++];
        if(inicio == tam){
            inicio = 0;
        }
        
        qtdItens--;
        return aux;
    }
    
    public boolean isEmpty(){
        return qtdItens == 0;
    }
    
    public boolean isFull(){
        return qtdItens == tam;
    }

    @Override
    public String toString() {
        return "FilaCliente{" + "clientes=" + clientes + ", tam=" + tam 
                + ", inicio=" + inicio + ", fim=" + fim + ", qtdItens=" 
                + qtdItens + '}';
    }

    
    
    
}

