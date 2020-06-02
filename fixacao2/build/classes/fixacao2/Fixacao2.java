/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixacao2;

import java.util.Scanner;

/**
 *
 * @author mateu
 */
public class Fixacao2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner x = new Scanner (System.in);
        int i,j;
        int n[] = new int [10];
        int aux=0;
        
        for (i=0;i<9;i++)
      
        {
            System.out.println("digite 10 numeros");
            n[i] = x.nextInt();
        }
            
             for (i=0;i<9;i++)
             {
                for(j=i+1;i<9;i++)
             if (n[i]>n[j])
             {
                 aux=n[i];
                 n[i]=n[j];
                 n[j]=aux;
             }
             } 
             
        {
            System.out.println("numeros maiores que 15: ");
                     for (i=0;i<9;i++)
                     {
           if (n[i]>15)
           {
       
            System.out.println("superiores a 15"+n[i]);
        
           }
                     }
        }
             }
}
             
        
           
    
        
    
    
    
    

