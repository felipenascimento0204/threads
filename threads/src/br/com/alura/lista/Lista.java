package br.com.alura.lista;

public class Lista {

    private String[] elementos = new String[1000];
    private int indice = 0;

    public synchronized void adicionarElemento(String elemento){
        this.elementos[this.indice] = elemento;
        this.indice++;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(indice == this.elementos.length){
            System.out.println("Lista cheia, notificando");
            this.notify();
        }

    }

    public String pegaElemento(int posicao){
        return this.elementos[posicao];
    }

    public int tamanho(){
        return this.elementos.length;
    }

    public boolean estaCheia() {
        return (this.tamanho() == this.indice);
    }
}
