package pilha6;
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
public class Pilha6 {

    public static void main(String[] args) {
        
//Crie uma função que, utilizando as funções empilha e desempilha, teste se duas pilhas
//são iguais ou não. A função deve retornar verdadeiro se p1 e p2 forem iguais e falso
//caso contrário. Ao final da função, as duas pilhas recebidas como parâmetro devem
//estar no mesmo estado em que elas começaram a função.

    Pilha p1 = new Pilha();
    Pilha p2 = new Pilha();

    Scanner x = new Scanner(System.in);
    int i,j;
    int v1 = 0;
    int v2 = 0;

    
    System.out.println("digite 5 numeros da primeira pilha");
    for (i=0;i<5;i++)
    {
         v1 = x.nextInt();
    }

   p1.empilha(v1);
   p1.mostrar();
    
    System.out.println("digite 5 numeros da segunda pilha");
    for (j=0;j<5;j++)
    {
         v2 = x.nextInt();
    }
    p2.empilha(v2);
    p2.mostrar();
            
    
    if (v2!=v1)
        System.out.print("falso");
    else {
        System.out.print("Verdadeiro");
        }
    p1.mostrar();
    p2.mostrar();
}
}

