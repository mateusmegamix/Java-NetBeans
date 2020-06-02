/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixacao;
import java.util.Scanner;
/**
 *
 * @author mateu
 */
public class Fixacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //criar um programa que leia uma sequencia de 10 numeros
        //quem ordem inversa a leitura
        
        Scanner x = new Scanner (System.in);
        int i;
        int n[] = new int [10];
        
        
        for (i=0;i<9;i++)
        {
            System.out.println("digite 10 numeros");
            n[i] = x.nextInt();
        }
            
             for (i=9;i>0;i--)
        {
            System.out.println("ordem inversa"+n[i]);
           
        }
           
               
    }
    
}
