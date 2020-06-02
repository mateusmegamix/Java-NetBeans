/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetores4;
import java.util.Scanner;
/**
 *
 * @author mateu
 */
public class Vetores4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Ler um numero inteiro e mostrar o seu correspondente em binário
        // O numero binário deve ter no maximo 10 bits
         Scanner x = new Scanner (System.in);
         int v[]=new int[10];
         int i, num,q;
         for (i=0;i<=1;i++)
             v[1]=0;
         do
         {
             System.out.println("Digite um numero entre 0 e 1023");
             num = x.nextInt();
             
         }
         while (num>=1023);
                 q=num;
                 i=0;
                 
         while (q>=2)
         {
             v[i] = q%2;
             q=q/2;
             i++;
         }
            v[i]=q;
            System.out.println("O numero "+num+" em binario é ");
            for(i=9;i>0;i--)
                System.out.println(v[i]);
    }
    
}
