/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posições;

/**
 *
 * @author mateu
 */
public class Posições {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   long i;
   long x;
   
   for(i=1;i<=10;i++)
   {
       x=i*i;
       if (x%2==0)
           System.out.println("-1/"+x);
       else
           System.out.println("+1/"+x);
           
   }
    }
}