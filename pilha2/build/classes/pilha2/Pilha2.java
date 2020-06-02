
package pilha2;
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
public Object desempilha()
{
    Object e = null;
    if (! estaVazia() ){
e = p[fim];
fim --;
qtdeElementos --; }
return(e);
}
}

public class Pilha2 {

    public static void main(String[] args) {
        
//Desenvolva um programa que solicite ao usuário uma sequência de caracteres e
//imprima o texto na ordem inversa usando uma pilha.

    Pilha p1 = new Pilha();
    Pilha p2 = new Pilha();
int e,i;
for(i=0; i<10; i++)
p1.empilha(i);
System.out.println("Pilha 1");
p1.mostrar();
for(i=0; i<10; i++) {
e = (int)p1.desempilha();
p2.empilha(e);}
System.out.println("Pilha 2");
p2.mostrar();
    }
    
}
