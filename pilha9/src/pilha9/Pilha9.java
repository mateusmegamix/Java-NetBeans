
package pilha9;
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

public Object desempilha(){
    Object e = null;
if (! estaVazia() ){
    e = p[fim];
    fim --;
    qtdeElementos --; }
return(e);
}
    


public Object topo()
{
    return (p[fim]);
}
}

public class Pilha9 {


    public static void main(String[] args) {
   // Suponha que um dado problema requer o uso de duas pilhas, onde cada pilha suporta
  //no máximo 50 elementos e em nenhum momento as duas pilhas terão juntas mais do
  //que 80 elementos. Assim, é possível implementar as duas pilhas em um único vetor
  //usando apenas 80 posições ao invés de 100. Implemente a estrutura de dados e as de
  //empilhar e desempilhar para estas duas pilhas.
  
    Pilha p1 = new Pilha();
    Pilha p2 = new Pilha();
    Pilha s = new Pilha ();
    
    Scanner x = new Scanner (System.in);
    int i = 0, j = 0;
    int v1 = 0;
    int v2 = 0;
    Object e;
    
    System.out.println("primeira pilha");
    for (i = 1;i <= 5; i ++)
    {
        v1 = x.nextInt();
        p1.empilha (v1);
        p1.mostrar ();
    }
    
    System.out.println("segunda pilha");
    for (i = 1; i <= 5; i ++)
    {
        v2 = x.nextInt();
        p2.empilha (v2);
        p2.mostrar();
    }
  
    s.empilha(v1+v2);

     System.out.println("duas pilhas");
      s.mostrar();
      
     if(s > 8)
     {
         
     }
    } 
}
