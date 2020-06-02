
package lista1;
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

public class Lista1 {

    public static Object copia (Lista l1,Lista cp)
    {
        
        Object o;
        int t = l1.tamanho();
        for(int i=0;i<=t;i++)
        {
            cp.insereFim(l1); 
        }
     
            while (t!=0)
            {
                l1.retiraInicio();
            }
            {
            return cp;
            }
    }
    public static void main(String[] args ) {
        Scanner x = new Scanner (System.in);
        Lista l1 = new Lista ();
        int num,retorno;
        System.out.println("digite 10 numeros");
        for(int i=0;i<10;i++)
        {
            num = x.nextInt();
            l1.insereFim(num);
        }
        retorno = copia (l1,cp);
        
        System.out.println("copia"+retorno);
        
        
    }
    
}
