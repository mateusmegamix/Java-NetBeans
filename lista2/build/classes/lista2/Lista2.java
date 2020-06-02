
package lista2;
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

    public void posDado(Object novoDado) {
        dado = novoDado;
    }

    public void posProx(Elemento novoElemento) {
        prox = novoElemento;
    }
}

class Lista {

    Elemento primeiro, ultimo;
    int tam;

    public Lista() {
        primeiro = null;
        ultimo = null;
        tam = 0;
    }

    public boolean estaVazia() {
        if (primeiro == null) {
            return true;
        }
        return false;
    }

    public void insereInicio(Object o) {
        Elemento el = new Elemento(o, null);
        if (!estaVazia()) {
            el.posProx(primeiro);
            primeiro = el;
        } else {
            primeiro = el;
            ultimo = primeiro;
        }
        tam++;
    }

    public void insereFim(Object o) {
        Elemento el = new Elemento(o, null);
        Elemento anterior = ultimo;
        ultimo = el;
        if (estaVazia()) {
            primeiro = el;
        } else {
            anterior.posProx(el);
        }
        tam++;
    }

    public void inserePosicao(int pos, Object o) {
        if (pos <= 0 || pos > tam) {
            System.out.println("Posição Inválida!");
        } else {
            if (pos == 1) {
                insereInicio(o);
            } else if (pos == tam) {
                insereFim(o);
            } else {
                Elemento el = new Elemento(o, null);
                Elemento anterior = primeiro;
                for (int i = 1; i < pos - 1; i++) {
                    anterior = anterior.retProx();
                }
                el.posProx(anterior.retProx());
                anterior.posProx(el);
                tam++;
            }
        }
    }

    public Object retiraInicio() {
        Object o = null;
        if (!estaVazia()) {
            o = primeiro.retDado();
            primeiro = primeiro.retProx();
            tam--;
            if (tam == 0) {
                ultimo = null;
            }
        }
        return (o);
    }

    public Object retiraFim() {
        Object o = null;
        if (!estaVazia()) {
            o = ultimo.retDado();
            Elemento anterior = primeiro;
            while (anterior.retProx() != ultimo && anterior != ultimo) {
                anterior = anterior.retProx();
            }
            tam--;
            if (tam == 0) {
                ultimo = null;
                primeiro = null;
            } else {
                ultimo = anterior;
                ultimo.posProx(null);
            }
        }
        return (o);
    }

    public Object retiraPosicao(int pos) {
        Object o = null;
        if (pos <= 0 || pos > tam) {
            System.out.println("Posição Inválida!");
        } else {
            if (pos == 1) {
                o = retiraInicio();
            } else if (pos == tam) {
                o = retiraFim();
            } else {
                Elemento anterior = primeiro;
                for (int i = 1; i < pos - 1; i++) {
                    anterior = anterior.retProx();
                }
                Elemento el = anterior.retProx();
                o = el.retDado();
                anterior.posProx(el.retProx());
                tam--;
            }
        }
        return (o);
    }

    public Object elementoPosicao(int pos) {
        Object o = null;
        if (pos <= 0 || pos > tam) {
            System.out.println("Posição Inválida!");
        } else {
            Elemento atual = primeiro;
            for (int i = 1; i < pos; i++) {
                atual = atual.retProx();
            }
            o = atual.retDado();
        }
        return (o);
    }

    public int tamanho() {
        return (tam);
    }

    public void mostrar() {
        String elementos = "";
        Elemento el = new Elemento();
        el = primeiro;
        while (el != null) {
            elementos += el.retDado() + " - ";
            el = el.retProx();
        }
        System.out.println(elementos);
    }

}

public class Lista2 {
    //compare duas listas para saber se são iguais...
    
        public static boolean Iguais (Lista l1, Lista l2)
        {
            Object o1;
            Object o2;
            int v1[] = new int [10];
            int v2[] =new int [10];
            int quantidade=0;
            for (int i=0; i<=10; i++)
            {
                o1 = l1.retiraInicio();
                v1[10] = (int)o1;
                o2 = l2.retiraInicio();
                v2[10] = (int)o2;
                {
                    quantidade++;
                }    
            }
            for (int i=0;i<=10;i++)
            {
                l1.insereFim(v1[i]);
                l2.insereFim(v2[i]);
            }
            if (quantidade == 10)
            {
                return true;
            }
                return false;
        }

    public static void main(String[] args) {
        
        Scanner x = new Scanner(System.in);
        Lista l1 = new Lista();
        Lista l2 = new Lista();
        int num,i;
        
        System.out.println("digite 10 numeros da primeira lista");
        for(i=1;i<=10;i++)
        {
            num = x.nextInt();
            l1.insereFim(num);
            
        }
        System.out.println("digite 10 numeros da segunda lista");
        for(i=1;i<=10;i++)
        {
            num = x.nextInt();
            l2.insereFim(num);
        }
        boolean retorno = Iguais(l1, l2);
        
        if(retorno==true)
        {
            System.out.println("São iguais");
            l1.mostrar();
            l2.mostrar();
        }
        System.out.println("São diferentes");
        l1.mostrar();
        l2.mostrar();
    }
    
    
}
