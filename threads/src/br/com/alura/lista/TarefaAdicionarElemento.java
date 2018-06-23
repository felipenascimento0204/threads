package br.com.alura.lista;

public class TarefaAdicionarElemento implements Runnable {

    private Lista lista;
    private int numeroThread;

    public TarefaAdicionarElemento(Lista lista, int numeroThread) {
        this.lista = lista;
        this.numeroThread = numeroThread;
    }

    @Override
    public void run() {

        for(int i = 0; i < 100; i++){
            this.lista.adicionarElemento("Thread: " + numeroThread + " " + i);
        }

    }
}
