/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix.pkg3;
import java.util.Scanner;
/**
 *
 * @author mateu
 */
public class Matrix3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Ler nome,nota1 e nota2 de 5 alunos
        // A seguir, mostrar o nome do aluno e sua situação (aprovado/reprovado)
        //Considerar que a media para aprovação é 5.
        
           Scanner x = new Scanner (System.in); 
           float n1[] = new float [10];
           float n2[] = new float [10];
           String nome[] = new String [80];
           int i;
           float m;
           
           for(i=0;i<5;i++)
           {
               System.out.println("Digite o nome do aluno");
           nome[i] = x.next();
       
           System.out.println("Digite a primeira nota");
           n1[i] = x.nextFloat();
           System.out.println("Digite a segunda nota");
           n2[i]=x.nextFloat();
           //x.nextLine(); para limpar o buffer...
           
           
           m=n1[i]+n2[i]/2;
          if(m>5)
          {
              System.out.println("aprovado");
          }
          else
              System.out.println("reprovado");
    
}
}   
}