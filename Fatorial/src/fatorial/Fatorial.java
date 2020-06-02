/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatorial;

/**
 *
 * @author mateu
 */
public class Fatorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//mostrar o fatorial dos numeros de 1 a 30
//fatorial de n=n!=n*(n-1)*(n-2)*...*2*1

int i;
int x;
for( i=1; i<=30; i++)
{
double fat=1;
for ( x=1; x<=i; x++)
{
fat = fat*x;
}
System.out.println("o fatorial de"+i+"="+fat);
}

    }
    
}
