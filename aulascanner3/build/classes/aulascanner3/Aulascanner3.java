/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulascanner3;
import java.util.Scanner;

/**
 *
 * @author mateu
 */
public class Aulascanner3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    // ler 10 numeros reais e mostrar o maior
    // ler 10 numeros e mostrar a media  entre eles
    float m,n;
            int i;
    Scanner x = new Scanner (System.in);
    System.out.println("Digite o primeiro numero");
    m = x.nextFloat();
    for(i=1;i<=9;i++)
    {
        System.out.println("Digite mais um Numero");
        n=x.nextFloat();
        if (n>m)
            m=n;
    }
    System.out.println("maior = "+m);
    
    }
    
    
    }

