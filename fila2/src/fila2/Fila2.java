
package fila2;

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
public class Fila2 {


    public static void main(String[] args) {
    //2. Existem partes de sistemas operacionais que cuidam da ordem em que os programas
    //devem ser executados. Por exemplo, em um sistema de computação de tempo compartilhadao
    //(“time-shared”) existe a necessidade de manter um conjunto de
    //processos em uma fila, esperando para serem executados. Escreva um programa que
    //seja capaz de ler uma série de solicitações para: 
    // Incluir novos processos na fila de processo; 
    // Retirar da fila o processo com o maior tempo de espera; 
    // Imprimir o conteúdo da lista de processo em determinado momento.
    //Assuma que cada processo é representado por um número identificador do processo
    
    Fila f1 = new Fila ();
    Scanner x = new Scanner (System.in);
    int op=0,n;
        
        while (op!=4)
        {
            System.out.println(" 1-inserir \n "
            + "2-retirar \n "
            + "3-exibir a fila \n "
            + "4- encerrar o programa\n");
            op=x.nextInt();
           
            switch (op)
            {
                case 1:
                    System.out.println("digite o membro da fila:");
                    n = x.nextInt();
                    f1.insere(n);
                    break;
                case 2:
                    System.out.println("digite o elemento a ser retirado da pilha");
                    f1.retira();
                    break;
                case 3:
                    System.out.println("exibir a fila");
                    f1.mostrar();
                    break;
                case 4:
                    System.out.println("Programa encerrado");
                    break;
                case 5:
                    while(f1.tamanho()!=0){
                    f1.retira();}
                    System.out.println("esvaziar");
                default:
                    System.out.println("Invalido");
                    break;
            }
    
        }
    }
}



