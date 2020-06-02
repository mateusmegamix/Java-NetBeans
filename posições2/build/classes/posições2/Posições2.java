/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posições2;

/**
 *
 * @author mateu
 */
public class Posições2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("1, ");
        long x=1;
        for( long i=2;i<=10;i++)
        {
            x=x*(-1);
            System.out.println(x+"/"+i*i+",");
        }
    }
    
}
