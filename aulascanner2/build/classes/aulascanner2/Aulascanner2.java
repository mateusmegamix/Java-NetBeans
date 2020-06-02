/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulascanner2;
import java.util.Scanner;
/**
 *
 * @author mateu
 */
public class Aulascanner2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ler dois numeros inteiros e mostrar o maior.
        // e mostrar a mensagem "iguais" caso eles sejam iguais.
        int n1,n2;

        Scanner x = new Scanner (System.in);
    
        System.out.println("digite dois numeros");
        
        n1 = x.nextInt();
        n2 = x.nextInt();
        
        if (n1>n2)
       
           System.out.println("o maior " +n1);
       else
            if (n1==n2)
      
        System.out.println(+n2+" = " +n1);
        
        else
        
        System.out.println("o menor " +n2);
        
        
    
}
}
