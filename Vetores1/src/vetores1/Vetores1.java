/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetores1;

/**
 *
 * @author mateu
 */
public class Vetores1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here]
        //mostrar a soma dos seus algoritmos. 
        // Ex:. {1352} => soma={1+3+5+2}=36
        
        //Criar um programa que armazene em cada posição de 
        //um vetor de 8 posições o valor correspondente
        // ao indice acrescido de 3 unidades para as 4 primeiras posições 
        // E o valor do indice subtraídos de 1 para as posições seguintes
        //Ao final, mostrar a soma dos valores armazenados no vetor.
        
        int n=8;
        int v[]= new int [8];
        int i,s=0;
       
        for (i=0;i<=4;i++)
        v[i]=i+3;// acresce mais 3 unidades nas quatro primeira...
        
        for(i=4;i<8;i++)
        v[i]=i-1;// subtrai 1 unidade nas proximas...
        
        for(i=0;i<8;i++)
        s=s+v[i];// soma a poha toda...
        
        System.out.println("Soma"+s);
        
        for (i=0;i<8;i++)
            System.out.println(v[i]);// mostra  resultado
        
    }
    
}
