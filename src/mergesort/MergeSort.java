/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Erberto Sousa
 */
public class MergeSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int []v = new int[40]; //cria o vetor com 100 posições
        for(int i = 0; i < v.length; i++) {
            int rnd = (int) (1 + Math.random() * 100); // gera um valor randomico de 0.0 ate menores q 1.0, multiplica por 100 e soma 1. Convertendo o resultado para int.
            v[i] = rnd; // atribui o valor a cada indice do vetor
        }
            System.out.println(Arrays.toString(v));
        
       
        int []w = new int[v.length]; // Vetor auxilar com o mesmo tamanho do vetor v
        
        
       //Chamada do Merge
       
       mergeSort(v,w,0,v.length-1);
       System.out.println(Arrays.toString(v));
    
    
}

    private static void mergeSort(int[] v, int[] w, int in, int fim) {
        
        if(in<fim){ //Condição de Parada da Recursividade
            
            int meio = (in+fim)/2; // I passo: Dividir o Vetor 
            mergeSort(v,w,in,meio); //Ordenar a primeira metade
            mergeSort(v,w,meio+1, fim); //Ordenar a Segunda metade
            concatenar(v,w,in,meio,fim);
            
        }
        
    }

    private static void concatenar(int[] v, int[] w, int in, int meio, int fim) {
        
        for (int k = in; k <=fim; k++){
            w[k]=v[k];
        }
        int i = in;
        int j = meio + 1;
        
        for (int k = in; k <=fim; k++){
            if(i>meio) v[k] = w[j++];
            else if (j>fim) v[k] = w[i++];
            else if (w[i]>w[j]) v[k] = w[i++];
            else v[k] = w[j++];
        }
        }
    }
    

