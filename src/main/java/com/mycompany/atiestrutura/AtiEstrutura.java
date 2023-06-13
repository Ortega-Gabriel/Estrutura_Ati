package com.mycompany.atiestrutura;

import com.mycompany.atiestrutura.models.Cliente;
import javax.swing.JOptionPane;

public class AtiEstrutura {
    int result = 0;
    private static Cliente[] clientes;
    private static int qtdCliente;
    
        
    
    public static void main(String[] args) {
        qtdCliente = 0;
        
        /*Atividade 1 - Recursividade
        JOptionPane.showMessageDialog(null, "Atividade 1 - Recursividade!");
        int somaFinal = RecurAti1(0);
        JOptionPane.showMessageDialog(null, "A Soma de 1 a 50 é: "+somaFinal);*/
        
        /*Atividade 2 - Recursividade
        JOptionPane.showMessageDialog(null, "Atividade 2 - Recursividade!");
        int num = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Informe um Número Inteiro para ser Fatorado"));
        int fat = RecurAti2(num);
        JOptionPane.showMessageDialog(null, 
                "Número Fatorado: "+num+"\n"
                + "Fatorial: "+fat);*/
        
        /*Atividade 3 - Recursividade
        JOptionPane.showMessageDialog(null, "Atividade 3 - Recursividade!");
        String msg = "";
        int num2 = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Informe um Número Inteiro para"
                + " a Sequência de Fibonacci: "));
        
        JOptionPane.showMessageDialog(null, "Fibonacci até o número: " +num2);
        for(int i = 0; i <= num2 -2; i++){
            msg += RecurAti3(i) + "\n";
        }
        JOptionPane.showMessageDialog(null, msg);*/
        
        /*Atividade 1 - Pesquisa Linear e Binária!
        JOptionPane.showMessageDialog(null, "Atividade 1 - Pesquisa Linear "
                + "e Binária!");
        PesqAti1();*/
        
        //Atividade 2 - Pesquisa Linear e Binária!
        JOptionPane.showMessageDialog(null, "Atividade 2 - Pesquisa Linear "
                + "e Binária");
        PesqAti2(clientes, qtdCliente);
        
    }
    
    //Métodos das Atividades de Recursividade
    public static int RecurAti1(int result){
        if(result > 50){
            return 0;
        }
        
        return result + RecurAti1(result + 1);
        
    }
    public static int RecurAti2(int num){
        if(num == 0 || num == 1){
            return 1;
        }
        
        return num * RecurAti2(num - 1);
    }
    public static int RecurAti3(int num2){
        if (num2 < 2) {
            return num2;
        } else {
            return RecurAti3(num2 - 1) + RecurAti3(num2 - 2);
        }
    }
    
