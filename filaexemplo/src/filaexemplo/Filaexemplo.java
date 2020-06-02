
package filaexemplo;

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

public class Filaexemplo {

  
    public static void main(String[] args) {
        Fila f1 = new Fila();
 Object o;
 f1.insere(10);
 f1.insere("Mateus Pereira");
 f1.insere(2.50);
 f1.mostrar();
 o = f1.retira();
 System.out.println("Foi retirado o elemento "+o);
 f1.mostrar();
 f1.insere(1500);
 f1.mostrar();
    }
    
}