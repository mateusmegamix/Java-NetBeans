
package pilha8;
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
public Object desempilhaN(int N){
    Object e = null;
    for(int a=0; a<N; a++){
        if (! estaVazia()){
            fim--;
            qtdeElementos--;
            System.out.println(p[fim+1]);
        }
    }
    return (e);
}
public Object topo()
{
    return (p[fim]);
}
}
public class Pilha8 {

    public static void main(String[] args) {
    //Escreva um programa que remove um dado elemento E fornecido pelo usuário da pilha.
    //Ao final da execução da função, a pilha deve ser igual a original, exceto pela ausencia
    //do elemento removido
        Pilha p = new Pilha();
        Pilha copia = new Pilha();
        int m;
        int i=0;
        Scanner x = new Scanner (System.in);
        System.out.println("digite os 5 numeros da pilha");
        for (i = 0; i < 5; i++)
        {
            m = x.nextInt();
            p.empilha(m-1);
        }
    
        p.mostrar();
        }
    }
    

