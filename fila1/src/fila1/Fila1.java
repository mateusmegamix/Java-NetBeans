
package fila1;
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
public class Fila1 {

 
    public static void main(String[] args) {
 //1. Faça um programa que crie uma Fila F e na sequencia exiba o seguinte menu:
    //1. Inserir
    //2. Retirar
    //3. Exibir Elemento da Frente
    //4. Exibir a Fila
    //5. Esvaziar a Fila
    //6. Encerrar o Programa
    
    Fila f1 = new Fila();
    Scanner x = new Scanner (System.in);
   
    System.out.println("menu");
    
    int op=0,n;
     Object o;
        while (op!=6)
        {
            System.out.println(" 1-inserir \n "
            + "2-retirar \n "
            + "3-exibir elemento de frente \n "
            + "4-exibir a fila \n "
            + "5-esvaziar a fila \n "
            + "6- encerrar o programa\n");
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
                    System.out.println("exibir o elemento da frente");
                    o = f1.frente();
                case 4:
                    System.out.println("exibir a fila");
                    f1.mostrar();
                    break;
                case 5:
                    System.out.println("esvaziar a fila");
                    while (f1.tamanho()!=0)
                    {
                        f1.retira();
                    }
                    break;
                case 6:
                    System.out.println("Programa encerrado");
                    break;
                    
                    default:
                    System.out.println("Invalido");
                    break;
            }
        }
    
    
    }
    
}