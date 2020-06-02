/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulascanner4;
import java.util.Scanner;
/**
 *
 * @author mateu
 */
public class Aulascanner4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            // ler 10 numeros e mostrar a media  entre eles
    float s,n;
    int i;
            
    Scanner x = new Scanner (System.in);
    
    s=0;
     for(i=1;i<10;i++)
     
    {
        System.out.println("Digite um Numero");
        n=x.nextFloat();
        s=s+n;
    }
    s=s/10;
    System.out.println("media = "+s);
    
    }
}

    

