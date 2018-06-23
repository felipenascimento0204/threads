package br.com.alura.lista;

public class Principal {

    public static void main(String[] args) throws InterruptedException {

        Lista lista = new Lista();

        for(int i = 0; i <= 9; i++){
            new Thread(new TarefaAdicionarElemento(lista, i)).start();
        }

        new Thread(new TarefaImprimir(lista)).run();


    }

}
