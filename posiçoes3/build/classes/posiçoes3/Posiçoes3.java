/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posiçoes3;

/**
 *
 * @author mateu
 */
public class Posiçoes3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      int i,a=1,b=1,c;
      System.out.print("1 1");
      for (i=3;i<=20;i++)
      {
          c=a+b;
          System.out.print(" "+c);
          a=b;
          b=c;
      }
      
    }
    
}