    //Métodos das Atividades de Pesquisa Linear e Binária
    public static void PesqAti1(){
        int qtd = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Informe a Quantidade de Números que Serão Informados: "));
        
        int[] vetNum = new int[qtd];
        
        for(int i = 0; i < qtd; i++){
            vetNum[i] = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Informe o "+(i+1)+"º Número: "));
        }
        int resp = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Escolha o Tipo de Pesquisa que Deseja Realizar: \n"
                        + "1 - Pesquisa Linear \n"
                        + "2 - Pesquisa Binária"));
        int numPesq = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Informe o Número que Deseja Pesquisar: "));
        
        switch(resp){
            case 1:
                ordBolha(vetNum);
                int posLin = pesqLinear(numPesq, vetNum);
                if(posLin == -1){
                    JOptionPane.showMessageDialog(null,
                            "Número Não Encontrado!");
                }else{
                    JOptionPane.showMessageDialog(null,
                            "Número foi Encontrado na "+(posLin+1)+"º Posição");
                }
                break;
            case 2:
                ordBolha(vetNum);
                int posBin = pesqBinaria(numPesq, vetNum);
                if(posBin == -1){
                    JOptionPane.showMessageDialog(null, 
                            "Número Não Encontrado!");
                }else{
                    JOptionPane.showMessageDialog(null,
                            "Número fo Encotnrado na "+(posBin+1)+"º Posição");
                }
        }
    }
    public static void PesqAti2(Cliente[] clientes, int qtdCliente){
        clientes = new Cliente[1000];
        int selOper = 1;
        do{
            selOper = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Escolha a Opção que Deseja Realizar: \n"
                        + "1 - Cadastrar Cliente \n"
                        + "2 - Ordenar Cliente Pelo Código \n"
                        + "3 - Exibir Clientes Cadastrados \n"
                        + "0 - Cancelar Operação"));
        
            switch(selOper){
                case 1:
                    cadastrarCliente(clientes);
                    break;
                case 2:
                    ordBolList(clientes);
                    break;
                case 3:
                    exibirClientes(clientes);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Operação Cancelada");
                    break;
                default:
            }
        }while(selOper != 0);
    }
    
    //Métodos de Pesquisa, Ordenação e Métodos Complementares
    public static int pesqLinear(int numPesq, int[] vetNum) {
        
        for (int i = 0; i < vetNum.length; i++) {
            if (numPesq == vetNum[i]) {
                return i;  
            }
        }
        return -1;
    }
    public static int pesqBinaria(int numPesq, int[] vetNum) {
        
        int esq, meio, dir;
        esq = 0;
        dir = vetNum.length - 1;
        
        while (esq <= dir) {
            meio = (esq + dir) / 2;
            
            if (numPesq == vetNum[meio]) {
                return meio;
            }else if(numPesq >= vetNum[meio]) {
                esq = meio + 1;
            }else{
                dir = meio - 1;
            }
        }
        return -1;
    }
    public static int pesqBinariaList(int codigoPesquisa) {
        int inicio = 0;
        int fim = qtdCliente - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (clientes[meio].getId() == codigoPesquisa) {
                return meio;
            } else if (clientes[meio].getId() < codigoPesquisa) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }
    public static void ordBolha(int[] vetNum) {
        boolean status = true;
        while(status){
            status = false;
            for(int i = 0; i < vetNum.length -1; i++){
                if(vetNum[i] > vetNum[i+1]){
                    int aux = vetNum[i];
                    vetNum[i] = vetNum[i+1];
                    vetNum[i+1] = aux;
                    status = true;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Lista de Clientes Ordenados");
    }
    public static void ordBolList(Cliente[] clientes) {
        boolean status;
        do {
            status = false;
            for (int i = 0; i < qtdCliente - 1; i++) {
                if (clientes[i].getId() > clientes[i + 1].getId()) {
                    Cliente temp = clientes[i];
                    clientes[i] = clientes[i + 1];
                    clientes[i + 1] = temp;
                    status = true;
                }
            }
        } while (status);
        JOptionPane.showMessageDialog(null, "Lista de Clientes Ordenados");
    }
    public static void cadastrarCliente(Cliente[] clientes){
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Informe o Código do Cliente: "));
        String nmCliente = JOptionPane.showInputDialog(null,
                "Informe o Nome do Cliente: ");
        String dtCliente = JOptionPane.showInputDialog(null,
                "Informe a Data de Nascimento do Cliente: ");
        String cpfCliente = JOptionPane.showInputDialog(null,
                "Informe o CPF do Cliente: ");
        
        Cliente clienteNovo = new Cliente(idCliente, nmCliente, dtCliente,
            cpfCliente);
        clientes[qtdCliente] = clienteNovo;
        qtdCliente++;
        
        JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!");
    }
    public static void exibirClientes(Cliente[] clientes){
        String msg = "Dados Clientes: \n";
        System.out.println(qtdCliente);
        for(int i = 0; i < qtdCliente; i++){
            
            msg += "Id:"+clientes[i].getId() +"\n";
            msg += "Nome: "+clientes[i].getNome() +"\n";
            msg += "Data Nascimento: "+clientes[i].getDtNasc() +"\n";
            msg += "CPF: "+clientes[i].getCpf() +"\n";
        }
        JOptionPane.showMessageDialog(null, msg);
    }
}
