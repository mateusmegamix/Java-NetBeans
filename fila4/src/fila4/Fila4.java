
package fila4;
import java.util.Scanner;


class Elemento {
 Object dado;
 Elemento prox;
 public Elemento() {
 dado = null;
 prox = null;
 }

 public Elemento(Object o, Elemento e) {
 dado = o;
 prox = e;
 }
Object retDado() {
 return dado;
 }

 Elemento retProx() {
 return prox;
 }
 void posDado(Object novoDado) {
 dado = novoDado;
 }

 void posProx(Elemento novoElemento) {
 prox = novoElemento;
 }
}
class Fila{
 Elemento primeiro,ultimo;
 int tam;
 public Fila(){
 primeiro = null;
 ultimo = null;
 tam = 0;
 }
 public boolean estaVazia(){
 if (primeiro == null){
 return true;
 }
 return false;
 }
 public void insere(Object o){
 Elemento el = new Elemento(o,null);
 if(estaVazia())
 primeiro=el;
 else
 ultimo.posProx(el);
 ultimo = el;
 tam++;
 }
 public Object frente(){
 Object o = null;
 if (! estaVazia() ){
 o = primeiro.retDado();
 }
 return(o);
 }
 public Object retira(){
 Object o = null;
 if (! estaVazia() ){
 o = primeiro.retDado();
 primeiro = primeiro.retProx();
 tam --;
 if(tam==0)
 ultimo=null;
 }
 return(o);
 }
 public int tamanho(){
 return(tam);
 }
public void mostrar(){
 String elementos = "";
 Elemento el = new Elemento();
 el = primeiro;
 while(el != null) {
 elementos += el.retDado() + " - ";
 el = el.retProx();
 }
 System.out.println(elementos);
 }
}

public class Fila4 {


    public static void main(String[] args) {
        //Desenvolva uma função para retirar e exibir o elemento armazenado na 
        //posição N da Fila a partir do elemento da frente. 
        //O valor de N é dado pelo usuário.
        
        Scanner x = new Scanner (System.in);
        Fila f1 = new Fila();
        Fila f2 = new Fila();
        int i,n;
        int o;
            System.out.println("digite 5 elementos");
        for (i=1;i<=5;i++)
        {   
            n=x.nextInt();
            f1.insere(n);
        }
        int z = f1.tamanho();
        
            System.out.println("digite o valor a ser retirado");
        int t = x.nextInt();
        for (int j=1;j<=z;j++)
        {
            o = (int)f1.retira(); 
        if (j!=t)
        {
            f2.insere(o);  
        }
        else
        {
            System.out.println("elemento retirado"+o);
        }
        f2.mostrar();
}
}
}
