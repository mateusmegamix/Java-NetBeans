
package fila3;
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

public class fila3 {
    
    public static void main(String[] args) {
    //Dada uma Fila de inteiros, escreva uma função que exclua todos os números negativos
    //sem alterar a posição dos outros elementos da fila.
       
    Scanner x = new Scanner (System.in);
        Fila f1 = new Fila();
        Fila f2 = new Fila();
        
        int o,p=0;
        
        System.out.println("Digite 5 numeros para fila");
        for(p=0;p<=5;p++){
        int n = x.nextInt();
            f1.insere(n); 
        }

        for(p=0;p<=5;p++)
        {
            o = (int)f1.retira();
        
        if(o>=0)
        {
            f2.insere(o);
        }
        } 
            f2.mostrar();
    }
 }