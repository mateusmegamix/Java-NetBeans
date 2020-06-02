/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetores3;
import java.util.Scanner;
/**
 *
 * @author mateu
 */
public class Vetores3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     //Criar um programa que leia 10 vetores inteiros
     //e armazene-os em um vetor.
     //A seguir mostre os elementos com vetores superiores a 5.
     
     int v[] = new int [10];
     Scanner x = new Scanner (System.in);
     int i;
    
     for (i=1;i<10;i++)
     {
         System.out.println("digite um numeros");
         v[i] = x.nextInt();
     }  
  
     for (i=1;i<10;i++)
      
     if (v[i]>5)
     
     System.out.println("Maiores que 5: "+v[i]);
     
    }
}
