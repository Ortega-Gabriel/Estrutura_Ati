package com.mycompany.atiestrutura.models;


public class Fila {
    private int[]vetorDados;
    private int inicio;
    private int fim;
    private int qtdItens;
    
    public Fila(int tam){
        vetorDados = new int[tam];
        inicio = 0;
        fim = -1;
        qtdItens = 0;
    }
    
    public void enqueue(int num){
        if(fim == vetorDados.length - 1){
            fim = -1;
        }
        
        vetorDados[++fim] = num;
        qtdItens++;
    }
   
    
    
    public int dequeue(){
        int aux = vetorDados[inicio++];
        if(inicio == vetorDados.length){
            inicio = 0;
        }
        
        qtdItens--;
        return aux;
    }
    
    public boolean isEmpty(){
        return qtdItens == 0;
    }
    
    public boolean isFull(){
        return qtdItens == vetorDados.length;
    }
}
