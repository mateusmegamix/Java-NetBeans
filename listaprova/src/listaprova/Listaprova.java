package listaprova;
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
Elemento el = new Elemento(o,null);
if(!estaVazia()){
el.posProx(primeiro);
primeiro=el;
}
else{
primeiro=el;
ultimo = primeiro;
}
tam++;
}
public void insereFim(Object o){
Elemento el = new Elemento(o,null);
Elemento anterior = ultimo;
ultimo = el;
if(estaVazia())
primeiro=el;
else
anterior.posProx(el);
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
Elemento el = new Elemento(o,null);
Elemento anterior = primeiro;
for (int i = 1; i < pos-1; i++) {
anterior = anterior.retProx();
}
el.posProx(anterior.retProx());
anterior.posProx(el);
tam++;
}
}
}
public Object retiraInicio(){
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
public Object retiraFim(){
Object o = null;
if (! estaVazia() ){
o = ultimo.retDado();
Elemento anterior = primeiro;
while (anterior.retProx()!=ultimo && anterior!=ultimo) {
anterior = anterior.retProx();
}
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
anterior.posProx(el.retProx());
tam--; } }
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
class aluno {
    String Nome;
    int matricula;
    float media;
    
    public aluno (String n, int m, float md){
        Nome = n;
        matricula = m;
        media = md;
    }
    String RetNome()
    {
        return Nome;
    }
    int RetNumero()
    {
        return matricula;
    }
    float RetMd()
    {
        return media;
    }
}


public class Listaprova {
    public static void Excluir(Lista L1, int num )
    {
        int tamanho= L1.tamanho();
        Object o;
        aluno a;
        for(int i=1;i<=tamanho;i++)
        {
            a =(aluno)L1.elementoPosicao(i);
            if (a.RetNumero()==num)
            {
                L1.retiraPosicao(i);
            }
        }
    
    }
   
            public void Inserir(aluno a, Lista L1)
            {
                int tamanho = L1.tamanho();
                aluno o;
                if(L1.estaVazia())
                {
                    L1.insereInicio(a);
                }
                else
                {
                    for(int i=1;i<=tamanho;i++)
                    {
                        o=(aluno)L1.elementoPosicao(i);
                        if(o.RetNumero()>a.RetNumero())
                        {
                            L1.inserePosicao(i,a);
                        }
                    }
                }
            }

    public static void main(String[]args){
    
        Scanner x = new Scanner(System.in);
        Lista L1 = new Lista();
        Object o;
        int matricula, op=0,excluir;
        float media;
        String nome;
        
        while(op!=4)
        {
            System.out.println("1-IncluirAluno: \n "
                    + "2-Excluir Aluno: \n"
                    + "3-Listar Alunos \n"
                    + "4-Finalizar \n");
            op = x.nextInt();
            switch(op)
            {
                case 1:{
                    System.out.println("Digite a matricula do aluno: \n");
                    matricula = x.nextInt();
                    System.out.println("Digite o nome do Aluno: \n");
                    nome = x.next();
                    System.out.println("Digite a média do Aluno: \n");
                    media = x.nextFloat();
                    aluno a = new aluno (nome,matricula,media);
                    L1.insereFim(a);
                    System.out.println("Aluno Inserido Com Sucesso!!!");
                break;
                }
                case 2:{
                    
                   
                    System.out.println("Digite o numero da matricula: \n");
                    excluir=x.nextInt();
                    Excluir(L1,excluir);
                    System.out.println("Aluno Excluido Com Sucesso!!! \n");
                    
               break;
                }
                case 3:{
                    System.out.println("Lista de todos os alunos: \n");                    
                    aluno a;
                    for (int i=1;i<=L1.tamanho();i++)
                    {
                        a = (aluno) L1.elementoPosicao(i);
                        System.out.println("Nome: "+a.RetNome());
                        System.out.println("Matricula: "+a.RetNumero());
                        System.out.println("Media: "+a.RetMd());
                    }
                break;
                }
                case 4:{
                    System.out.println("Finalizado");
                break;
                }
                
            }
        
        }
    }
}
