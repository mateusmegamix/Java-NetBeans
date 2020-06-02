package pilha5;
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
public class Java5 {

    public static void main(String[] args) {

//Escreva uma função que, utilizando as funções empilha e desempilha, verifica se um
//dado elemento E recebido como parâmetro está presente em uma pilha. Caso o
//elemento esteja presente indique quantas vezes esse elemento aparece na pilha. Caso
//contrário, exiba uma mensagem informando que o elemento não está na pilha.

        Pilha p = new Pilha();
        Scanner x = new Scanner(System.in);
        int v = 0;
        int quantidade=0;
        System.out.println("Digite um valor");
        for (int j=0; j<10; j++)
        {
            v = x.nextInt();
            p.empilha(v);
        }
        System.out.println("qual valor que vc quer? \n");
         int m=x.nextInt();
         
         if (m==v)
         {
             quantidade++;
             p.mostrar();
         }
         else
             System.out.println("valor não existe");
         

    }
    
}
