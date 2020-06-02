
package fila9;
import java.util.Scanner;

class Elemento
{
    Object Dado;
    Elemento Prox;
    
    public Elemento()
    {
        Dado=null;
        Prox=null;
    }
    
    public Elemento(Object o,Elemento e)
    {
        Dado=o;
        Prox=e;
    }
    
    Object RetDado()
    {
        return (Dado);
    }
    
    Elemento RetProx()
    {
        return (Prox);
    }
    
    void PosDado(Object NovoDado)
    {
        Dado=NovoDado;
    }
    
    void PosElemento(Elemento NovoElemento)
    {
        Prox=NovoElemento;
    }
}

class Fila
{
    Elemento primeiro,ultimo;
    int QtdElementos;
    
    public Fila()
    {
        primeiro=null;
        ultimo=null;
        QtdElementos=0;
    }
    
    public boolean EstaVazia()
    {
        if(primeiro==null)
        {
            return true;
        }
        return false;
    }
    
    public int Tamanho()
    {
        return (QtdElementos);
    }
    
    public Object Frente()
    {
        Object o=null;
        if(!EstaVazia())
        {
            o=primeiro.RetDado();
        }
        return (o);
    }
    
    public void Insere(Object o)
    {
        Elemento el=new Elemento(o,null);
        if(EstaVazia())
        {
            primeiro=el;
        }
        else
        {
            ultimo.PosElemento(el);
        }
        ultimo=el;
        QtdElementos++;
    }
    
    public Object Retira()
    {
        Object e=null;
        if(!EstaVazia())
        {
            e=primeiro.RetDado();
            primeiro=primeiro.RetProx();
            QtdElementos--;
            if(QtdElementos==0)
            {
                ultimo=null;
            }
        }
        return (e);
    }
    
    public void Mostra()
    {
        String Elementos="";
        Elemento el=new Elemento();
        el=primeiro;
        while(el!=null)
        {
            Elementos+=el.RetDado()+" - ";
            el=el.RetProx();
        }
        System.out.println(Elementos);
    }
}
public class fila9 {
    //Escreva uma função que tenha uma fila cujos elementos possuem um campo inteiro
    //representando sua prioridade. Quanto menor o valor deste campo, maior a prioridade
    //do elemento. Insira N elementos com prioridades diversas na fila e depois divida a fila
    //em duas, uma com elementos cuja prioridade é menor ou igual ao valor P fornecido
    //pelo usuário e outra com os elementos restantes.
    
    public static void Prioridade(Fila f,int P)
    {
        int v[] = new int [10];
        Fila f1 = new Fila();
        Object e;
        for(int i=0;i<10;i++)
        {
            e = f.Retira();
            v[i] = (int)e;
        }
        for(int i=0;i<10;i++)
        {
            if(v[i]<=P)
            {
                f.Insere(v[i]);
            }
            else
            {
                f1.Insere(v[i]);
            }
        }
        System.out.println("Fila de operações com prioridade menores ou iguais à "+P);
        f.Mostra();
        System.out.println("Fila de operações com prioridades maiores que "+P);
        f1.Mostra();
    }
    public static void main(String[] args) {
                
        Fila f = new Fila();
        Scanner x = new Scanner(System.in);
        int numeros,P;
        System.out.println("Digite 10 operações com seu grau de prioridade para serem inseridos na fila:");
        for(int i=0;i<10;i++)
        {
            numeros = x.nextInt();
            f.Insere(numeros);
        }
        System.out.println("Digite o valor de P:");
        P = x.nextInt();
        System.out.println("Fila:");
        f.Mostra();
        Prioridade(f,P);
    }
    
}
