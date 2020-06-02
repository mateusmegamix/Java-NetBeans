/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix.pkg2;
import java.util.Scanner;
/**
 *
 * @author mateu
 */
public class Matrix2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Criar um projeto que leia uma sequencia de numeros reais e armazene-os
        //em uma matrix 3x3. 
        //A seguir mostre os elementos cujo valor é superior a media dos numeros 
        //armazenados
        Scanner x = new Scanner (System.in);
        int i,j;
        float m;
        int s=0;
        int a[][] = new int [3][3];
       
        for (i=0;i<3;i++)
            for(j=0;j<3;j++)
            { System.out.println("digite os 9 numeros");
              a[i][j]= x.nextInt();
            }
        for (i=0;i<3;i++)
        for(j=0;j<3;j++)
          
        s=s+a[i][j];
        m=s/9;
        
        for (i=0;i<3;i++)
        for(j=0;j<3;j++)
        
        if (a[i][j] > m)
        
         System.out.println("maiores q a media"+a[i][j]);
        
    }
}

    
