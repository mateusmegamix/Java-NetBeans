
package pilha3;

import java.util.Scanner;
import javax.swing.*;

class Pilha{
int inicio;
int fim;
int tamanho;
int qtdeElementos;
Object p[];
public Pilha(){
inicio = fim = -1;
tamanho = 100;
p = new Object[tamanho];
qtdeElementos = 0;
}
public boolean estaVazia(){
if (qtdeElementos == 0){
return true; }
return false;
}
public boolean estaCheia(){
if (qtdeElementos == tamanho){
return true; }
return false;
}
public int tamanho(){
return(qtdeElementos);
}
public void empilha(Object e){
    if (! estaCheia()){
        if (inicio == -1){
            inicio = 0; }
    fim++;
    p[fim] = e;
    qtdeElementos++; }
}
public void mostrar(){
String elementos = "";
for (int i = fim; i>=0; i--) 
{
    elementos += p[i]+" - ";
    System.out.println(elementos);
}
}
public Object desempilhaN(int n){
    Object e = null;
    for(int a=1; a<n; a++){
        if (! estaVazia()){
            fim--;
            qtdeElementos--;
            System.out.println(p[fim+1]);
        }
    }
    return (e);
}


}

public class pilha3 {

//Desenvolva uma função chamada desempilhaN() para desempilhar e exibir N
//elementos a partir do topo de uma pilha. O valor de N é dado pelo usuário.
    
    public static void main(String[] args) {
        Pilha p = new Pilha();
        Scanner x = new Scanner (System.in);
        
        for (int j=1; j<100; j++){
        p.empilha(j);
            
        }        
        System.out.println("digite um valor");
        int n = x.nextInt();
        p.mostrar();
        p.desempilhaN(n);
        p.mostrar();
               
}
}