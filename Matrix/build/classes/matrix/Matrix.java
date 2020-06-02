/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;
import java.util.Scanner;
/**
 *
 * @author mateu
 */
public class Matrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Criar um projeto que leia uma sequencia de numeros reais e armazene-os
        //em uma matrix 2x2. 
        //A seguir calcule e mostre a soma dos valores armazenados.
        Scanner x = new Scanner (System.in);
        int i,j;
        int s=0;
        int a[][] = new int [2][2];
       
        for (i=0;i<2;i++)
            for(j=0;j<2;j++)
            { System.out.println("digite os 4 numeros");
              a[i][j]= x.nextInt();
            }
        { for (i=0;i<2;i++)
            for(j=0;j<2;j++)
           s=s+a[i][j];
        System.out.println("soma"+s);
           
        }
           
    }
    
}
