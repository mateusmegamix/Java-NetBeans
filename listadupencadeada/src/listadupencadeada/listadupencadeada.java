package listadupencadeada;

class Elemento {
Object dado;
Elemento prox;
Elemento ant;

public Elemento() {
dado = null;
prox = null;
ant = null;
}
public Elemento(Object o, Elemento ep, Elemento ea) {
    
dado = o;
prox = ep;
ant = ea;

}

Object retDado() {
return dado;
}

Elemento retProx() {
return prox;
}

Elemento retAnt() {

return ant;
}
void posDado(Object novoDado) {
dado = novoDado;
}

void posProx(Elemento novoElemento) {
prox = novoElemento;
}

void posAnt(Elemento novoElemento) {
ant = novoElemento;
}

}
class Lista{
Elemento primeiro,ultimo;
int tam;

public Lista(){
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
public void insereInicio(Object o){
    
Elemento el = new Elemento(o,null,null);

if(!estaVazia()){
el.posProx(primeiro);
primeiro.posAnt(el);
primeiro=el;
}

else{

primeiro=el;
ultimo = primeiro;
}
tam++;
}
public void insereFim(Object o){


Elemento el = new Elemento(o,null,null);
Elemento anterior = ultimo;
ultimo = el;

if(estaVazia())

primeiro=el;

else{
    
anterior.posProx(el);
el.posAnt(anterior);
}
tam++;
}
public void inserePosicao(int pos, Object o){


if(pos<=0 || pos>tam)
System.out.println("Posição Inválida!");

else{

if(pos==1)

insereInicio(o);

else


if(pos==tam)

insereFim(o);

else{

Elemento el = new Elemento(o,null,null);

Elemento anterior = primeiro;

for (int i = 1; i < pos-1; i++) {

anterior = anterior.retProx();
}
el.posProx(anterior.retProx());
el.posAnt(anterior);
anterior.posProx(el);
anterior=el.retProx();
anterior.posAnt(el);
tam++;

}
}
}

public int tamanho(){
   
return(tam);

}
public Object retiraInicio(){

Object o = null;

if (! estaVazia() ){

o = primeiro.retDado();

primeiro = primeiro.retProx();
primeiro.posAnt(null);
tam--;

if(tam==0)

ultimo=null;
}
return(o);
}
public Object retiraFim(){

Object o = null;

if (! estaVazia() ){
    
o = ultimo.retDado();

Elemento anterior = ultimo.retAnt();

tam --;

if(tam==0){

ultimo=null;
primeiro=null;

}

else{

ultimo = anterior;
ultimo.posProx(null);
}
}

return(o);

}
public Object retiraPosicao(int pos){
    
Object o = null;

if(pos<=0 || pos>tam)

System.out.println("Posição Inválida!");

else{

if(pos==1)

o=retiraInicio();

else

if(pos==tam)

o=retiraFim();

else{

Elemento anterior = primeiro;

for (int i = 1; i < pos-1; i++) {

anterior = anterior.retProx();

}

Elemento el=anterior.retProx();
o = el.retDado();

el=el.retProx();

anterior.posProx(el);

el.posAnt(anterior);

tam--;
}
}
return(o);
}
public Object elementoPosicao(int pos){

Object o = null;

if(pos<=0 || pos>tam)

System.out.println("Posição Inválida!");

else{

Elemento atual = primeiro;

for (int i = 1; i < pos; i++) {

atual = atual.retProx();
}
o = atual.retDado();
}

return(o);

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
public class listadupencadeada {

public static void main(String[] args) {

Lista l1 = new Lista();
Object o;

for(int i=1;i<=10;i++)
l1.insereInicio(10*i);
l1.mostrar();
l1.inserePosicao(4,1500);
l1.mostrar();
l1.insereFim(2000);
l1.mostrar();

o = l1.elementoPosicao(5);

System.out.println("O elemento da posicao 5 é "+o);

o = l1.retiraInicio();

System.out.println("Foi retirado o elemento "+o);

l1.mostrar();
o = l1.retiraFim();

System.out.println("Foi retirado o elemento "+o);

l1.mostrar();

o = l1.retiraPosicao(7);

System.out.println("Foi retirado o elemento "+o);

l1.mostrar();

o = l1.elementoPosicao(5);

System.out.println("O elemento da posicao 5 é "+o);

l1.mostrar();

}
}