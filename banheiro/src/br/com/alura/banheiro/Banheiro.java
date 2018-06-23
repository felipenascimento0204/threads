package br.com.alura.banheiro;

public class Banheiro {

    private boolean sujo = true;

    public void fazNumero1(){

        System.out.println(getNome() + " batendo na porta");

        synchronized (this){

            System.out.println(getNome() + " " +"Entrando no banheiro");

            while (sujo){
                esperaLaFora();
            }

            System.out.println(getNome() + " " +"Fazendo coisa rapida");
            this.sujo = true;

            dormeUmPouco(5000);

            System.out.println(getNome() + " " +"Dando descarga");
            System.out.println(getNome() + " " +"Lavando a mão");
            System.out.println(getNome() + " " +"Saindo do baneiro");

        }

    }

    private void esperaLaFora() {
        System.out.println(getNome() + " " +"Eca o banhenheiro esta sujo");
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fazNumero2(){

        System.out.println(getNome() + " batendo na porta");

        synchronized (this){

            System.out.println(getNome() + " " +"Entrando no banheiro");

            while(sujo){
                esperaLaFora();
            }

            System.out.println(getNome() + " " +"Fazendo coisa demorada");
            this.sujo = true;

            dormeUmPouco(10000);

            System.out.println(getNome() + " " +"Dando descarga");
            System.out.println(getNome() + " " +"Lavando a mão");
            System.out.println(getNome() + " " +"Saindo do baneiro");

        }

    }

    public void limpaBanheiro(){

        synchronized (this){

            System.out.println(getNome() + " " +"Entrando no banheiro");

            if(!sujo){
                System.out.println("O banheiro não está sujo");
            }

            System.out.println(getNome() + " " +"Limpando banheiro");
            this.sujo = false;

            dormeUmPouco(12000);

            this.notifyAll();

            System.out.println(getNome() + " " +"Saindo do baneiro");

        }

    }

    private void dormeUmPouco(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (Exception e) {
        }
    }

    private String getNome(){
       return Thread.currentThread().getName();
    }

}
